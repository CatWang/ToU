package Action;

import DAOInterface.IImageDAO;
import DAOInterface.IUserDAO;
import Factory.DAOFactory;
import com.opensymphony.xwork2.Action;
import entinty.Image;
import entinty.User;
import org.apache.struts2.interceptor.SessionAware;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by lenovo on 2015/12/4.
 */
public class GotoSpaceAction implements Action, SessionAware {
    Map<String, Object> session;
    @Override
    public String execute() throws Exception {
        String userID = (String) session.get("userID");
        DAOFactory factory = new DAOFactory();
        IUserDAO userDAO = factory.getIUserDAOInstance();
        IImageDAO imageDAO = factory.getIImageDAOInstance();
        if (!userDAO.haveSpace(userID)) {
            return INPUT;
        } else {
            String spaceID = userDAO.getSpaceID(userID);
            User user = (User) session.get("user");
            user.setSpaceID(spaceID);
            session.put("user", user);
            LinkedList<Image> imageList = imageDAO.getImageList(spaceID);
            session.put("imageList", imageList);
            return SUCCESS;
        }
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }
}
