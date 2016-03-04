package proxy;

import DAO.ImageDAO;
import DAOInterface.IImageDAO;
import db.DatabaseConnection;
import entinty.Image;

import java.util.LinkedList;

/**
 * Created by lenovo on 2015/12/4.
 */
public class ImageDAOProxy implements IImageDAO {
    private DatabaseConnection dbc = null;
    private IImageDAO dao = null;

    public ImageDAOProxy() {
        try {
            this.dbc = new DatabaseConnection();
        }catch (Exception e) {
            e.printStackTrace();
        }
        this.dao = new ImageDAO(this.dbc.getConnection());
    }
    @Override
    public LinkedList<Image> getImageList(String spaceID) throws Exception {
        return this.dao.getImageList(spaceID);
    }

    @Override
    public boolean addImage(Image image) throws Exception {
        return this.dao.addImage(image);
    }
}
