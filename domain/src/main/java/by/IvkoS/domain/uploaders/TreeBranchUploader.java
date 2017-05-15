package by.IvkoS.domain.uploaders;

import by.IvkoS.database.models.tree.TreeBranch;
import by.IvkoS.database.services.TreeBranchService;
import by.IvkoS.domain.exceptions.ExtensionRuntimeException;
import by.IvkoS.domain.readers.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class TreeBranchUploader extends Uploader<TreeBranch> {

    private static final Logger logger = LoggerFactory.getLogger(TreeBranchUploader.class);

    @Autowired
    @Qualifier("CSVTreeBranchReader")
    Reader csvReader;

    @Autowired
    @Qualifier("XLSTreeBranchReader")
    Reader xlsReader;

    @Autowired
    TreeBranchService treeBranchService;

    @Override
    public void uploadCatalogToDB(InputStream inputStream, String extension) throws ExtensionRuntimeException {
        treeBranchService.addTreeBranchList(super.geObjectListFromFile(inputStream, extension, xlsReader, csvReader));
    }
}
