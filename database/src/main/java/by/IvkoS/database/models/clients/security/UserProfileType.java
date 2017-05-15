package by.IvkoS.database.models.clients.security;

public enum UserProfileType {

    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    String userProfileType;

    private UserProfileType(String userProfileType){
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType(){
        return userProfileType;
    }
}
