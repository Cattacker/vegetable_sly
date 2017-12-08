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

import com.mysql.jdbc.PreparedStatement;

public class Plan implements localization.LocalSettings {
    public static final byte DEFAULT = 0x0;
    public static final byte TRAVEL_STATE = 0x3;
    public static final byte RELATE_STATE = 0x4;
    public static final byte RATED_STATE = 0x8;
    
    public static final byte UNSTART = 0x1;
    public static final byte TRAVELING = 0x2;
    public static final byte OVER = 0x3;
    public static final byte TEAM = 0x4;
    public static final byte PERSONAL = 0x0;
    public static final byte RATED = 0x8;
    public static final byte UNRATED = 0x0;
    
    private long id;
    
    private String userId;
    
    private long teamId;
    
    private long pathId;
    
    private byte state = 0;
    
    private Date beginningDate;
    
    private Date endingDate;
    
    private Path path;
    
    private String name;
    
    private boolean isSynchronous;
    
    private Plan(long id, String userId, long teamId, long pathId
            , byte state, Date begin, Date end, String name) {
        this.id = id;
        this.userId = userId;
        this.teamId = teamId;
        this.pathId = pathId;
        this.state = state;
        this.name = name;
        this.setBeginningDate(begin);
        this.setEndingDate(end);
        if (begin.compareTo(Date.valueOf(LocalDate.now())) < 0)
            setUnstart();
        else if (isOver() == false)
            setTraveling();
        this.path = Path.getPath(pathId);
        isSynchronous = true;
    }

    public boolean changeBeginningDate(Date beginningDate) {
        if (isUnstart() == false)
            return false;
        if (beginningDate.compareTo(Date.valueOf(LocalDate.now())) < 0)
            return false;
        this.beginningDate = beginningDate;
        isSynchronous = false;
        return true;
    }
    
    public boolean changeName(String name) {
        this.name = name;
        isSynchronous = false;
        return true;
    }
    
    public boolean changePath(Path path) {
        if (isUnstart() == false)
            return false;
        this.path = path;
        this.pathId = path.getId();
        isSynchronous = false;
        return true;
    }
    
    public boolean save() {
        if (isSynchronous())
            return true;
        return false;
    }
    
    @SuppressWarnings("finally")
    public boolean addLog(String log) {
        Connection conn = null;
        Statement stmt = null;
        boolean ret = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            stmt = conn.createStatement();
            String sql = "SELECT 1 FROM travel_log WHERE id=" + this.id + ";";
            ResultSet rs = stmt.executeQuery(sql);
            int index = 0;
            if (rs.next())
                index = rs.getFetchSize();
            rs.close();
            sql = "INSERT INTO travel_log"
                    + "(plan_id, log_index, time, log)"
                    + " VALUES(" + this.id + ", "
                    + index + ", "
                    + Date.valueOf(LocalDate.now()) + ", "
                    + "'" + log + "');";
            stmt.executeUpdate(sql);
            ret = true;
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

    
    public void setOver(Date endingDate) {
        setOver();
        setUnrated();
        this.endingDate = endingDate;
    }
    
    @SuppressWarnings("finally")
    public static Plan newPersonalPlan(String userId, Date beginningDate
            , Path path, String name) {
        long teamId = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        Plan ret = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            conn.setAutoCommit(false);
            String sql = "INSERT INTO travelplan"
                    + "(user_id, team_id, path_id, date_begin, name, state) "
                    + "VALUE (?, ?, ?, ?, ?, ?);";
            stmt = (PreparedStatement) conn.prepareStatement(sql
                    , Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, userId);
            stmt.setLong(2, teamId);
            stmt.setLong(3, path.getId());
            stmt.setDate(4, beginningDate);
            stmt.setString(5, name);
            stmt.setByte(6, (byte)(UNSTART | PERSONAL));
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
                ret = new Plan(rs.getLong("id"), userId, teamId, path.getId(),
                        (byte)(UNSTART | PERSONAL), beginningDate,
                        rs.getDate("date_end"), name);
            rs.close();
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
    public static Plan newTeamPlan(long teamId, Date beginningDate, Path path,
            String name) {
        String userId = "team";
        Connection conn = null;
        PreparedStatement stmt = null;
        Plan ret = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            conn.setAutoCommit(false);
            String sql = "INSERT INTO travelplan"
                    + "(user_id, team_id, path_id, date_begin, name, state) "
                    + "VALUE (?, ?, ?, ?, ?, ?);";
            stmt = (PreparedStatement) conn.prepareStatement(sql
                    , Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, userId);
            stmt.setLong(2, teamId);
            stmt.setLong(3, path.getId());
            stmt.setDate(4, beginningDate);
            stmt.setString(5, name);
            stmt.setByte(6, (byte)(UNSTART | TEAM));
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
                ret = new Plan(rs.getLong("id"), userId, teamId, path.getId(),
                        (byte)(UNSTART | TEAM), beginningDate,
                        rs.getDate("date_end"), name);
            rs.close();
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
    
    public boolean isRated() {
        return (state & RATED_STATE) == RATED;
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
    
    public void setRated() {
        state &= RATED_STATE;
        state += RATED;
    }
    
    public void setUnrated() {
        state &= RATED_STATE;
        state += UNRATED;
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

    public String getName() {
        return name;
    }
    
}
