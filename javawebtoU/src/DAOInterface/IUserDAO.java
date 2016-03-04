package DAOInterface;

import entinty.User;

/**
 * Created by lenovo on 2015/12/3.
 */
public interface IUserDAO {
    public boolean insert(User user) throws Exception;
    public boolean bindLover(String user1ID, String user2ID) throws Exception;
    public boolean find(User user) throws Exception;
    public boolean find(String id) throws Exception;
    public User get(String id) throws Exception;
    public boolean login(String id, String pwd) throws Exception;
    public boolean canbindLover(String user1ID, String user2ID) throws Exception;
    public String getSpaceID(String userID) throws Exception;
    public boolean haveSpace(String userID) throws Exception;
}
