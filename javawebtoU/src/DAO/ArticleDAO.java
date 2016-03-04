package DAO;

import DAOInterface.IArticleDAO;
import DAOInterface.IUserDAO;
import Factory.DAOFactory;
import entinty.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 * Created by lenovo on 2015/12/4.
 */
public class ArticleDAO implements IArticleDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public ArticleDAO(Connection conn) {
        this.conn = conn;
    }
    @Override
    public LinkedList<Article> getArticleList(String spaceID) throws Exception {
        LinkedList<Article> result = new LinkedList<>();
        DAOFactory factory = new DAOFactory();
        IUserDAO userDAO = factory.getIUserDAOInstance();
        try {
            String sql = "SELECT * FROM \"Article\" WHERE \"spaceID\"=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, spaceID);
            ResultSet rs = this.pstmt.executeQuery();
            while (rs.next()) {
                Article row = new Article();
                row.setArticleID(rs.getString(1));
                row.setSpaceID(rs.getString(2));
                row.setUserID(rs.getString(3));
                row.setTitile(rs.getString(4));
                row.setLiked(rs.getLong(5));
                row.setDate(rs.getDate(6));
                row.setUserName(userDAO.get(row.getUserID()).getUserName());
                result.add(row);
            }
        }catch (Exception e) {
            throw e;
        } finally {
            if (this.pstmt != null) {
                try {
                    this.pstmt.close();
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        return result;
    }
}
