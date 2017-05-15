package by.IvkoS.database.services;

import by.IvkoS.database.models.clients.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User getUserById(int id);

    User findUserByLogin(String login);

    User removeUser(User user);

    User updateUser(User user);

    List<User> getUserList();

    User removeUserById(int id);

}
