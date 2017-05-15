package by.IvkoS.database.services;

import by.IvkoS.database.dao.security.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import by.IvkoS.database.models.clients.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User addUser(User user) {
        logger.info(String.format("old password: %s", user.getPassword()));
        if(user == User.EMPTY_USER){
            logger.error(String.format("retrurn null user"));
            return user;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        logger.info(String.format("new password: %s", user.getPassword()));
        logger.info("User add :" + user);
        return this.userDao.create(user);
    }

    @Override
    public User getUserById(int id) {
        logger.info("User get with id :" + id);
        return this.userDao.readById(id);
    }

    @Override
    public User removeUser(User user) {
        logger.info("User remove :" + user);
        return userDao.delete(user);
    }

    @Override
    public User updateUser(User user) {
        logger.info("User update :" + user);
        return this.userDao.update(user);
    }

    @Override
    public List<User> getUserList() {
        return this.userDao.readList();
    }

    @Override
    public User removeUserById(int id) {
        return this.userDao.deleteById(id);
    }

    @Override
    public User findUserByLogin(String login) {
        return this.userDao.findByLogin(login);
    }

}
