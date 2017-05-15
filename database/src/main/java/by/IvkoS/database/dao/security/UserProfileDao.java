package by.IvkoS.database.dao.security;

import by.IvkoS.database.models.clients.security.UserProfile;
import by.IvkoS.database.dao.GenericDao;

public interface UserProfileDao extends GenericDao<UserProfile,Integer> {
    UserProfile findTypeByName(String type);
}
