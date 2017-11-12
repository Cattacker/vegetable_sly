package tools;

import localization.LocalSettings;
import java.sql.*;

public class LocationDataAccess implements LocalSettings {
    
    public static long addLocation(String location) {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Connection conn = DriverManager
                    .getConnection(databaseURL, username, password);
            String sql = ""
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean hasLocation(String location) {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Connection conn = DriverManager
                    .getConnection(databaseURL, username, password);
            String sql = "SELECT "
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
