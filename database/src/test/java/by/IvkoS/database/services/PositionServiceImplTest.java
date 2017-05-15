package by.IvkoS.database.services;

import by.IvkoS.database.models.employers.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context-db.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class PositionServiceImplTest {

    @Autowired
    PositionService positionService;

    @Test
    public void addPosition() throws Exception {
        int countRecord = positionService.getPositionList().size();
        Position position = new Position("test");
        positionService.addPosition(position);
        assertEquals(countRecord+1,positionService.getPositionList().size());
    }

    @Test
    public void getPositionById() throws Exception {
        Position position = new Position ("test");
        positionService.addPosition(position);
        Position positionTest = positionService.getPositionById(positionService.findPositionByName("test").getPositionID());
        assertTrue(position.equals(positionTest));
    }

    @Test
    public void findPositionByName() throws Exception {
        Position position = new Position("test");
        positionService.addPosition(position);
        Position positionTest = positionService.findPositionByName(position.getPositionName());
        assertTrue(position.equals(positionTest));
    }

    @Test
    public void removePosition() throws Exception {
        int countRecord = positionService.getPositionList().size();
        Position position = new Position("test");
        positionService.addPosition(position);
        positionService.removePosition(position);
        assertEquals(countRecord,positionService.getPositionList().size());
    }

    @Test
    public void updatePosition() throws Exception {
        Position position = new Position("test");
        positionService.addPosition(position);
        Position positionTest = positionService.findPositionByName("test");
        positionTest.setPositionName("testtest");
        positionService.updatePosition(positionTest);
        assertTrue(positionService.findPositionByName("testtest").getPositionName().equals("testtest"));
    }

    @Test
    public void getPositionList() throws Exception {
        assertEquals(positionService.getPositionList().size(),positionService.getPositionList().size());
    }

    @Test
    public void removePositionById() throws Exception {
        int countRecord = positionService.getPositionList().size();
        Position position = new Position("test");
        positionService.addPosition(position);
        positionService.removePositionById(position.getPositionID());
        assertEquals(countRecord,positionService.getPositionList().size());
    }

}