package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Reservation;
import DTO.Stats;

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
	
	public String getSearch(HttpServletRequest request, HttpServletResponse response) {
		
		String resvno = request.getParameter("resvno");
		
		try {
			conn = getConnection();
			String sql = "select"
					+ " j.pname,"
					+ " j.jumin,"
					+ " decode(substr(j.jumin,8,1),'1','남','2','여') as gender,"
					+ " j.tel,"
					+ " to_char(to_date(r.resvdate, 'YYYYMMDD'), 'YYYYY\"년\"MM\"월\"DD\"일\"')as res_date,"
					+ " substr(r.resvtime, 1, 2) || ':' || substr(r.resvtime, 3, 2) as res_time,"
					+ " h.hospname,"
					+ " h.hosptel,"
					+ " h.hospaddr,"
					+ " decode(substr(r.vcode, 4, 1), '1', 'A백신', '2', 'B백신', '3', 'C백신') as v_type"
					+ " from tbl_vaccresv_202108 r"
					+ " join tbl_jumin_201808 j"
					+ " on r.jumin = j.jumin"
					+ " join tbl_hosp_202108 h"
					+ " on r.hospcode = h.hospcode"
					+ " where r.resvno = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, resvno);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Reservation res = new Reservation();
				res.setPname(rs.getString(1));
				res.setJumin(rs.getString(2));
				res.setGender(rs.getString(3));
				res.setTel(rs.getString(4));
				res.setResvdate(rs.getString(5));
				res.setResvtime(rs.getString(6));
				res.setHospname(rs.getString(7));
				res.setHosptel(rs.getString(8));
				res.setHospaddr(rs.getString(9));
				res.setVtype(rs.getString(10));
				
				request.setAttribute("resvno", resvno);
				request.setAttribute("res", res);
				
				conn.close();
				ps.close();
				rs.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "inquiry.jsp";
	}
	
	public String giveStatistics(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Stats> list = new ArrayList<Stats>();
		
		try {
			conn = getConnection();
			String sql = "select h.hospcode, h.hospname, count(r.resvno)"
					+ " from tbl_vaccresv_202108 r"
					+ " join tbl_hosp_202108 h"
					+ " on r.hospcode = h.hospcode"
					+ " group by (h.hospcode, h.hospname)"
					+ " order by h.hospcode";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Stats stats = new Stats();
				stats.setHospcode(rs.getString(1));
				stats.setHospname(rs.getString(2));
				stats.setCount(rs.getInt(3));
				
				list.add(stats);
			}
			
			request.setAttribute("list", list);
			
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "stats.jsp";
	}
	
	public String total (HttpServletRequest request, HttpServletResponse response) {
		
		try {
			conn = getConnection();
			String sql = "select count(resvno) as total"
					+ " from tbl_vaccresv_202108";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			int total = 0;
			
			if(rs.next()) {
				total = rs.getInt(1);
				request.setAttribute("total", total);
				
				conn.close();
				ps.close();
				rs.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "stats.jsp";
	}
	
}