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
	private static String url = LocalSettings.databaseURL;    //JDBCï¿½ï¿½URL 
	private static String username = LocalSettings.username;
	private static String pword = LocalSettings.password;
	
	public boolean InsertBasic(Basic temp) {
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
    		
    		String sql = "INSERT INTO Basic (ID,PassWord,NickName) VALUES ('"+temp.getID()+"','"+temp.getPassword()+"','"
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
			String sql = "update Basic set PassWord=?,NickName=?,Name=?,Sex=?,ComCity=?,Birthday=?,PhoneNum=? where ID=?";
	        PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
	        ptmt.setString(1, temp.getPassword());
	        ptmt.setString(2, temp.getNickname());
	        ptmt.setString(3, temp.getName());
	        ptmt.setInt(4, temp.isSex());
	        ptmt.setString(5, temp.getComcity());
	        ptmt.setDate(6,temp.getBirthday());
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
			String sql = "delete from Basic where ID=?";
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
    	Basic temp = new Basic();
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "select * from Basic where ID='" +ID+ "';";
	        Statement stmt= conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);
	        if(rs.next()) {
            	temp.setBirthday(rs.getDate("Birthday"));
            	temp.setComcity(rs.getString("Comcity"));
            	temp.setID(ID);
            	temp.setName(rs.getString("Name"));
            	temp.setNickname("NickName");
            	temp.setPhonenum("PhoneNum");
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
    //ï¿½ï¿½Ñ¯ï¿½Ã»ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ç·ï¿½Æ¥ï¿½ï¿½
    public boolean QueryBasic1(String ID, String password) {
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "select PassWord from Basic where ID='" +ID+ "';";
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
    //ï¿½ï¿½Ñ¯ï¿½Ã»ï¿½IDï¿½Ç·ï¿½ï¿½Ñ¾ï¿½ï¿½ï¿½ï¿½ï¿½
    public boolean QueryBasic2(String ID) {
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Connection conn = DriverManager.getConnection(url,username,pword);
			String sql = "select PassWord from Basic where ID='" +ID+ "';";
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
            String sql = "select PassWord from Basic where ID='" +ID+ "';";
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
			String sql = "INSERT INTO TravelPlan VALUES ('"+temp.getID()+"','"+temp.getTeamID()+"','"
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
			String sql = "update TravelPlan set TeamID=?,Path=?,WishDate=? where ID=?";
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
			String sql = "delete from TravelPlan where ID=?";
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
	        		String name = rs1.getString("name");
	        		int planid = rs1.getInt("plan_id");
	        		String cid = rs1.getString("captain_id");
		        	Team tmp = new Team(name,planid,cid);
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
	        	System.out.println(mz);
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
			System.out.println(sql);
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
			System.out.println(sql);
	        stmt.execute(sql);
	        
	        
	        String sql2 = "delete from applyteam where team_id = '"+teamid+"' and user_id = '"+userid+"';";
	        System.out.println(sql2);
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
			System.out.println(sql);
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
    		for(int i =0;i<temp.getCheckbox().length;i++) //¶Ôcheckbox½øÐÐ±éÀú  
			{  
    			int t = Integer.parseInt(temp.getCheckbox()[i]);
    			String sql = "insert into travelhobby values('"+tempid+"','"+t+"');";
		        stmt.execute(sql);
		        
			}  
    		stmt.close();conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }
}

	
