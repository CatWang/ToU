package entinty;

/**
 * Created by lenovo on 2015/12/3.
 */
public class User {
    private String userID;
    private String userName;
    private String pwd;
    private String sex;
    private String loverID;
    private String spaceID;

    public String getUserID() {
        return userID;
    }

    public String getSpaceID() {
        return spaceID;
    }

    public void setSpaceID(String spaceID) {
        this.spaceID = spaceID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLoverID() {
        return loverID;
    }

    public void setLoverID(String loverID) {
        this.loverID = loverID;
    }
}
