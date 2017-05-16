package by.IvkoS.domain.converters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context-domain.xml")
public class EmployerConverterTest {

    @Autowired
    @Qualifier("employerConverter")
    private Converter converter;

    @Test
    public void convertFileToXML() throws Exception {
        String path = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "XSLEmployerReaderTest.xls";
        File file = new File(path);
      //  converter.convertFileToXML(new FileInputStream(file),"xls");
    }

    @Test
    public void convertFileToJSON() throws Exception {
        String path = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "CSVEmployerReaderTest.csv";
        File file = new File(path);
      //  converter.convertFileToJSON(new FileInputStream(file),"csv");
    }

}