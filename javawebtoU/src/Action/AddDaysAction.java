package Action;

import com.opensymphony.xwork2.Action;
import entinty.User;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.Date;
import java.util.Map;

/**
 * Created by lenovo on 2015/12/4.
 */
public class AddDaysAction implements Action, SessionAware {
    Map<String, Object> session;
    private String dayName;
    private String year;
    private String month;
    private String day;

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }

    @Override
    public String execute() throws Exception {
        User user = (User) session.get("user");
        String spaceID = user.getSpaceID();
        String date = year+"-"+month+"-"+day;
        Date date1 = Date.valueOf(date);
        return null;
    }
}
