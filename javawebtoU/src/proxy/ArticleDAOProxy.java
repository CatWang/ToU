package proxy;

import DAO.ArticleDAO;
import DAOInterface.IArticleDAO;
import db.DatabaseConnection;
import entinty.Article;

import java.util.LinkedList;

/**
 * Created by lenovo on 2015/12/4.
 */
public class ArticleDAOProxy implements IArticleDAO {
    private DatabaseConnection dbc = null;
    private IArticleDAO dao = null;

    public ArticleDAOProxy() {
        try {
            this.dbc = new DatabaseConnection();
        }catch (Exception e) {
            e.printStackTrace();
        }
        this.dao = new ArticleDAO(this.dbc.getConnection());
    }
    @Override
    public LinkedList<Article> getArticleList(String spaceID) throws Exception {
        return this.dao.getArticleList(spaceID);
    }
}
