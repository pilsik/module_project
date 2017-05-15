package by.IvkoS.domain.readers;

import au.com.bytecode.opencsv.CSVReader;
import by.IvkoS.database.models.employers.Employer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVEmployerReader extends EmployerReader implements Reader<Employer> {

    private static final Logger logger = LoggerFactory.getLogger(CSVEmployerReader.class);

    public static final int LASTNAME_INDEX_COLUMN = 0;
    public static final int FIRSTNAME_INDEX_COLUMN = 1;
    public static final int PHONE_INDEX_COLUMN = 2;
    public static final int POSITIONS_INDEX_COLUMN = 3;
    private static final char SEPARATOR = ',';
    private static final String ENCODING = "UTF8";
    private static final String REGEX = ";";

    @Override
    public List<Employer> readObjects(InputStream inputStream) {
        CSVReader reader = null;
        String[] nextLine;
        List<Employer> employerList = new ArrayList<>();
        try {
            reader = new CSVReader(new InputStreamReader(inputStream, ENCODING), SEPARATOR);
            while ((nextLine = reader.readNext()) != null) {
                Employer employer = new Employer(nextLine[LASTNAME_INDEX_COLUMN], nextLine[FIRSTNAME_INDEX_COLUMN],
                        Integer.parseInt(nextLine[PHONE_INDEX_COLUMN]));
                employer.setPositions(getPositionFromCell(nextLine[POSITIONS_INDEX_COLUMN], REGEX));
                employerList.add(employer);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Ошибка в чтении csv файла");
        } finally {
            try {
                inputStream.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("Ошибка в закрытии потока");
            } finally {
                return employerList;
            }
        }
    }


}
