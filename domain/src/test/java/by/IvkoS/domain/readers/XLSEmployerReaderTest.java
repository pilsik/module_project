package by.IvkoS.domain.readers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context-domain.xml")
public class XLSEmployerReaderTest {

    @Autowired
    @Qualifier("XLSEmployerReader")
    private Reader reader;

    @Test
    public void readObject() throws Exception {
        String path = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "XSLEmployerReaderTest.xls";
        File file = new File(path);
        List employerList = reader.readObjects(new FileInputStream(file));
        assertEquals(employerList.size(),10);
    }

}