package by.IvkoS.database.dao.security;

import by.IvkoS.database.models.clients.security.UserProfile;
import org.springframework.stereotype.Repository;
import by.IvkoS.database.dao.GenericDaoJpaImpl;

import java.util.List;

@Repository
public class UserProfileDaoImpl extends GenericDaoJpaImpl<UserProfile, Integer> implements UserProfileDao {

    public UserProfile findTypeByName(String type) {
        List<UserProfile> userProfileList = super.readList();
        for (UserProfile userProfile : userProfileList) {
            if(userProfile.getType().equals(type))
                return userProfile;
        }
        return UserProfile.USER_EMPTY;
    }

}
