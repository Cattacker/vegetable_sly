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

import mysql.TravelPlan;

public class Team implements localization.LocalSettings{
	
	public Long ID;
	
	public String Name;
	
	public int Plan_id;
	
	public String Captain_id;
	
	public List<TeamMember> teammembers;
	
	public Team( String name, int planid ,String captainid){
		this.Captain_id = captainid;
		this.Name = name;
		this.Plan_id = planid;
		this.ID = -1L;
	}
	
	@SuppressWarnings("finally")
	public boolean Teamsave(){
		boolean ret = false;
		Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            conn.setAutoCommit(false);
            String sql = "INSERT INTO team(name, plan_id, captain_id) "
                    + "VALUE (?, ?, ?);";
            stmt = (PreparedStatement) conn.prepareStatement(sql
                    , Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, this.Name);
            stmt.setLong(2, this.Plan_id);
            stmt.setString(3, this.Captain_id);
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
                this.ID = rs.getLong("id");
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
	boolean deleteTeam(Long id){
		boolean ret = false;
		Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            conn.setAutoCommit(false);
            String sql = "delete from team_member where team_id = ?;";
            stmt = (PreparedStatement) conn.prepareStatement(sql
                    , Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, this.ID);
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
	boolean queryTeammembers(){
		boolean ret = false;
		Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, username, password);
            conn.setAutoCommit(false);
            String sql = "select * from team_member where team_id=?;";
            stmt = (PreparedStatement) conn.prepareStatement(sql
                    , Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
	        	Long teamid = rs.getLong("team_id");
	        	String memberid = rs.getString("member_id");
	        	TeamMember tmp = new TeamMember(teamid, memberid);
	        	this.teammembers.add(tmp);
	        }
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
	
	void setName(String name){
		this.Name = name;
	}
	
	String getName(){
		return this.Name;
	}
	
	void setCaptain_id(String captainid){
		this.Captain_id = captainid;
	}
	
	String getCaotain_id(){
		return this.Captain_id;
	}
	
	int getPlan_id(){
		return this.Plan_id;
	}
	
	Long getID(){
		return this.ID;
	}
	
	List<TeamMember> getTeammembers(){
		return this.teammembers;
	}

}
