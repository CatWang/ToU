package proxy;

import DAO.RemianderDAO;
import DAOInterface.IRemainderDAO;
import db.DatabaseConnection;
import entinty.Remainder;

import java.util.LinkedList;

/**
 * Created by lenovo on 2015/12/4.
 */
public class RemainderDAOProxy implements IRemainderDAO {
    private DatabaseConnection dbc = null;
    private IRemainderDAO dao = null;

    public RemainderDAOProxy() {
        try {
            this.dbc = new DatabaseConnection();
        }catch (Exception e) {
            e.printStackTrace();
        }
        this.dao = new RemianderDAO(this.dbc.getConnection());
    }

    @Override
    public LinkedList<Remainder> getRemainderList(String spaceID) throws Exception {
        return this.dao.getRemainderList(spaceID);
    }
}
