package entinty;

import java.sql.Date;

/**
 * Created by lenovo on 2015/12/3.
 */
public class Remainder {
    private String remainderID;
    private String spaceID;
    private String userID;
    private Date date;
    private String content;
    private long liked;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRemainderID() {
        return remainderID;
    }

    public void setRemainderID(String remainderID) {
        this.remainderID = remainderID;
    }

    public String getSpaceID() {
        return spaceID;
    }

    public void setSpaceID(String spaceID) {
        this.spaceID = spaceID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getLiked() {
        return liked;
    }

    public void setLiked(long liked) {
        this.liked = liked;
    }
}