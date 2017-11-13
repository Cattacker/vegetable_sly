package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Objects;

import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionContext;

import localization.LocalSettings;

public class User implements LocalSettings {
    
    private String id;
    
    private String password;
    
    private String nickname;
    
    private String name;
    
    private boolean sex;
    
    private String startCity;
    
    private Date birthday;
    
    private String phoneNum;
    
    public static User getUser() {
        Map session = ActionContext.getContext().getSession();
        String id = (String) session.get("user_ID");
        if (id != null)
            return new User(id);
        else
            return null;
    }
    
    public static User getUser(String id) {
        User user = new User(id);
        return user.isNull() ? null : user;
    }
    
    public static void updateUser(User user) {
        Connection conn = null;
        PreparedStatement ptmt = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            conn = DriverManager.getConnection(databaseURL, username
                    , LocalSettings.password);
            String sql = "update Basic "
                    + "set PassWord = ?, NickName = ?, Name = ?, Sex = ?"
                    + ", ComCity = ?, Birthday = ?, PhoneNum = ?"
                    + " where ID = ?;";
            ptmt = (PreparedStatement) conn.prepareStatement(sql);
            ptmt.setString(1, user.getPassword());
            ptmt.setString(2, user.getNickname());
            ptmt.setString(3, user.getName());
            ptmt.setInt(4, user.isSex() ? 1 : 0);
            ptmt.setString(5, user.getStartCity());
            ptmt.setDate(6,user.getBirthday());
            ptmt.setString(7, user.getPhoneNum());
            ptmt.setString(8, user.getId());
            ptmt.execute();
            ptmt.close();conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ptmt != null)
                try {
                    ptmt.close();
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

    public boolean equalsOnId(Object otherObject) {
        if (this == otherObject)
            return true;
        if (otherObject == null)
            return false;
        if (getClass() != otherObject.getClass())
            return false;
        User user = (User)otherObject;
        return Objects.equals(id, user.id);
    }
    
    public User(String id) {
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            conn = DriverManager.getConnection(databaseURL
                    , username, LocalSettings.password);
            String sql = "select * from Basic where ID='" + id + "';";
            stmt= conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                setBirthday(rs.getDate("Birthday"));
                setStartCity(rs.getString("Comcity"));
                setId(id);
                setName(rs.getString("Name"));
                setNickname("NickName");
                setPhoneNum("PhoneNum");
                if(rs.getInt("Sex")==1) {
                    setSex(true);
                }
                else
                    setSex(false);
            }
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

    public boolean isNull() {
        return id == null;
    }
    
    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isSex() {
        return sex;
    }
    
    public String getSex() {
        return sex ? "女" : "男";
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
