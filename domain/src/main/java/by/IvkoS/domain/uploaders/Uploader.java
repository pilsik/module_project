package by.IvkoS.domain.uploaders;

import by.IvkoS.domain.exceptions.ExtensionRuntimeException;
import by.IvkoS.domain.readers.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public abstract class Uploader<T> {

    private static final Logger logger = LoggerFactory.getLogger(Uploader.class);

    protected static String XLS_EXTENSION = "xls";
    protected static String CSV_EXTENSION = "csv";

    public abstract void uploadCatalogToDB(InputStream inputStream, String extension) throws ExtensionRuntimeException;

    protected List<T> geObjectListFromFile(InputStream inputStream, String extension, Reader xlsReader, Reader csvReader) {
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

}

