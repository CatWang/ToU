package DAO;

import DAOInterface.IUserDAO;
import entinty.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by lenovo on 2015/12/3.
 */
public class UserDAO implements IUserDAO{
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public UserDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public String getSpaceID(String userID) throws Exception {
        String spaceID = null;
        try {
            String sql = "SELECT \"spaceID\" FROM \"User\" WHERE \"userID\"=? ";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, userID);
            ResultSet rs = this.pstmt.executeQuery();
            if (rs.next()) {
                spaceID = rs.getString(1);
            }
        } catch (Exception e) {
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
        return spaceID;
    }

    @Override
    public boolean haveSpace(String userID) throws Exception {
        boolean flag = false;
        try {
            String sql = "SELECT * FROM \"User\" WHERE \"userID\"=? AND \"spaceID\" IS NOT NULL";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, userID);
            ResultSet rs = this.pstmt.executeQuery();
            if (rs.next()) {
                flag = true;
            }
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
    public boolean insert(User user) throws Exception {
        boolean flag = false;
        try {
            if (!find(user)) {
                String sql = "INSERT INTO \"User\" VALUES (?,?,?,?)";
                this.pstmt = this.conn.prepareStatement(sql);
                this.pstmt.setString(1, user.getUserID());
                this.pstmt.setString(2, user.getPwd());
                this.pstmt.setString(3, user.getUserName());
                this.pstmt.setString(4, user.getSex());
                this.pstmt.executeUpdate();
                flag = true;
            }
        } catch (Exception e) {
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
    public boolean canbindLover(String user1ID, String user2ID) throws Exception {
        boolean flag = false;
        try {
            String sql = "SELECT * FROM \"User\" WHERE \"UserID\"=? AND LoverID IS NULL";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, user1ID);
            ResultSet rs = this.pstmt.executeQuery();
            if (rs.next()) {
                this.pstmt.setString(1, user2ID);
                rs = this.pstmt.executeQuery();
                if (rs.next()) {
                    flag = true;
                }
            }
        } catch (Exception e) {
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
    public boolean bindLover(String user1ID, String user2ID) throws Exception {
        boolean flag = false;
        try {
            if (canbindLover(user1ID, user2ID)) {
                String sql = "UPDATE \"User\" SET \"loverID\"=? WHERE \"userID\"=?";
                this.pstmt = conn.prepareStatement(sql);
                this.pstmt.setString(1, user1ID);
                this.pstmt.setString(2, user2ID);
                pstmt.executeUpdate();
                this.pstmt.setString(1, user2ID);
                this.pstmt.setString(2, user1ID);
                pstmt.executeUpdate();
                flag = true;
            }
        } catch (Exception e) {
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
    public boolean find(User user) throws Exception {
        boolean flag = false;
        try {
            String sql = "SELECT * FROM \"User\" WHERE \"userID\"=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, user.getUserID());
            ResultSet rs = this.pstmt.executeQuery();
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (this.pstmt != null) {
                try {
                    this.pstmt.close();
                }catch (Exception e) {
                    throw e;
                }
            }
        }
        return flag;
    }

    @Override
    public boolean find(String id) throws Exception {
        boolean flag = false;
        try {
            String sql = "SELECT * FROM \"User\" WHERE \"userID\"=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, id);
            ResultSet rs = this.pstmt.executeQuery();
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (this.pstmt != null) {
                try {
                    this.pstmt.close();
                }catch (Exception e) {
                    throw e;
                }
            }
        }
        return flag;
    }

    @Override
    public User get(String id) throws Exception {
        User user = new User();
        try {
            String sql = "SELECT * FROM \"User\" WHERE \"userID\"=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, id);
            ResultSet rs = this.pstmt.executeQuery();
            if (rs.next()) {
                user.setUserID(rs.getString(1));
                user.setPwd(rs.getString(2));
                user.setUserName(rs.getString(3));
                user.setSex(rs.getString(4));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (this.pstmt != null) {
                try {
                    this.pstmt.close();
                }catch (Exception e) {
                    throw e;
                }
            }
        }
        return user;
    }

    @Override
    public boolean login(String id, String pwd) throws Exception {
        boolean flag = false;
        try {
            String sql = "SELECT * FROM \"User\" WHERE \"userID\"=? AND \"pwd\"=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, id);
            this.pstmt.setString(2, pwd);
            ResultSet rs = this.pstmt.executeQuery();
            if (rs.next()) {
                flag = true;
            }
        }catch (Exception e) {
            throw e;
        } finally {
            if (this.pstmt != null) {
                try {
                    this.pstmt.close();
                }catch (Exception e) {
                    throw e;
                }
            }
        }
        return flag;
    }
}
