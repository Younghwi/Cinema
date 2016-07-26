package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Join06DAO extends SuperDAO {

	public List<Join06> SelectDataList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select m.mvid, m.mname, ps.playdate, ps.psorder, m.image ";
		sql += " from movies m inner join playschedules ps ";
		sql += " on m.mvid = ps.mvid ";

		List<Join06> joinlist = new ArrayList<Join06>();

		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Join06 bean = new Join06();
				bean.setMvid(rs.getInt("mvid"));
				bean.setMname(rs.getString("mname"));
				bean.setPlaydate(String.valueOf(rs.getDate("playdate")));
				bean.setPsorder(rs.getInt("psorder"));
				bean.setStringImage("image");
				
				joinlist.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return joinlist;
	}

	public List<Join06> SelectDataList(String playdate) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("뭐가들어오는"+playdate);
		
		

		String sql = "select DISTINCT m.image, m.mvid, ps.playdate";
		sql += " from movies m inner join playschedules ps ";
		sql += " on m.mvid = ps.mvid ";
		sql += " and ps.playdate = to_date(?, 'yyyy/MM/dd') ";
		sql += " and m.condition = 1";

		List<Join06> joinlist = new ArrayList<Join06>();
		System.out.println(playdate);
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setString(1, playdate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Join06 bean = new Join06();
				bean.setMvid(rs.getInt("mvid"));
				
				String imsi = String.valueOf(rs.getDate("playdate"));
				String resultPlaydate = "";
				StringTokenizer st = new StringTokenizer(imsi);
				while (st.hasMoreElements()) {
					resultPlaydate += (String) st.nextToken("-");
				}
				bean.setPlaydate(resultPlaydate);
				bean.setStringImage(rs.getString("image"));
				joinlist.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return joinlist;
	}
}
