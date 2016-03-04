package DAOInterface;

import entinty.Article;

import java.util.LinkedList;

/**
 * Created by lenovo on 2015/12/4.
 */
public interface IArticleDAO {
    public LinkedList<Article> getArticleList(String spaceID) throws Exception;
}
