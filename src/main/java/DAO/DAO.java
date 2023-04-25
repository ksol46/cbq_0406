package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DAO {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe", "ksol46", "0406");
		return con;
	}
	
	public int insert(HttpServletRequest request, HttpServletResponse response) {
		String resvno = request.getParameter("resvno");
		String jumin = request.getParameter("jumin");
		String vcode = request.getParameter("vcode");
		String hospcode = request.getParameter("hospcode");
		String resvdate = request.getParameter("resvdate");
		String resvtime = request.getParameter("resvtime");
		int result = 0;
		
		try {
			conn = getConnection();
			String sql = "insert into tbl_vaccresv_202108 values (?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, resvno);
			ps.setString(2, jumin);
			ps.setString(3, vcode);
			ps.setString(4, hospcode);
			ps.setString(5, resvdate);
			ps.setString(6, resvtime);
			
			result = ps.executeUpdate();
			
			conn.close();
			ps.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String search (HttpServletRequest request, HttpServletResponse response) {
		ArrayList<S>
		
		return "search.jsp";
	}
	
}