package DAO;

import DAOInterface.IDaysDAO;
import entinty.Days;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 * Created by lenovo on 2015/12/4.
 */
public class DaysDAO implements IDaysDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public DaysDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public LinkedList<Days> getDaysList(String spaceID) throws Exception {
        LinkedList<Days> result = new LinkedList<>();
        try {
            String sql = "SELECT * FROM \"Days\" WHERE \"spaceID\"=?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, spaceID);
            ResultSet rs = this.pstmt.executeQuery();
            while (rs.next()) {
                Days row = new Days();
                row.setSpaceID(rs.getString(1));
                row.setDayID(rs.getString(2));
                row.setDaysName(rs.getString(3));
                row.setBegin(rs.getDate(4));
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
    public boolean addDays(Days days) throws Exception {
        boolean flag = false;
        return flag;
    }
}
