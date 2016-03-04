package proxy;

import DAO.UserDAO;
import DAOInterface.IUserDAO;
import db.DatabaseConnection;
import entinty.User;

/**
 * Created by lenovo on 2015/12/3.
 */
public class UserDAOProxy implements IUserDAO {
    private DatabaseConnection dbc = null;
    private IUserDAO dao = null;

    public UserDAOProxy() {
        try {
            this.dbc = new DatabaseConnection();
        }catch (Exception e) {
            e.printStackTrace();
        }
        this.dao = new UserDAO(this.dbc.getConnection());
    }

    @Override
    public String getSpaceID(String userID) throws Exception {
        return dao.getSpaceID(userID);
    }

    @Override
    public boolean haveSpace(String userID) throws Exception {
        return this.dao.haveSpace(userID);
    }

    @Override
    public boolean insert(User user) throws Exception {
        boolean flag = false;
        try {
            flag = this.dao.insert(user);
        } catch (Exception e) {
            throw e;
        }
        return flag;
    }

    @Override
    public boolean canbindLover(String user1ID, String user2ID) throws Exception {
        return dao.canbindLover(user1ID, user2ID);
    }

    @Override
    public boolean bindLover(String user1ID, String user2ID) throws Exception {
        return dao.bindLover(user1ID, user2ID);
    }

    @Override
    public boolean find(User user) throws Exception {
        return this.dao.find(user);
    }

    @Override
    public boolean find(String id) throws Exception {
        return this.dao.find(id);
    }

    @Override
    public User get(String id) throws Exception {
        return this.dao.get(id);
    }

    @Override
    public boolean login(String id, String pwd) throws Exception {
        return this.dao.login(id, pwd);
    }
}
