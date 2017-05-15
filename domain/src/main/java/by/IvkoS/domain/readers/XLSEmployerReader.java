package by.IvkoS.domain.readers;

import by.IvkoS.database.models.employers.Employer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class XLSEmployerReader extends EmployerReader implements Reader<Employer> {

    private static final Logger logger = LoggerFactory.getLogger(XLSEmployerReader.class);

    public static final int FIRST_INDEX_SHEET = 0;
    public static final int LASTNAME_INDEX_COLUMN = 0;
    public static final int FIRSTNAME_INDEX_COLUMN = 1;
    public static final int PHONE_INDEX_COLUMN = 2;
    public static final int POSITIONS_INDEX_COLUMN = 3;
    private static final String REGEX = ",";

    @Override
    public List<Employer> readObjects(InputStream inputStream) {
        String lastName, firstName;
        int numberPhone;
        List<Employer> listEmployers = new ArrayList<>();
        HSSFWorkbook wb;
        try {
            wb = new HSSFWorkbook(inputStream);
            Sheet sheet = wb.getSheetAt(FIRST_INDEX_SHEET);
            for (Row row : sheet) {
                lastName = row.getCell(LASTNAME_INDEX_COLUMN).toString();
                firstName = row.getCell(FIRSTNAME_INDEX_COLUMN).toString();
                numberPhone = (int) row.getCell(PHONE_INDEX_COLUMN).getNumericCellValue();
                Employer Employer = new Employer(lastName, firstName, numberPhone);
                Employer.setPositions(getPositionFromCell(row.getCell(POSITIONS_INDEX_COLUMN).toString(),REGEX));
                listEmployers.add(Employer);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Ошибка в файлe");
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("Ошибка в закрытии потока");
            } finally {
                return listEmployers;
            }
        }
    }

}
