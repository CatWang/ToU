package Factory;

import DAOInterface.*;
import proxy.*;

/**
 * Created by lenovo on 2015/12/3.
 */
public class DAOFactory {
    public static IUserDAO getIUserDAOInstance() {
        return new UserDAOProxy();
    }

    public static IMessageDAO getIMessageDAOInstance() {
        return new MessageDAOProxy();
    }

    public static ISpaceDAO getISpaceDAOInstance() {
        return new SpaceDAOProxy();
    }
    public static IImageDAO getIImageDAOInstance() {
        return new ImageDAOProxy();
    }
    public static IArticleDAO getIIArticleDAOInstance() {
        return new ArticleDAOProxy();
    }
    public static IRemainderDAO getIRemainderDAOInstance() {
        return new RemainderDAOProxy();
    }
    public static IDaysDAO getIDaysDAOInstance() {
        return new DaysDAOProxy();
    }
}
