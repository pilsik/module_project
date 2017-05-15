package by.IvkoS.domain.converters;

import by.IvkoS.database.models.employers.Employer;
import by.IvkoS.domain.dto.DataForXML;
import by.IvkoS.domain.exceptions.ExtensionRuntimeException;
import by.IvkoS.domain.readers.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.InputStream;
import java.util.List;

@Service
public class EmployerConverter extends Converter<Employer> {

    private static final Logger logger = LoggerFactory.getLogger(EmployerConverter.class);

    @Autowired
    @Qualifier("XLSEmployerReader")
    Reader xlsReader;

    @Autowired
    @Qualifier("CSVEmployerReader")
    Reader csvReader;

    DataForXML dataForXML = new DataForXML();

    @Override
    public void convertFileToXML(InputStream inputStream, String extension) throws ExtensionRuntimeException, JAXBException {
        List<Employer> tList = super.geObjectListFromFile(inputStream, extension, xlsReader, csvReader);
        dataForXML.setEmployers(tList);
        super.nameAndSaveXMLFile(dataForXML);
    }

    @Override
    public void convertFileToJSON(InputStream inputStream, String extension) throws ExtensionRuntimeException{
        List<Employer> tList = super.geObjectListFromFile(inputStream, extension, xlsReader, csvReader);
        super.nameAndSaveJSONFile(tList);
    }

}
