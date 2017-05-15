package by.IvkoS.jms.consumers;

import by.IvkoS.database.models.employers.Employer;
import by.IvkoS.database.models.tree.TreeBranch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context-jms.xml")
public class CatalogJmsSenderTest {

    @Autowired
    CatalogJmsSender catalogJmsSender;

    @Test
    public void sendMessages() throws Exception {
        String path = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "CSVTreeBranchReaderTest.csv";
        File file = new File(path);
        TreeBranch treeBranch = new TreeBranch();
        System.out.println(treeBranch.getClass().getSimpleName());
        /*catalogJmsSender.sendMessages(file, "csv", "json", treeBranch.getClass().getSimpleName());
        catalogJmsSender.sendMessages(file, "csv", "xml", treeBranch.getClass().getSimpleName());*/
        Thread.sleep(5000);
        path = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "CSVEmployerReaderTest.csv";
        file = new File(path);
        Employer employer = new Employer();
        System.out.println(employer.getClass().getSimpleName());
        /*catalogJmsSender.sendMessages(file, "csv", "json", employer.getClass().getSimpleName());
        catalogJmsSender.sendMessages(file, "csv", "xml", employer.getClass().getSimpleName());*/
        Thread.sleep(1000);
    }

}