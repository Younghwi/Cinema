package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Join03DAO extends SuperDAO {

	public List<Join03> SelectDataList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select t.tname, m.mname, ps.playdate, ps.starttime, ps.psorder as 상영회차 ";
		sql += " from (movies m inner join playschedules ps ";
		sql += " on m.mvid = ps.mvid) inner join theathers t ";
		sql += " on ps.tid= t.tid ";
			
		List<Join03> joinlist = new ArrayList<Join03>();
		
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Join03 bean = new Join03();
				bean.setTname(rs.getString("tname"));
				bean.setMname(rs.getString("mname"));
				bean.setPlaydate(String.valueOf(rs.getDate("playdate")));
				bean.setStarttime(rs.getString("starttime"));
				bean.setPsorder(rs.getInt("상영회차"));
				
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
	
	public List<Join03> SelectDataList(String tname) {//관별 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select t.tname, m.mname, ps.playdate, ps.starttime, ps.psorder as 상영회차 ";
		sql += " from (movies m inner join playschedules ps ";
		sql += " on m.mvid = ps.mvid) inner join theathers t ";
		sql += " on ps.tid= t.tid ";
		sql += " and t.tname = ? ";
		sql += " order by psorder ";


			
		List<Join03> joinlist = new ArrayList<Join03>();

		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setString(1, tname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Join03 bean = new Join03();
				bean.setTname(rs.getString("tname"));
				bean.setMname(rs.getString("mname"));
				bean.setPlaydate(String.valueOf(rs.getDate("playdate")));
				bean.setStarttime(rs.getString("starttime"));
				bean.setPsorder(rs.getInt("상영회차"));
				
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
