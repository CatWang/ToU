package Action;

import DAOInterface.IUserDAO;
import Factory.DAOFactory;
import entinty.User;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by lenovo on 2015/12/3.
 */
public class LoginAction implements com.opensymphony.xwork2.Action, SessionAware {
    User user;
    Map<String, Object> session;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String userID = request.getParameter("userID");
        String pwd = request.getParameter("pwd");

        try {
            DAOFactory factory = new DAOFactory();
            IUserDAO userDAO = factory.getIUserDAOInstance();
            if (userDAO.login(userID, pwd)) {
                user = userDAO.get(userID);
                session.put("user", user);
                session.put("userID", userID);
                return SUCCESS;
            }
            return INPUT;
        } catch (Exception e) {
            e.printStackTrace();
      }
        return null;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }
}
