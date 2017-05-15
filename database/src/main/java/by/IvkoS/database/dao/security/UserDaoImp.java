package by.IvkoS.database.dao.security;

import org.springframework.stereotype.Repository;
import by.IvkoS.database.dao.GenericDaoJpaImpl;
import by.IvkoS.database.models.clients.User;

import java.util.List;


@Repository
public class UserDaoImp extends GenericDaoJpaImpl<User, Integer> implements UserDao {

    private final int INDEX_FIRST_USER_AT_LIST = 0;

    @Override
    public User findByLogin(String login) {
        List<User> client = (List<User>) super.hibernateTemplate
                .findByNamedParam("from User as client where client.login=:login", "login", new Object[]{login});
        return (client.size() != 0) ? client.get(INDEX_FIRST_USER_AT_LIST) : User.EMPTY_USER;
    }
}
