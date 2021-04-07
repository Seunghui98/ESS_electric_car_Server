package ess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectDB3 {
	private static ConnectDB3 instance = new ConnectDB3();
	
	public static ConnectDB3 getInstace() {
		return instance;
	}
	
	public ConnectDB3() {
		
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
	
	
	public int sum = 0;
	
	
	//데이터베이스와 통신하기 위한 코드
		public int GwangjuEss() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
				sql = "select * from esskwangju";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					sum += 1;
					System.out.println("합" + sum);
				}
				
			} catch(Exception e) {
				
				e.printStackTrace();
				
			} finally {
				if (rs != null)try {rs.close();} catch (SQLException ex) {}
				if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
				if (conn != null)try {conn.close();} catch (SQLException ex) {}

			}
			return sum;
		}
		
		
		public GwangjuEss esslist(int id){
			
			GwangjuEss ess = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
				sql2 = "select * from esskwangju where id=?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, id);
				rs2 = pstmt.executeQuery();
				
				
				if(rs2.next()) {
					ess = new GwangjuEss(id, rs2.getString("name"), rs2.getString("address"), rs2.getString("gu"), rs2.getString("dong"), rs2.getDouble("latitude"), rs2.getDouble("longitude"), rs2.getDouble("now"));
					return ess;
					
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if (rs2 != null)try {rs2.close();} catch (SQLException ex) {ex.printStackTrace();}
				if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {ex.printStackTrace();}
				if (conn != null)try {conn.close();} catch (SQLException ex) {ex.printStackTrace();}
			}
			
			return ess;
			
		}
	
}