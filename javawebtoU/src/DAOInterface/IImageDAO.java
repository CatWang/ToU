package DAOInterface;

import entinty.Image;

import java.util.LinkedList;

/**
 * Created by lenovo on 2015/12/4.
 */
public interface IImageDAO {
    public LinkedList<Image> getImageList(String spaceID) throws Exception;
    public boolean addImage(Image image) throws Exception;
}
