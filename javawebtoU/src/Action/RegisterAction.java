package Action;

import DAOInterface.IUserDAO;
import Factory.DAOFactory;
import com.opensymphony.xwork2.Action;
import entinty.User;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
/**
 * Created by lenovo on 2015/12/3.
 */
public class RegisterAction implements Action, SessionAware{
    private User user;
    private Map<String, Object> session;
    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        user.setUserID(request.getParameter("userID"));
        user.setPwd(request.getParameter("pwd"));
        user.setUserName(request.getParameter("userName"));
        user.setSex(request.getParameter("sex"));

        DAOFactory factory = new DAOFactory();
        IUserDAO userDAO = factory.getIUserDAOInstance();
        if (userDAO.insert(user)) {
            session.put("user",user);
            session.put("userID", user.getUserID());
            return SUCCESS;
        }
        return INPUT;

    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }
}
