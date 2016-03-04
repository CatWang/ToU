package Action;

import DAOInterface.IArticleDAO;
import Factory.DAOFactory;
import com.opensymphony.xwork2.Action;
import entinty.User;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by lenovo on 2015/12/4.
 */
public class GoToArticleAction implements Action, SessionAware {
    Map<String, Object> session;
    @Override
    public String execute() throws Exception {
        User user = (User) session.get("user");
        String spaceID = user.getSpaceID();
        DAOFactory factory = new DAOFactory();
        IArticleDAO articleDAO = factory.getIIArticleDAOInstance();
        session.put("article", articleDAO.getArticleList(spaceID));
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }
}
