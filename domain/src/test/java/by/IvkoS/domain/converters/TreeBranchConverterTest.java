package by.IvkoS.domain.converters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context-domain.xml")
public class TreeBranchConverterTest {

    @Autowired
    @Qualifier("treeBranchConverter")
    private Converter converter;

    @Test
    public void convertFileToXML() throws Exception {
        String path = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "XSLTreeBranchReaderTest.xls";
        File file = new File(path);
       // converter.convertFileToXML(new FileInputStream(file),"xls");
    }

    @Test
    public void convertFileToJSON() throws Exception {
        String path = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "CSVTreeBranchReaderTest.csv";
        File file = new File(path);
     //   converter.convertFileToJSON(new FileInputStream(file),"csv");
    }

}