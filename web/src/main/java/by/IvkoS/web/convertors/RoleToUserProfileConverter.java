package by.IvkoS.web.convertors;

import by.IvkoS.database.models.clients.security.UserProfile;
import by.IvkoS.database.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile> {

    @Autowired
    UserProfileService userProfileService;

    @Override
    public UserProfile convert(Object o) {
        Integer id = Integer.parseInt((String) o);
        UserProfile profile = userProfileService.findById(id);
        System.out.println("Profile : " + profile);
        return profile;
    }
}
