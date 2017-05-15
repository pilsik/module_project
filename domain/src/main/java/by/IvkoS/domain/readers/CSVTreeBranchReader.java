package by.IvkoS.domain.readers;

import au.com.bytecode.opencsv.CSVReader;
import by.IvkoS.database.models.tree.TreeBranch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component("CSVTreeBranchReader")
public class CSVTreeBranchReader implements Reader<TreeBranch> {

    private static final Logger logger = LoggerFactory.getLogger(CSVTreeBranchReader.class);

    private static final int INDEX_COL_ID = 0;
    private static final int INDEX_COL_TEXT = 1;
    private static final int INDEX_COL_PARENT_ID = 2;
    private static final char SEPARATOR = ',';
    private static final String ENCODING = "UTF8";

    @Override
    public List<TreeBranch> readObjects(InputStream inputStream) {
        CSVReader reader = null;
        String[] nextLine;
        List<TreeBranch> listBranches = new ArrayList<>();
        try {
            reader = new CSVReader(new InputStreamReader(inputStream, ENCODING), SEPARATOR);
            while ((nextLine = reader.readNext()) != null) {
                listBranches.add(new TreeBranch(Integer.parseInt(nextLine[INDEX_COL_ID]),
                        nextLine[INDEX_COL_TEXT], Integer.parseInt(nextLine[INDEX_COL_PARENT_ID])));
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
                return listBranches;
            }
        }
    }
}
