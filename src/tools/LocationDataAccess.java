package tools;

import localization.LocalSettings;
import java.sql.*;

public class LocationDataAccess implements LocalSettings {
    
    public static long addLocation(String location) {
        long ret = get(location);
        Connection conn = null;
        Statement stmt = null;
        if (ret == Long.MIN_VALUE) {
            try {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                conn = DriverManager
                        .getConnection(databaseURL, username, password);
                String sql = "INSERT INTO location (name) VALUES ('"
                        + location + "');";
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (stmt != null)
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                if (conn != null)
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
            }
        }
        return ret;
    }
    
    public static boolean hasLocation(String location) {
        Connection conn = null;
        Statement stmt = null;
        boolean ret = false;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            conn = DriverManager
                    .getConnection(databaseURL, username, password);
            String sql = "SELECT 1 FROM Location WHERE name='"
                    + location
                    + "' LIMIT 1;";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ret = rs.next();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return ret;
    }
    
    public static long get(String location) {
        Connection conn = null;
        Statement stmt = null;
        long ret = Long.MIN_VALUE;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            conn = DriverManager
                    .getConnection(databaseURL, username, password);
            String sql = "SELECT ID FROM Location WHERE name='"
                    + location
                    + "' LIMIT 1;";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next())
                ret = rs.getLong("ID");
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        return ret;
    }
    
    public static void main(String args[]) {
        addLocation("福州");
        addLocation("广州");
        System.out.println(get("福州"));
        if (hasLocation("福州"))
            System.out.println("hasLocation checked!");
    }
}
