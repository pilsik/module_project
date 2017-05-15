package by.IvkoS.database.models.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context-db.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class TreeCreatorTest {

    @Autowired
    TreeCreator treeCreator;

    @Test
    public void createTree() throws Exception {
        String path = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.json";
        File file = new File(path);
        System.out.println(file.getAbsolutePath());
        String treeJson = treeCreator.createTree();
        PrintWriter writer = new PrintWriter(file.getAbsoluteFile(), "UTF-8");
        writer.print(treeJson);
        writer.flush();
        writer.close();
        System.out.println(treeJson);
    }

}