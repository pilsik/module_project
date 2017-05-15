package by.IvkoS.domain.converters;

import by.IvkoS.database.models.tree.TreeBranch;
import by.IvkoS.domain.dto.DataForXML;
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
public class TreeBranchConverter extends Converter<TreeBranch> {

    private static final Logger logger = LoggerFactory.getLogger(TreeBranchConverter.class);

    @Autowired
    @Qualifier("XLSTreeBranchReader")
    Reader xlsReader;

    @Autowired
    @Qualifier("CSVTreeBranchReader")
    Reader csvReader;

    DataForXML dataForXML = new DataForXML();

    @Override
    public void convertFileToXML(InputStream inputStream, String extension) throws JAXBException {
        List<TreeBranch> tList = super.geObjectListFromFile(inputStream, extension, xlsReader, csvReader);
        dataForXML.setBranches(tList);
        super.nameAndSaveXMLFile(dataForXML);
    }

    @Override
    public void convertFileToJSON(InputStream inputStream, String extension) {
        List<TreeBranch> tList = super.geObjectListFromFile(inputStream, extension, xlsReader, csvReader);
        super.nameAndSaveJSONFile(tList);
    }
}
