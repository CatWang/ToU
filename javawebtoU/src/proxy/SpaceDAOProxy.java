package proxy;

import DAO.SpaceDAO;
import DAOInterface.ISpaceDAO;
import db.DatabaseConnection;

/**
 * Created by lenovo on 2015/12/4.
 */
public class SpaceDAOProxy implements ISpaceDAO {
    private DatabaseConnection dbc = null;
    private ISpaceDAO dao = null;

    public SpaceDAOProxy() {
        try {
            this.dbc = new DatabaseConnection();
        }catch (Exception e) {
            e.printStackTrace();
        }
        this.dao = new SpaceDAO(this.dbc.getConnection());
    }
    @Override
    public boolean insert(String spaceID, String user1ID, String user2ID) throws Exception {
        return dao.insert(spaceID, user1ID, user2ID);
    }
}
