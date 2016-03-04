package DAOInterface;

import entinty.Message;

import java.sql.Date;
import java.util.LinkedList;

/**
 * Created by lenovo on 2015/12/4.
 */
public interface IMessageDAO {
    public boolean sendBindRequsetMessage(String fromUserID, String toUserID, Date date) throws Exception;
    public boolean sendBindRefuseMessage(String fromUserID, String toUserID, Date date) throws Exception;
    public boolean sendBindAcceptMessage(String fromUserID, String toUserID, Date date) throws Exception;
    public LinkedList<Message> getMessageList(String userID) throws Exception;
    public Message getMessage(String messageID) throws Exception;
}
