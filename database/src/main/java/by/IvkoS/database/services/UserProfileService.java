package by.IvkoS.database.services;

import by.IvkoS.database.models.clients.security.UserProfile;

import java.util.List;

public interface UserProfileService {

    List<UserProfile> getAllList();
    UserProfile findById(int id);
}
