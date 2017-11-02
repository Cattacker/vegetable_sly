package mysql;

import java.sql.*;
import mysql.Basic;
import mysql.TravelPlan;
import com.mysql.jdbc.PreparedStatement;

public class MySQL {
	private static String url="jdbc:mysql://localhost:3306/traveldb";    //JDBCµÄURL 
	private static String username="root";
	private static String pword="yy745628661";
	
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
	        ptmt.setString(1, temp.getTeamID());
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
    
}
