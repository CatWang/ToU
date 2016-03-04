package DAO;

import DAOInterface.ISpaceDAO;
import DAOInterface.IUserDAO;
import Factory.DAOFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by lenovo on 2015/12/4.
 */
public class SpaceDAO implements ISpaceDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public SpaceDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean insert(String spaceID, String user1ID, String user2ID) throws Exception {
        boolean flag = false;
        DAOFactory factory = new DAOFactory();
        IUserDAO dao = factory.getIUserDAOInstance();
        try {
            String sql = "INSERT INTO \"Space\" VALUES (?,?,?,?)";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, spaceID);
            this.pstmt.setString(2, user1ID);
            this.pstmt.setString(3, user2ID);
            this.pstmt.setString(4, dao.get(user1ID).getUserName()+" AND "+ dao.get(user2ID).getUserName() + "'S SPACE");
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
