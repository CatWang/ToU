package DAOInterface;

import entinty.Days;

import java.util.LinkedList;

/**
 * Created by lenovo on 2015/12/4.
 */
public interface IDaysDAO {
    public LinkedList<Days> getDaysList(String spaceID) throws  Exception;
    public boolean addDays(Days days) throws Exception;
}
