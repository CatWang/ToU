package DAO;

import DAOInterface.IRemainderDAO;
import DAOInterface.IUserDAO;
import Factory.DAOFactory;
import entinty.Remainder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 * Created by lenovo on 2015/12/4.
 */
public class RemianderDAO implements IRemainderDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public RemianderDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public LinkedList<Remainder> getRemainderList(String spaceID) throws Exception {
        LinkedList<Remainder> result = new LinkedList<>();
        DAOFactory factory = new DAOFactory();
        IUserDAO userDAO = factory.getIUserDAOInstance();
        try {
            String sql = "SELECT * FROM \"Remainder\" WHERE \"spaceID\"=?";
            this.pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = this.pstmt.executeQuery();
            while (rs.next()) {
                Remainder row = new Remainder();
                row.setRemainderID(rs.getString(1));
                row.setSpaceID(rs.getString(2));
                row.setUserID(rs.getString(3));
                row.setDate(rs.getDate(4));
                row.setContent(rs.getString(5));
                row.setLiked(rs.getShort(6));
                row.setUserName(userDAO.get(row.getUserID()).getUserName());
                result.add(row);
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
        return result;
    }
}
