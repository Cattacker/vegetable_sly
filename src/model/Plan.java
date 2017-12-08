package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Plan implements localization.LocalSettings {
    public static final byte DEFAULT = 0x00;
    public static final byte TRAVEL_STATE = 0x03;
    public static final byte RELATE_STATE = 0x08;
    
    public static final byte UNSTART = 0x01;
    public static final byte TRAVELING = 0x02;
    public static final byte OVER = 0x03;
    public static final byte TEAM = 0x08;
    public static final byte PERSONAL = 0x00;
    
    
    private long id;
    
    private String userId;
    
    private long teamId;
    
    private long pathId;
    
    private byte state = 0;
    
    private Date beginningDate;
    
    private Date endingDate;
    
    private Path path;
    
    private boolean isSynchronous;
    
    private Plan(long id, String userId, long teamId, long pathId
            , byte state, Date begin, Date end) {
        this.id = id;
        this.userId = userId;
        this.teamId = teamId;
        this.pathId = pathId;
        this.state = state;
        this.setBeginningDate(begin);
        this.setEndingDate(end);
        if (begin.compareTo(Date.valueOf(LocalDate.now())) < 0)
            setUnstart();
        else if (end.compareTo(Date.valueOf(LocalDate.now())) < 0)
            setTraveling();
        else
            setOver();
        setPath(Path.getPath(pathId));
        isSynchronous = true;
    }
    
    public Plan(String userId) {
        this.userId = userId;
        this.teamId = 0;
        setPersonalPlan();
        isSynchronous = false;
    }
    
    public Plan(long teamId) {
        this.teamId = teamId;
        this.userId = null;
        setTeamPlan();
        isSynchronous = false;
    }
    
    @SuppressWarnings("finally")
    public static Plan getPlan(long id) {
        Connection conn = null;
        Statement stmt = null;
        Plan ret = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM travelplan WHERE id=" + id + ";";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String userId = rs.getString("user_id");
                long teamId = rs.getLong("team_id");
                long pathId = rs.getLong("path_id");
                byte state = rs.getByte("state");
                Date begin = rs.getDate("date_begin");
                Date end = rs.getDate("date_end");
                ret = new Plan(id, userId, teamId, pathId, state, begin, end);
            }
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
    public static List<Plan> getPlan(String userId) {
        Connection conn = null;
        Statement stmt = null;
        List<Plan> ret = new LinkedList<Plan>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM travelplan WHERE user_id='" + userId + "';";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                long id = rs.getLong("id");
                long teamId = rs.getLong("team_id");
                long pathId = rs.getLong("path_id");
                byte state = rs.getByte("state");
                Date begin = rs.getDate("date_begin");
                Date end = rs.getDate("date_end");
                Plan newPlan = new Plan(id, userId, teamId, pathId, state, begin, end);
                if (newPlan.isPersonalPlan())
                    ret.add(newPlan);
            }
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
    
    public static Plan getTeamPlan(long teamId) {
        Connection conn = null;
        Statement stmt = null;
        Plan ret = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM travelplan WHERE team_id=" + teamId + ";";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                long id = rs.getLong("id");
                String userId = rs.getString("user_id");
                long pathId = rs.getLong("path_id");
                byte state = rs.getByte("state");
                Date begin = rs.getDate("date_begin");
                Date end = rs.getDate("date_end");
                Plan newPlan = new Plan(id, userId, teamId, pathId, state, begin, end);
                if (newPlan.isTeamPlan())
                    ret = newPlan;
            }
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
    public static boolean hasPlan(long id) {
        Connection conn = null;
        Statement stmt = null;
        boolean ret = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            String sql = "SELECT 1 FROM travelPlan WHERE id='" + id + "' LIMIT 1;";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next())
                ret = true;
            rs.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
    
    public boolean isUnstart() {
        return (state & TRAVEL_STATE) == UNSTART;
    }
    
    public boolean isTraveling() {
        return (state & TRAVEL_STATE) == TRAVELING;
    }
    
    public boolean isOver() {
        return (state & TRAVEL_STATE) == OVER;
    }
    
    public boolean isTeamPlan() {
        return (state & RELATE_STATE) == TEAM;
    }
    
    public boolean isPersonalPlan() {
        return (state & RELATE_STATE) == PERSONAL;
    }
    
    public boolean isSynchronous() {
        return isSynchronous;
    }
    
    public void setUnstart() {
        state &= TRAVEL_STATE;
        state += UNSTART;
    }
    
    public void setTraveling() {
        state &= TRAVEL_STATE;
        state += TRAVELING;
    }
    
    public void setOver() {
        state &= TRAVEL_STATE;
        state += OVER;
    }
    
    public void setPersonalPlan() {
        state &= RELATE_STATE;
        state += PERSONAL;
    }
    
    public void setTeamPlan() {
        state &= RELATE_STATE;
        state += TEAM;
    }

    public Date getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
        this.pathId = path.getId();
    }

    public long getPathId() {
        return pathId;
    }

    public long getTeamId() {
        return teamId;
    }

    public String getUserId() {
        return userId;
    }

    public long getId() {
        return id;
    }
    
}
