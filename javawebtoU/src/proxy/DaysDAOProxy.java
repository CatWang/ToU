package proxy;

import DAO.DaysDAO;
import DAOInterface.IDaysDAO;
import db.DatabaseConnection;
import entinty.Days;

import java.util.LinkedList;

/**
 * Created by lenovo on 2015/12/4.
 */
public class DaysDAOProxy implements IDaysDAO {
    private DatabaseConnection dbc = null;
    private IDaysDAO dao = null;

    public DaysDAOProxy() {
        try {
            this.dbc = new DatabaseConnection();
        }catch (Exception e) {
            e.printStackTrace();
        }
        this.dao = new DaysDAO(this.dbc.getConnection());
    }
    @Override
    public LinkedList<Days> getDaysList(String spaceID) throws Exception {
        return this.dao.getDaysList(spaceID);
    }

    @Override
    public boolean addDays(Days days) throws Exception {
        return this.dao.addDays(days);
    }
}
