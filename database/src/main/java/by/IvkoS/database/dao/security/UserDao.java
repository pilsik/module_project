package by.IvkoS.database.dao.security;


import by.IvkoS.database.dao.GenericDao;
import by.IvkoS.database.models.clients.User;

public interface UserDao extends GenericDao<User, Integer> {
    User findByLogin(String login);
}
