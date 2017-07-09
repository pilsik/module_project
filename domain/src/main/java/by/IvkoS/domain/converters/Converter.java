package by.IvkoS.domain.converters;

import by.IvkoS.domain.dto.DataForXML;
import by.IvkoS.domain.exceptions.ExtensionRuntimeException;
import by.IvkoS.domain.readers.Reader;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.io.*;

public abstract class Converter<T> {

    private static final Logger logger = LoggerFactory.getLogger(Converter.class);

    public static final String XML_EXTENSION = "xml";
    public static final String JSON_EXTENSION = "json";
    public static final String CSV_EXTENSION = "csv";
    public static final String XLS_EXTENSION = "xls";
    private static final String DATE_PATTERN = "yyyy-MM-dd-HH-mm-ss";

    public abstract void convertFileToXML(InputStream inputStream, String extension, String filepath) throws JAXBException;

    public abstract void convertFileToJSON(InputStream inputStream, String extension, String filepath);

    List<T> geObjectListFromFile(InputStream inputStream, String extension, Reader xlsReader, Reader csvReader) {
        List<T> tList = Collections.emptyList();
        if (extension.equals(XLS_EXTENSION)) {
            tList = xlsReader.readObjects(inputStream);
        } else if (extension.equals(CSV_EXTENSION)) {
            tList = csvReader.readObjects(inputStream);
        } else {
            String message = String.format("Данный расширение не поддерживается %s", extension);
            logger.warn(message);
            throw new ExtensionRuntimeException(message);
        }
        return tList;
    }

    String nameAndSaveJSONFile(List<T> tList, String filepath) {
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        String jsonList = gson.toJson(tList);
        String fileName = String.format("%s.%s", new SimpleDateFormat(DATE_PATTERN).format(new Date()), JSON_EXTENSION);
        File file = new File(filepath+fileName);
        try(FileWriter writer = new FileWriter(file, false)){
            writer.write(jsonList);
            writer.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
        logger.info(String.format("Создан файл json путь %s", file.getAbsoluteFile()));
        return fileName;
    }

    String nameAndSaveXMLFile(DataForXML dataForXML,String filepath) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(DataForXML.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        String fileName = String.format("%s.%s", new SimpleDateFormat(DATE_PATTERN).format(new Date()), XML_EXTENSION);
        File file = new File(filepath+fileName);
        jaxbMarshaller.marshal(dataForXML, file);
        logger.info(String.format("Создан файл xml путь %s", file.getAbsoluteFile()));
        return fileName;
    }
}
