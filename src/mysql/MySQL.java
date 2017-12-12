package mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mysql.Basic;
import mysql.TravelPlan;
import com.mysql.jdbc.PreparedStatement;

import localization.LocalSettings;
import model.*;

public class MySQL {
	private static String url = LocalSettings.databaseURL;    //JDBC��URL 
	private static String username = LocalSettings.username;
	private static String pword = LocalSettings.password;
	
	public Boolean InsertStratety(Stratety temp) {
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
    		String sql1="select * from stratety";
    		Statement stmt1= conn.createStatement();
	        ResultSet rs = stmt1.executeQuery(sql1);
	        rs.last();
	        int t=rs.getInt("id");
	        temp.setIndex(t+1);
    		String sql = "INSERT INTO stratety (editor,id) VALUES ('"+temp.getEditor()+"','"+temp.getIndex()+"');";
    		
//    			sql = "INSERT INTO Basic (ID,PassWord,NickName) VALUES ('"+temp.getID()+"','"+temp.getPassword()+"','"
//    					+temp.getNickname()+ "','"+temp.getName()+"','"+temp.isSex()+"','"
//    					+temp.getComcity()+"','"+temp.getBirthday()+"','"+temp.getPhonenum()+"');";
	        stmt1.execute(sql);
	        
	        stmt1.close();conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    	
    }
	public Stratety QueryStratety(int id) {
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "select editor from stratety where id='" +id+ "';";
	        Statement stmt= conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        String editor = new String();
	        if(rs.next()) {
            	editor=rs.getString("editor");
            	Stratety temp=new Stratety();
            	temp.setEditor(editor);
	        	stmt.close();conn.close();rs.close();
	        	return temp;
	        }
	        else
	        	return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
	public boolean InsertBasic(Basic temp) {
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
    		
    		String sql = "INSERT INTO basic (ID,PassWord,NickName) VALUES ('"+temp.getID()+"','"+temp.getPassword()+"','"
    					+temp.getNickname()+"');";
    		
//    			sql = "INSERT INTO Basic (ID,PassWord,NickName) VALUES ('"+temp.getID()+"','"+temp.getPassword()+"','"
//    					+temp.getNickname()+ "','"+temp.getName()+"','"+temp.isSex()+"','"
//    					+temp.getComcity()+"','"+temp.getBirthday()+"','"+temp.getPhonenum()+"');";
	        Statement stmt= conn.createStatement();
	        stmt.execute(sql);
	        
	        stmt.close();conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    	
    }
	
    public static boolean UpdateBasic(Basic temp) {
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "update basic set PassWord=?,NickName=?,Name=?,Sex=?,ComCity=?,PhoneNum=? where ID=?";
	        PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
	        ptmt.setString(1, temp.getPassword());
	        ptmt.setString(2, temp.getNickname());
	        ptmt.setString(3, temp.getName());
	        ptmt.setInt(4, temp.isSex());
	        ptmt.setString(5, temp.getComcity());
	        //ptmt.setDate(6,temp.getBirthday());
	        ptmt.setString(7, temp.getPhonenum());
	        ptmt.setString(8, temp.getID());
	        ptmt.execute();
	        ptmt.close();conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }
    public static boolean DeleteBasic(Basic temp) {
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "delete from basic where ID=?";
	        PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
	        ptmt.setString(1, temp.getID());
	        ptmt.execute();
	        ptmt.close();conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }
    public Basic QueryBasic(String ID) {
    	Basic temp = null;
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "select * from basic where ID='" +ID+ "';";
	        Statement stmt= conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        if(rs.next()) {
	        	temp=new Basic();
            	temp.setBirthday(rs.getDate("Birthday"));
            	temp.setComcity(rs.getString("Comcity"));
            	temp.setID(ID);
            	temp.setName(rs.getString("Name"));
            	temp.setNickname(rs.getString("NickName"));
            	temp.setPhonenum(rs.getString("PhoneNum"));
            	if(rs.getInt("Sex")==1) {
            		temp.setSex(true);
            	}
            	else
            		temp.setSex(false);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return temp;
    }
    //��ѯ�û��������Ƿ�ƥ��
    public boolean QueryBasic1(String ID, String password) {
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "select PassWord from basic where ID='" +ID+ "';";
	        Statement stmt= conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        String password_temp = new String();
	        if(rs.next()) {
            	password_temp=rs.getString("PassWord");
	        	stmt.close();conn.close();rs.close();
	        	if(password_temp.equals(password))
	        		return true;
	        	else
	        		return false;
	        }
	        else
	        	return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }
    //��ѯ�û�ID�Ƿ��Ѿ�����
    public boolean QueryBasic2(String ID) {
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "select PassWord from basic where ID='" +ID+ "';";
	        Statement stmt= conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        if(rs.next()) {
            	return true;
	        }
	        else
	        	return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }
    
    public static boolean isUserExist(String ID) {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Connection conn = DriverManager.getConnection(url,username,pword);
            String sql = "select PassWord from basic where ID='" +ID+ "';";
            Statement stmt= conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                return true;
            }
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean InsertTravelPlan(TravelPlan temp) {
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "INSERT INTO travelplan VALUES ('"+temp.getID()+"','"+temp.getTeamID()+"','"
    		+temp.getPath()+ "','"+temp.getWishdate()+"');";
	        Statement stmt= conn.createStatement();
	        stmt.execute(sql);
	        
	        stmt.close();conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    	
    }
    public static boolean UpdateTravelPlan(TravelPlan temp) {
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "update travelplan set TeamID=?,Path=?,WishDate=? where ID=?";
	        PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
	        ptmt.setLong(1, temp.getTeamID());
	        ptmt.setLong(2, temp.getPath());
	        ptmt.setString(3, temp.getWishdate());
	        ptmt.setString(4, temp.getID());
	        ptmt.execute();
	        ptmt.close();conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }
    public static boolean DeleteTravelPlan(TravelPlan temp) {
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "delete from travelplan where ID=?";
	        PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
	        ptmt.setString(1, temp.getID());
	        ptmt.execute();
	        ptmt.close();conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }
    
    public ArrayList<TravelPlan>  QueryTravelPlan(String ID, int state){
    	ArrayList<TravelPlan> travelplan=new ArrayList<TravelPlan>();
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "select travelplan.* from travelplan where ID='" +ID+ "' and state = '"+ state +"';";
	        Statement stmt= conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        while(rs.next()) {
	        	String id = rs.getString("ID");
	        	long teamid = rs.getLong("TeamID");
	        	long path = rs.getLong("Path");
	        	String wishdate = rs.getString("WishDate");
	        	int tmpstate = rs.getInt("state");
	        	TravelPlan tmp = new TravelPlan(id,teamid,path,wishdate,tmpstate);
	        	travelplan.add(tmp);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return travelplan;
    }
    
    
    public static boolean InsertUserRelation(UserRelation temp) {
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "INSERT INTO user_relation VALUES ('"+temp.getFollowing_user_id()+"','"
    		+temp.getFollowed_user_id()+"');";
	        Statement stmt= conn.createStatement();
	        stmt.execute(sql);
	        
	        stmt.close();conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }
    public ArrayList<String>  QueryUserRelation(String ID) {
    	ArrayList<String> followed_user_id=new ArrayList<String>();
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "select followed_user_id from user_relation where following_user_id='" +ID+ "';";
	        Statement stmt= conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        while(rs.next()) {
            	followed_user_id.add(rs.getString("followed_user_id"));
	        }
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return followed_user_id;
    }
    public static boolean DeleteUserRelation(String id) {
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "delete from user_relation where followed_user_id=?";
	        PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
	        ptmt.setString(1,id);
	        ptmt.execute();
	        ptmt.close();conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }
    
    public ArrayList<Team> QueryMyTeam(String ID){
    	ArrayList<Team> myteam=new ArrayList<Team>();
    	ArrayList<TeamMember> teamids=new ArrayList<TeamMember>();
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "select * from team_member where member_id='" +ID+ "';";
	        Statement stmt= conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        while(rs.next()) {
	        	int teamid = rs.getInt("team_id");
	        	String memberid = rs.getString("member_id");
	        	TeamMember tmp = new TeamMember(teamid,memberid);
	        	teamids.add(tmp);
	        }
	      
	        int length = teamids.size();
	        for(int i = 0;i < length;i++){
	        	String tempsql = "select * from team where id='" +teamids.get(i).team_id+ "';";
	        	ResultSet rs1 = stmt.executeQuery(tempsql);
	        	while(rs1.next()) {
	        		long tid = rs1.getLong("ID");
	        		String name = rs1.getString("name");
	        		int planid = rs1.getInt("plan_id");
	        		String cid = rs1.getString("captain_id");
		        	Team tmp = new Team(tid,name,planid,cid);
		        	myteam.add(tmp);
		        }
	        }
	        
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return myteam;
	}
    
    public ArrayList<Team> QueryTeamsByIdOrName(long id, String name){
    	ArrayList<Team> teams=new ArrayList<Team>();
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "select * from team where id ='" + id + "' or name = '" + name + "';";
	        Statement stmt= conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        while(rs.next()) {
	        	Long teamid = rs.getLong("id");
	        	String mz = rs.getString("name");
	        	int planid = rs.getInt("plan_id");
	        	String cid = rs.getString("captain_id");
	        	Team tmp = new Team(teamid,mz,planid,cid);
	        	teams.add(tmp);
	        }
	        
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return teams;
	}
    
    public ArrayList<TeamMember> QueryTeammembers(long id){
    	ArrayList<TeamMember> members=new ArrayList<TeamMember>();
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "select * from team_member where team_id='" +id+ "';";
	        Statement stmt= conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        while(rs.next()) {
	        	int teamid = rs.getInt("team_id");
	        	String memberid = rs.getString("member_id");
	        	TeamMember tmp = new TeamMember(teamid,memberid);
	        	members.add(tmp);
	        }  
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return members;
    }
    
    public static boolean InsertApplyTeam(long teamid, String userid, String captainid){
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "INSERT INTO applyteam(team_id, user_id, captain_id) VALUES ('"+teamid+"','"
    		+userid+"','"+ captainid +"' );";
	        Statement stmt= conn.createStatement();
	        stmt.execute(sql);
	        stmt.close();conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }
    
    public ArrayList<ApplyTeamModel> QueryApplyTeams(String captainid){
    	ArrayList<ApplyTeamModel> myteamapplied=new ArrayList<ApplyTeamModel>();
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "select * from applyteam where captain_id='" +captainid+ "';";
	        Statement stmt= conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        while(rs.next()) {
	        	long teamid = rs.getLong("team_id");
	        	String memberid = rs.getString("user_id");
	        	String cid = rs.getString("captain_id");
	        	ApplyTeamModel tmp = new ApplyTeamModel(teamid,memberid,cid);
	        	myteamapplied.add(tmp);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return myteamapplied;
	}
    
    public boolean AllowApplyTeams(long teamid, String userid){
		
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "insert into team_member(team_id,member_id) value('"+teamid+"','"+userid+"');";
			Statement stmt= conn.createStatement();
	        stmt.execute(sql);
	        
	        
	        String sql2 = "delete from applyteam where team_id = '"+teamid+"' and user_id = '"+userid+"';";
	        stmt.execute(sql2);
	        
	        stmt.close();conn.close();
	        return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
    	return false;
    	
    }
    
    public boolean RefuseApplyTeams(long teamid, String userid){
    	
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "delete from applyteam where team_id = '"+teamid+"' and user_id = '"+userid+"';";
			Statement stmt= conn.createStatement();
	        stmt.execute(sql);
	        stmt.close();conn.close();
	        return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
    	return false;
    	
    }
    
    public boolean InsertTravelHobby(TravelHobby temp){
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
    		String tempid = temp.getId();
    		Statement stmt= conn.createStatement();
    		if(temp.getCheckbox() != null){
    			for(int i =0;i<temp.getCheckbox().length;i++) //��checkbox���б���  
    			{  
    				int t = Integer.parseInt(temp.getCheckbox()[i]);
    				String sql = "insert into travelhobby values('"+tempid+"','"+t+"');";
    				stmt.execute(sql);
		        
    			}  
    			stmt.close();conn.close();
    		}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }

    public boolean InsertInvite(long teamid, String friendid){
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "INSERT INTO invite(team_id, friend_id) VALUES ('"+teamid+"','"
    		+friendid +"' );";
	        Statement stmt= conn.createStatement();
	        stmt.execute(sql);
	        stmt.close();conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }

    public ArrayList<Invitations> QueryInvitations(String userid){
    	ArrayList<Invitations> invitations=new ArrayList<Invitations>();
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "select * from invite where friend_id='" +userid+ "';";
	        Statement stmt= conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        while(rs.next()) {
	        	long teamid = rs.getLong("team_id");
	        	String memberid = rs.getString("friend_id");
	        	Invitations tmp = new Invitations(teamid,memberid);
	        	invitations.add(tmp);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return invitations;
    }
    
    public boolean AllowInvitations(long teamid, String userid){
    	
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "insert into team_member(team_id,member_id) value('"+teamid+"','"+userid+"');";
			Statement stmt= conn.createStatement();
	        stmt.execute(sql);
	        
	        
	        String sql2 = "delete from invite where team_id = '"+teamid+"' and friend_id = '"+userid+"';";
	        stmt.execute(sql2);
	        
	        stmt.close();conn.close();
	        return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
    	return false;
    	
    }

    public boolean RefuseInvitations(long teamid, String userid){
    	
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "delete from invite where team_id = '"+teamid+"' and friend_id = '"+userid+"';";
			Statement stmt= conn.createStatement();
	        stmt.execute(sql);
	        stmt.close();conn.close();
	        return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
    	return false;
    	
    }
}

	
