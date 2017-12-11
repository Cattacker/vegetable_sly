package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import com.mysql.jdbc.PreparedStatement;

public class Path implements localization.LocalSettings {
    
    private List<Location> locations;
    
    private long id = 0;
    
    private int hashCode;
    
    private int rateSize;
    
    private double rate;
    
    private boolean isSynchronous;
    
    
    
    private Path(List<Location> locations, long id
            , int rateSize, double rate) {
        this.locations = locations;
        this.id = id;
        this.hashCode = locations.hashCode();
        this.isSynchronous = true;
        this.rateSize = rateSize;
        this.rate = rate;
    }
    
    public Path() {
        locations = new LinkedList<Location>();
        id = 0;
        rateSize = 0;
        rate = 0.0;
        isSynchronous = false;
    }
    
    public boolean add(String location) {
        boolean ret = Location.hasLocation(location);
        Location.addLocation(location);
        locations.add(Location.getLocation(location));
        isSynchronous = false;
        Path path = getEquivalentPath();
        if (path == null) {
            isSynchronous = false;
            rate = 0.0;
            rateSize = 0;
        } else {
            id = path.id;
            rate = path.rate;
            rateSize = path.rateSize;
            isSynchronous = true;
        }
        return ret;
    }
    
    public boolean set(int index, String location) {
        Location.addLocation(location);
        locations.set(index, Location.getLocation(location));
        isSynchronous = false;
        Path path = getEquivalentPath();
        if (path == null) {
            isSynchronous = false;
            rate = 0.0;
            rateSize = 0;
        } else {
            id = path.id;
            rate = path.rate;
            rateSize = path.rateSize;
            isSynchronous = true;
        }
        return Location.hasLocation(location);
    }
    
    public boolean add(int index, String location) {
        Location.addLocation(location);
        locations.add(index, Location.getLocation(location));
        isSynchronous = false;
        Path path = getEquivalentPath();
        if (path == null) {
            isSynchronous = false;
            rate = 0.0;
            rateSize = 0;
        } else {
            id = path.id;
            rate = path.rate;
            rateSize = path.rateSize;
            isSynchronous = true;
        }
        return Location.hasLocation(location);
    }
    
    public void remove(int index) {
        locations.remove(index);
        isSynchronous = false;
        Path path = getEquivalentPath();
        if (path == null) {
            isSynchronous = false;
            rate = 0.0;
            rateSize = 0;
        } else {
            id = path.id;
            rate = path.rate;
            rateSize = path.rateSize;
            isSynchronous = true;
        }
    }
    
    @SuppressWarnings("finally")
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
            String sql = "INSERT INTO path(start_id, end_id, path_size, hash_code) "
                    + "VALUE (?, ?, ?, ?);";
            stmt = (PreparedStatement) conn.prepareStatement(sql
                    , Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, getStart().getId());
            stmt.setLong(2, getEnd().getId());
            stmt.setInt(3, getSize());
            stmt.setInt(4, hashCode());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
                this.id = rs.getLong(1);
            rs.close();
            stmt.close();
            conn.setAutoCommit(false);
            sql = "INSERT INTO "
                    + "path_struct(path_id, location_id, location_index) "
                    + "VALUE (?, ?, ?);";
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            int i = 0;
            for (Location location : locations) {
                stmt.setLong(1, this.id);
                stmt.setLong(2, location.getId());
                stmt.setInt(3, i++);
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
    
    public boolean rate(int rate) {
        double rateSum = (double)(this.rateSize++) * this.rate;
        this.rate = rateSum / (double)(this.rateSize);
        return save();
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
        Statement tempStmt = null;
        long ret = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            String sql = "SELECT * FROM path WHERE hash_code=" + hashCode() + ";";
            stmt = conn.createStatement();
            tempStmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (Objects.equals(rs.getInt("path_size"), size())
                        && Objects.equals(getStart().getId() 
                                , rs.getLong("start_id"))
                        && Objects.equals(getEnd().getId()
                                , rs.getLong("end_id"))) {
                    sql = "SELECT * FROM path_struct"
                            + " WHERE path_id=" + rs.getLong("path_id")
                            + " ORDER BY location_index";
                    ResultSet temp = tempStmt.executeQuery(sql);
                    boolean isEqual = false;
                    temp.last();
                    int rowCount = temp.getRow();
                    temp.beforeFirst();
                    if (locations.size() == rowCount) {
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
            tempStmt.close();
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
    public static List<Path> getPath(String start, String end) {
        List<Path> ret = new LinkedList<Path>();
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            stmt = conn.createStatement();
            String sql = "SELECT path_id FROM path WHERE start_id="
                    + Location.getLocation(start).getId() + " AND "
                    + "end_id=" + Location.getLocation(end).getId()
                    + " ORDER BY rate_aver DESC;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
                ret.add(getPath(rs.getLong("path_id")));
            if (ret.isEmpty()) {
                Path newPath = new Path();
                newPath.add(start);
                newPath.add(end);
                newPath.save();
                ret.add(newPath);
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
    public static Path getPath(long id) {
        Connection conn = null;
        Statement stmt = null;
        Path ret = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            stmt = conn.createStatement();
            String sql = "SELECT rate_size, rate_aver FROM path WHERE path_id="
                    + id + ";";
            ResultSet rs = stmt.executeQuery(sql);
            int rateSize = 0;
            double rate = 0.0;
            if (rs.next()) {
                rateSize = rs.getInt("rate_size");
                rate = rs.getDouble("rate_aver");
            }
            rs.close();
            sql = "SELECT location_id FROM path_struct WHERE path_id="
                    + id + " ORDER BY location_index;";
            rs = stmt.executeQuery(sql);
            LinkedList<Location> locations = new LinkedList<Location>();
            while (rs.next()) {
                long location_id = rs.getLong("location_id");
                locations.add(Location.getLocation(location_id));
            }
            if (locations.isEmpty() == false)
                ret = new Path(locations, id, rateSize, rate);
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
    
    public String getText() {
        StringBuilder ret = new StringBuilder();
        ListIterator<Location> iter = locations.listIterator();
        ret.append(iter.next().getName());
        while (iter.hasNext())
            ret.append("->" + iter.next().getName());
        return ret.toString();
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

    public double getRate() {
        return rate;
    }

    public int getRateSize() {
        return rateSize;
    }

}
