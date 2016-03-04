package Action;

import DAOInterface.IImageDAO;
import Factory.DAOFactory;
import ID.Counter;
import com.opensymphony.xwork2.Action;
import entinty.Image;
import entinty.User;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by lenovo on 2015/12/4.
 */
public class AddImageAction implements Action, SessionAware {
    Map<String, Object> session;
    private File image;
    private String imageFileName;
    private String imageContentType;

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        Image imageItem = new Image();
        User user = (User) session.get("user");
        String spaceID = user.getSpaceID();
        String imageID = "IM"+(Counter.getInstance().getImageCounter()+1);
        imageItem.setImageID(imageID);
        imageItem.setSpaceID(spaceID);
        imageItem.setLiked(0);
        imageItem.setContent(request.getParameter("content"));
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
        imageItem.setDate(java.sql.Date.valueOf(sdf.format(new Date())));
        imageItem.setUserID(user.getUserID());
        DAOFactory factory = new DAOFactory();
        IImageDAO imageDAO = factory.getIImageDAOInstance();
        if (imageDAO.addImage(imageItem)) {
            String realpath = "../../web/images" + imageID + ".jpg";
            OutputStream os = new FileOutputStream(new File(realpath, imageFileName));
            InputStream is = new FileInputStream(image);

            byte[] buf = new byte[1024];
            int length = 0;

            while (-1 != (length = is.read(buf))) {
                os.write(buf, 0, length);
            }
            is.close();
            os.close();


            return SUCCESS;
        }
        return INPUT;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }
}
