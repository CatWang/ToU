package DAO;

import DAOInterface.IMessageDAO;
import ID.Counter;
import entinty.Message;

import java.sql.*;
import java.util.LinkedList;

/**
 * Created by lenovo on 2015/12/4.
 */
public class MessageDAO implements IMessageDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public MessageDAO(Connection conn) {
        this.conn = conn;
    }
    @Override
    public boolean sendBindRequsetMessage(String fromUserID, String toUserID, Date date) throws Exception {
        boolean flag = false;
        try {
            String messageID = "MS" + (Counter.getInstance().getMessageCounter() + 1);
            String sql = "INSERT INTO \"Message\" (\"messageID\", \"fromUserID\", \"toUserID\", \"type\", " +
            "\"date\") VALUES (?,?,?,?,?)";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, messageID);
            this.pstmt.setString(2, fromUserID);
            this.pstmt.setString(3, toUserID);
            this.pstmt.setString(4,"sendBindRequest");
            this.pstmt.setDate(5, date);
            this.pstmt.executeUpdate();
            flag = true;
        }catch (Exception e) {
            throw e;
        } finally {
            if (this.pstmt != null) {
                try {
                    this.pstmt.close();
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        return flag;
    }

    @Override
    public LinkedList<Message> getMessageList(String userID) throws Exception {
        LinkedList<Message> result = new LinkedList<>();
        try {
            String sql = "SELECT * FROM \"Message\" WHERE \"toUserID\"=?";
            this.pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = this.pstmt.executeQuery();
            while (rs.next()) {
                Message row = new Message();
                row.setMessageID(rs.getString(1));
                row.setFromUserID(rs.getString(2));
                row.setToUserID(rs.getString(3));
                row.setType(rs.getString(4));
                row.setDate(rs.getDate(5));
                row.setArticleID(rs.getString(6));
                row.setImageID(rs.getString(7));
                row.setRemainderID(rs.getString(8));
                row.setCommentID(rs.getString(9));
                result.add(row);
            }
        }catch (SQLException e) {
            throw e;
        } finally {
            if (this.pstmt != null) {
                try {
                    this.pstmt.close();
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        return result;
    }

    @Override
    public Message getMessage(String messageID) throws Exception {
        return null;
    }

    @Override
    public boolean sendBindRefuseMessage(String fromUserID, String toUserID, Date date) throws Exception {
        boolean flag = false;
        try {
            String messageID = "MS" + (Counter.getInstance().getMessageCounter() + 1);
            String sql = "INSERT INTO \"Message\" (\"messageID\", \"fromUserID\", \"toUserID\", \"type\", " +
                    "\"date\") VALUES (?,?,?,?,?)";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, messageID);
            this.pstmt.setString(2, fromUserID);
            this.pstmt.setString(3, toUserID);
            this.pstmt.setString(4,"sendBindRefuse");
            this.pstmt.setDate(5, date);
            this.pstmt.executeUpdate();
            flag = true;
        }catch (Exception e) {
            throw e;
        } finally {
            if (this.pstmt != null) {
                try {
                    this.pstmt.close();
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        return flag;
    }

    @Override
    public boolean sendBindAcceptMessage(String fromUserID, String toUserID, Date date) throws Exception {
        boolean flag = false;
        try {
            String messageID = "MS" + (Counter.getInstance().getMessageCounter() + 1);
            String sql = "INSERT INTO \"Message\" (\"messageID\", \"fromUserID\", \"toUserID\", \"type\", " +
                    "\"date\") VALUES (?,?,?,?,?)";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, messageID);
            this.pstmt.setString(2, fromUserID);
            this.pstmt.setString(3, toUserID);
            this.pstmt.setString(4,"sendBindAccept");
            this.pstmt.setDate(5, date);
            this.pstmt.executeUpdate();
            flag = true;
        }catch (Exception e) {
            throw e;
        } finally {
            if (this.pstmt != null) {
                try {
                    this.pstmt.close();
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        return flag;
    }
}
