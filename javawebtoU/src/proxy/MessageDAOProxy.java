package proxy;

import DAO.MessageDAO;
import DAOInterface.IMessageDAO;
import db.DatabaseConnection;
import entinty.Message;

import java.sql.Date;
import java.util.LinkedList;

/**
 * Created by lenovo on 2015/12/4.
 */
public class MessageDAOProxy implements IMessageDAO {
    private DatabaseConnection dbc = null;
    private IMessageDAO dao = null;

    public MessageDAOProxy() {
        try {
            this.dbc = new DatabaseConnection();
        }catch (Exception e) {
            e.printStackTrace();
        }
        this.dao = new MessageDAO(this.dbc.getConnection());
    }

    @Override
    public Message getMessage(String messageID) throws Exception {
        return dao.getMessage(messageID);
    }

    @Override
    public LinkedList<Message> getMessageList(String userID) throws Exception {
        return dao.getMessageList(userID);
    }

    @Override
    public boolean sendBindRequsetMessage(String fromUserID, String toUserID, Date date) throws Exception {
        return dao.sendBindRequsetMessage(fromUserID, toUserID, date);
    }

    @Override
    public boolean sendBindRefuseMessage(String fromUserID, String toUserID, Date date) throws Exception {
        return dao.sendBindRefuseMessage(fromUserID, toUserID, date);
    }

    @Override
    public boolean sendBindAcceptMessage(String fromUserID, String toUserID, Date date) throws Exception {
        return dao.sendBindAcceptMessage(fromUserID, toUserID, date);
    }
}
