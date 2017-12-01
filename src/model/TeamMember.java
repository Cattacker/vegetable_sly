package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class TeamMember implements localization.LocalSettings{
	
	public int team_id;
	public int member_id;
	
	public TeamMember(int teamid, int memberid){
		this.team_id = teamid;
		this.member_id = memberid;
	}
	
	@SuppressWarnings("finally")
	boolean addTeamMember(int teamid,int memberid){
		boolean ret = false;
		Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            conn.setAutoCommit(false);
            String sql = "INSERT INTO team_member(team_id, member_id) "
                    + "VALUE (?, ?);";
            stmt = (PreparedStatement) conn.prepareStatement(sql
                    , Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, this.team_id);
            stmt.setInt(2, this.member_id);
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.close();
            stmt.executeBatch();
            conn.commit();
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
	
	@SuppressWarnings("finally")
	boolean deleteTeamMember(int teamid,int memberid){
		boolean ret = false;
		Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            conn.setAutoCommit(false);
            String sql = "delete from team_member where team_id = ? and member_id = ?;";
            stmt = (PreparedStatement) conn.prepareStatement(sql
                    , Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, this.team_id);
            stmt.setInt(2, this.member_id);
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.close();
            stmt.executeBatch();
            conn.commit();
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
	
	int getTeam_id(){
		return this.team_id;
	}
	
	int getMember_id(){
		return this.member_id;
	}
}
