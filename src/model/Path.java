package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.mysql.jdbc.PreparedStatement;

public class Path implements localization.LocalSettings {
    
    private List<Location> locations;
    
    private long id = 0;
    
    private int hashCode;
    
    private boolean isSynchronous;
    
    private Path(ArrayList<Location> locations, long id) {
        this.locations = locations;
        this.id = id;
        this.hashCode = locations.hashCode();
        this.isSynchronous = true;
    }
    
    public Path() {
        locations = new LinkedList<Location>();
        id = 0;
        isSynchronous = false;
    }
    
    public boolean add(String location) {
        boolean ret = Location.hasLocation(location);
        locations.add(Location.getLocation(location));
        isSynchronous = false;
        return ret;
    }
    
    public boolean set(int index, String location) {
        locations.set(index, Location.getLocation(location));
        isSynchronous = false;
        return Location.hasLocation(location);
    }
    
    public boolean add(int index, String location) {
        locations.add(index, Location.getLocation(location));
        isSynchronous = false;
        return Location.hasLocation(location);
    }
    
    public boolean save() {
        if (isSynchronous())
            return false;
        this.hashCode = locations.hashCode();
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean ret = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            conn.setAutoCommit(false);
            String sql = "INSERT INTO path(start_id, end_id, path_size, hash_code) "
                    + "VALUE (?, ?, ?, ?);";
            stmt = (PreparedStatement) conn.prepareStatement(sql
                    , Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, getStart().getId());
            stmt.setLong(2, getEnd().getId());
            stmt.setInt(3, getSize());
            stmt.setInt(4, hashCode());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
                this.id = rs.getLong("path_id");
            rs.close();
            stmt.close();
            sql = "INSERT INTO "
                    + "path_struct(path_id, location_id, location_index) "
                    + "VALUE (?, ?, ?);";
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            int i = 0;
            for (Location location : locations) {
                stmt.setLong(1, this.id);
                stmt.setLong(2, location.getId());
                stmt.setInt(3, i);
                stmt.addBatch();
            }
            stmt.executeBatch();
            conn.commit();
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
    
    public boolean isSynchronous() {
        return isSynchronous;
    }
    
    public boolean isExist() {
        return !(getEquivalentPathId() == 0);
    }
    
    public Path getEquivalentPath() {
        return getPath(getEquivalentPathId());
    }
    
    @SuppressWarnings("finally")
    public long getEquivalentPathId() {
        if (isSynchronous())
            return this.id;
        this.hashCode = this.locations.hashCode();
        Connection conn = null;
        Statement stmt = null;
        long ret = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            String sql = "SELECT * FROM path WHERE hash_code=" + hashCode() + ";";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (Objects.equals(rs.getInt("size"), size())
                        && Objects.equals(getStart().getId() 
                                , rs.getLong("start_id"))
                        && Objects.equals(getEnd().getId()
                                , rs.getLong("end_id"))) {
                    sql = "SELECT * FROM path_struct"
                            + " WHERE path_id=" + rs.getLong("path_id")
                            + " ORDER BY location_index";
                    ResultSet temp = stmt.executeQuery(sql);
                    boolean isEqual = false;
                    if (locations.size() == temp.getFetchSize()) {
                        isEqual = true;
                        for (Location location : locations) {
                            temp.next();
                            if (temp.getLong("location_id")
                                    != location.getId()){
                                isEqual = false;
                                break;
                            }
                        }
                    }
                    temp.close();
                    if (isEqual) {
                        ret = rs.getLong("path_id");
                        break;
                    }
                }
            }
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
    
    @SuppressWarnings("finally")
    public static Path getPath(long id) {
        Connection conn = null;
        Statement stmt = null;
        Path ret = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM path_struct WHERE path_id=" + id + ";";
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Location> locations = new ArrayList<Location>(rs.getFetchSize());
            while (rs.next()) {
                int index = rs.getInt("location_index");
                long location_id = rs.getLong("location_id");
                locations.set(index, Location.getLocation(location_id));
            }
            if (locations.isEmpty() == false)
                ret = new Path(locations, id);
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

    public Location getStart() {
        if (locations.getClass() == LinkedList.class)
            return ((LinkedList<Location>)locations).getFirst();
        if (locations.getClass() == ArrayList.class)
            return ((ArrayList<Location>)locations).get(0);
        return null;
    }
    
    public Location getEnd() {
        if (locations.getClass() == LinkedList.class)
            return ((LinkedList<Location>)locations).getLast();
        if (locations.getClass() == ArrayList.class)
            return ((ArrayList<Location>)locations).get(locations.size() - 1);
        return null;
    }
    
    public int size() {
        return locations.size();
    }
    
    public int getSize() {
        return locations.size();
    }
    
    @Override
    public int hashCode() {
        return hashCode;
    }
    
    public long getId() {
        return id;
    }

    public List<Location> getLocations() {
        return locations;
    }
}
