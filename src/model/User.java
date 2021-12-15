package model;

public class User {
    private String UserId;
    private  String UserPassword;
    private  String UserName;

    public User(String userId, String userPassword, String userName) {
        UserId = userId;
        UserPassword = userPassword;
        UserName = userName;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public User(String userId) {
        UserId = userId;
    }
}
