package by.IvkoS.database.services;

import by.IvkoS.database.models.employers.Employer;
import by.IvkoS.database.models.employers.Position;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context-db.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class EmployerServiceImplTest {

    @Autowired
    EmployerService employerService;

    @Test
    public void addEmployer() throws Exception {
        int count = employerService.getEmployerList().size();
        Position position = new Position("test");
        Employer employer = new Employer("test","test", 123);
        position.addEmployer(employer);
        employer.addPosition(position);
        employerService.addEmployer(employer);
        assertEquals(employerService.getEmployerList().size(),count+1);
    }

    @Test
    public void getEmployerById() throws Exception {
        Position position = new Position("test");
        Employer employer = new Employer("test","test", 123);
        position.addEmployer(employer);
        employer.addPosition(position);
        employerService.addEmployer(employer);
        Employer employer1 = employerService.findEmployerByName("test");
        Assert.assertEquals(employerService.getEmployerById(employer1.getIdEmployer()).getNumberPhone(),123);
    }

    @Test
    public void findEmployerByName() throws Exception {
        Position position = new Position("test");
        Employer employer = new Employer("test","test", 123);
        position.addEmployer(employer);
        employer.addPosition(position);
        employerService.addEmployer(employer);
        Assert.assertEquals(employerService.findEmployerByName("test").getNumberPhone(),123);
    }

    @Test
    public void removeEmployer() throws Exception {
        int count = employerService.getEmployerList().size();
        Position position = new Position("test");
        Employer employer = new Employer("test","test", 123);
        position.addEmployer(employer);
        employer.addPosition(position);
        employerService.addEmployer(employer);
        assertEquals(employerService.getEmployerList().size(),count+1);
        employerService.removeEmployer(employer);
        assertEquals(employerService.getEmployerList().size(),count);
    }

    @Test
    public void updateEmployer() throws Exception {
        Position position = new Position("testJunit");
        Employer employer = new Employer("testJunit","testJunit", 123);
        position.addEmployer(employer);
        employer.addPosition(position);
        employerService.addEmployer(employer);
        employer.setNumberPhone(321);
        employerService.updateEmployer(employer);
        Assert.assertEquals(employerService.findEmployerByName("testJunit").getNumberPhone(),321 );
    }

    @Test
    public void getEmployerList() throws Exception {
        int count = employerService.getEmployerList().size();
        Position position = new Position("test");
        Employer employer = new Employer("test","test", 123);
        position.addEmployer(employer);
        employer.addPosition(position);
        employerService.addEmployer(employer);
        assertEquals(employerService.getEmployerList().size(),count+1);
    }

    @Test
    public void removeEmployerById() throws Exception {
        int count = employerService.getEmployerList().size();
        Position position = new Position("test");
        Employer employer = new Employer("test","test", 123);
        position.addEmployer(employer);
        employer.addPosition(position);
        employerService.addEmployer(employer);
        employerService.removeEmployerById(employer.getIdEmployer());
        assertEquals(employerService.getEmployerList().size(),count);
    }

    @Test
    public void addEmployerList() throws Exception {
        int count = employerService.getEmployerList().size();
        Position position = new Position("test");
        Employer employer = new Employer("test","test", 123);
        position.addEmployer(employer);
        employer.addPosition(position);
        Position position2 = new Position("test2");
        Employer employer2 = new Employer("test2","test2", 123);
        position2.addEmployer(employer2);
        employer2.addPosition(position2);
        List<Employer> employerList = new ArrayList<>();
        employerList.add(employer);
        employerList.add(employer2);
        employerService.addEmployerList(employerList);
        assertEquals(employerService.getEmployerList().size(),count+2);
    }

}