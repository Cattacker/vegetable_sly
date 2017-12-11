package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import localization.LocalSettings;

public class Log implements LocalSettings {
    
    private String text;
    
    private Date date;
    
    private long planId;
    
    private int index;
    
    public Log() {
        this.date = new Date(new java.util.Date().getTime());
    }
    
    private Log(long planId, int index, Date date, String text) {
        setPlanId(planId);
        setIndex(index);
        setDate(date);
        setText(text);
    }

    @SuppressWarnings("finally")
    public static List<Log> getReverseLog(long planId) {
        List<Log> ret = new LinkedList<Log>();
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM travel_log WHERE plan_id="
                    + planId + " ORDER BY time DESC;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
                ret.add(new Log(planId, rs.getInt("log_index")
                        , rs.getDate("time"), rs.getString("text")));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }    
        finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return ret;
        }
    }
    
    @SuppressWarnings("finally")
    public static List<Log> getLog(long planId) {
        List<Log> ret = new LinkedList<Log>();
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM travel_log WHERE plan_id="
                    + planId + " ORDER BY time;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
                ret.add(new Log(planId, rs.getInt("log_index")
                        , rs.getDate("time"), rs.getString("text")));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }    
        finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return ret;
        }
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public long getPlanId() {
        return planId;
    }

    public void setPlanId(long planId) {
        this.planId = planId;
    }
}
