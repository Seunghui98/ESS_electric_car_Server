package ess;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ConnectDB {
	private static ConnectDB instance = new ConnectDB();
	
	
	public static ConnectDB getInstance() {
		return instance;
	}
	
	public ConnectDB() {
		
	}
	
	private String jdbcUrl = "jdbc:mysql://localhost:3306/ess?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String dbId = "root";
	private String dbPw = "1234";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private ResultSet rs2 = null;
	private String sql = "";
	private String sql2 = "";
	
	
	String returns = "a";
	
	
	//데이터베이스와 통신하기 위한 코드
	public String logindb(String id, String pwd) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			sql = "select id, password from user where id=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				if(rs.getString("id").equals(id) && rs.getString("password").equals(pwd)) {
					returns = "true";
					System.out.println("로그인 성공");
					return returns;
					
				} else {
					returns = "false";
					System.out.println("로그인 실패");
					return returns;
				}
			} else {
				returns = "noId";
				System.out.println("아이디 없음 ㅠ");
				return returns;
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			if (rs != null)try {rs.close();} catch (SQLException ex) {}
			if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
			if (conn != null)try {conn.close();} catch (SQLException ex) {}

		}
		return returns;
	}
	
	
	public ArrayList<User> UserList(String id, String pwd){
		ArrayList<User> list = new ArrayList<User>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			sql2 = "select * from user where id=? and password=?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs2 = pstmt.executeQuery();
			
			
			while(rs2.next()) {
				User user = new User(id, pwd, rs2.getString("name"), rs2.getString("car"), rs2.getDouble("allbattery"), rs2.getDouble("nowbattery"), rs2.getDouble("efficiency"), rs2.getString("homeattitude"), rs2.getString("homelongitude"), rs2.getNString("officeattitude"), rs2.getString("officelongitude"));
				list.add(user);
				
				
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (rs2 != null)try {rs2.close();} catch (SQLException ex) {ex.printStackTrace();}
			if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {ex.printStackTrace();}
			if (conn != null)try {conn.close();} catch (SQLException ex) {ex.printStackTrace();}
		}
		
		return list;
	}
	
	
	
	
	
}
