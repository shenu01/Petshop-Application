package view.tm;

public class UserTM {
    private String UserId;
    private  String UserPassword;
    private  String UserName;

    public UserTM(String userId, String userPassword, String userName) {
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

    public UserTM(String userId) {
        UserId = userId;
    }
}
