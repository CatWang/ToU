package Action;

import DAOInterface.IMessageDAO;
import DAOInterface.IUserDAO;
import Factory.DAOFactory;
import com.opensymphony.xwork2.Action;
import entinty.User;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by lenovo on 2015/12/4.
 */
public class SendBindRequestAction implements Action, SessionAware {
    User user;
    Map<String, Object> session;
    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String user1ID = (String) session.get("userID");
        String user2ID = request.getParameter("loverID");
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
        Date date = Date.valueOf(sdf.format(new java.util.Date()));

        DAOFactory factory = new DAOFactory();
        IMessageDAO messageDAO = factory.getIMessageDAOInstance();
        IUserDAO userDAO = factory.getIUserDAOInstance();
        if (userDAO.canbindLover(user1ID, user2ID)) {
            if (messageDAO.sendBindRequsetMessage(user1ID, user2ID, date)) {
                return SUCCESS;
            }
        }
        return INPUT;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }
}
