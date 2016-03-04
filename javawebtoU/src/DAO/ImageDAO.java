package DAO;

import DAOInterface.IImageDAO;
import entinty.Image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 * Created by lenovo on 2015/12/4.
 */
public class ImageDAO implements IImageDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public ImageDAO(Connection conn) {
        this.conn = conn;
    }
    @Override
    public LinkedList<Image> getImageList(String spaceID) throws Exception {
        LinkedList<Image> result = new LinkedList<>();
        try {
            String sql = "SELECT * FROM \"Image\" WHERE \"spaceID\"=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, spaceID);
            ResultSet rs = this.pstmt.executeQuery();
            while (rs.next()) {
                Image row = new Image();
                row.setImageID(rs.getString(1));
                row.setSpaceID(rs.getString(2));
                row.setLiked(rs.getLong(3));
                row.setContent(rs.getString(4));
                row.setDate(rs.getDate(5));
                row.setUserID(rs.getString(6));
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

    @Override
    public boolean addImage(Image image) throws Exception {
        boolean flag = false;
        try {
            String sql = "INSERT INTO \"Image\" VALUES (?,?,?,?,?,?)";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, image.getImageID());
            this.pstmt.setString(2, image.getSpaceID());
            this.pstmt.setLong(3, image.getLiked());
            this.pstmt.setString(4, image.getContent());
            this.pstmt.setDate(5, image.getDate());
            this.pstmt.setString(6, image.getUserID());
            this.pstmt.executeUpdate();
            flag = true;
        } catch (Exception e) {
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
        return flag;
    }
}
