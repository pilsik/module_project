package by.IvkoS.database.services;

import by.IvkoS.database.models.clients.security.UserProfile;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import by.IvkoS.database.models.clients.Address;
import by.IvkoS.database.models.clients.User;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context-db.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    int countRecords;

    @Before
    public void init() {
        countRecords = userService.getUserList().size();
    }

    @Test
    public void findUserByLogin() throws Exception {
        userService.findUserByLogin("test");
    }

    @Test
    public void addUser() throws Exception {
        Address address = new Address(1, "test", "test", "test", "test");
        Address address2 = new Address(1, "test", "test", "test", "test");
        Set<Address> addressSet = new HashSet<>();
        addressSet.add(address);
        addressSet.add(address2);
        Set<UserProfile> userProfileTypeSet = new HashSet<>();
        // userProfileTypeSet.add(userProfileDao.findTypeByName(UserProfileType.ADMIN.getUserProfileType()));
        User user = new User("test3", "test", "test", "test",
                addressSet, userProfileTypeSet, "test", 23);
        userService.addUser(user);
    }

    @Test
    public void getUser() throws Exception {
        Address address = new Address(1, "test", "test", "test", "test");
        Address address2 = new Address(1, "test", "test", "test", "test");
        Set<Address> addressSet = new HashSet<>();
        addressSet.add(address);
        addressSet.add(address2);
        User user = new User("testJunit", "testJunit", "testJunit", "testJunit",
                addressSet, "testJunit", 23);
        userService.addUser(user);
        userService.getUserById(user.getId());
    }

    @Test
    public void removeUser() throws Exception {
        Address address = new Address(1, "test", "test", "test", "test");
        Address address2 = new Address(1, "test", "test", "test", "test");
        Set<Address> addressSet = new HashSet<>();
        addressSet.add(address);
        addressSet.add(address2);
        User user = new User("testJunit", "testJunit", "testJunit", "testJunit",
                addressSet, "testJunit", 23);
        userService.addUser(user);
        userService.removeUser(userService.getUserById(user.getId()));
    }

    @Test
    public void updateUser() throws Exception {
        Address address = new Address(1, "test", "test", "test", "test");
        Address address2 = new Address(1, "test", "test", "test", "test");
        Set<Address> addressSet = new HashSet<>();
        addressSet.add(address);
        addressSet.add(address2);
        User user = new User("testJunit", "testJunit", "testJunit", "testJunit",
                addressSet, "testJunit", 23);
        userService.addUser(user);
        User user1 = userService.getUserById(user.getId());
        user1.setAge(30);
        userService.updateUser(user1);
        assertEquals((Integer) 30, userService.getUserById(user1.getId()).getAge());
    }

    @Test
    public void getUserList() throws Exception {
        Address address = new Address(1, "test", "test", "test", "test");
        Address address2 = new Address(1, "test", "test", "test", "test");
        Set<Address> addressSet = new HashSet<>();
        addressSet.add(address);
        addressSet.add(address2);
        User user = new User("testJunit", "testJunit", "testJunit", "testJunit",
                addressSet, "testJunit", 23);
        userService.addUser(user);
        Address address3 = new Address(1, "test", "test", "test", "test");
        Address address4 = new Address(1, "test", "test", "test", "test");
        Set<Address> addressSet2 = new HashSet<>();
        addressSet.add(address3);
        addressSet.add(address4);
        User user2 = new User("testJunit2", "testJunit2", "testJunit2", "testJunit2",
                addressSet2, "testJunit2", 23);
        userService.addUser(user2);
        assertEquals(userService.getUserList().size(), countRecords + 2);
    }

    @Test
    public void removeUserById() throws Exception {
        Address address = new Address(1, "test", "test", "test", "test");
        Address address2 = new Address(1, "test", "test", "test", "test");
        Set<Address> addressSet = new HashSet<>();
        addressSet.add(address);
        addressSet.add(address2);
        User user = new User("testJunit", "testJunit", "testJunit", "testJunit",
                addressSet, "testJunit", 23);
        userService.addUser(user);
        userService.removeUserById(user.getId());
        assertEquals(userService.getUserList().size(), countRecords);
    }


}