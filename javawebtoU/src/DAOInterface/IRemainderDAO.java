package DAOInterface;

import entinty.Remainder;

import java.util.LinkedList;

/**
 * Created by lenovo on 2015/12/4.
 */
public interface IRemainderDAO {
    public LinkedList<Remainder> getRemainderList(String spaceID) throws Exception;
}
