package entinty;

import java.sql.Date;

/**
 * Created by lenovo on 2015/12/3.
 */
public class RemainderComment {
    private String remainderID;
    private String content;
    private String userID;
    private Date date;
    private String commentID;

    public String getRemainderID() {
        return remainderID;
    }

    public void setRemainderID(String remainderID) {
        this.remainderID = remainderID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }
}
