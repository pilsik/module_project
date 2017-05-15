package by.IvkoS.domain.readers;

import by.IvkoS.database.models.tree.TreeBranch;
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
public class XLSTreeBranchReader implements Reader<TreeBranch> {

    private static final Logger logger = LoggerFactory.getLogger(XLSTreeBranchReader.class);

    private static final int FIRST_INDEX_SHEET = 0;
    private static final int INDEX_COL_ID = 0;
    private static final int INDEX_COL_TEXT = 1;
    private static final int INDEX_COL_PARENT_ID = 2;

    @Override
    public List<TreeBranch> readObjects(InputStream inputStream) {
        List<TreeBranch> treeBranches = new ArrayList<>();
        HSSFWorkbook wb;
        try {
            wb = new HSSFWorkbook(inputStream);
            Sheet sheet = wb.getSheetAt(FIRST_INDEX_SHEET);
            for (Row row : sheet) {
                int id = (int) row.getCell(INDEX_COL_ID).getNumericCellValue();
                String text = row.getCell(INDEX_COL_TEXT).toString();
                int parentID = (int) row.getCell(INDEX_COL_PARENT_ID).getNumericCellValue();
                TreeBranch treeBranch = new TreeBranch(id, text, parentID);
                treeBranches.add(treeBranch);
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
                return treeBranches;
            }
        }


    }

}
