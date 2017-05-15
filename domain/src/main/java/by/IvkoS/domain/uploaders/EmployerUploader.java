package by.IvkoS.domain.uploaders;

import by.IvkoS.database.models.employers.Employer;
import by.IvkoS.database.services.EmployerService;
import by.IvkoS.domain.exceptions.ExtensionRuntimeException;
import by.IvkoS.domain.readers.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class EmployerUploader extends Uploader<Employer> {

    private static final Logger logger = LoggerFactory.getLogger(EmployerUploader.class);

    @Autowired
    @Qualifier("CSVEmployerReader")
    Reader csvReader;

    @Autowired
    @Qualifier("XLSEmployerReader")
    Reader xlsReader;

    @Autowired
    EmployerService employerService;

    @Override
    public void uploadCatalogToDB(InputStream inputStream, String extension) throws ExtensionRuntimeException {
        employerService.addEmployerList(super.geObjectListFromFile(inputStream, extension, xlsReader, csvReader));
    }
}
