package mysql;

import java.sql.*;
import java.util.ArrayList;

import mysql.Basic;
import mysql.TravelPlan;
import com.mysql.jdbc.PreparedStatement;

import localization.LocalSettings;

public class MySQL {
	private static String url = LocalSettings.databaseURL;    //JDBC��URL 
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
}
