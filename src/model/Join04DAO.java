package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Join04DAO extends SuperDAO {

	public List<Join04> SelectDataList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select t.tname, ps.psorder as 상영회차, bd.seatno ";
		sql += " from (theathers t inner join playschedules ps ";
		sql += " on t.tid=ps.tid) inner join bookdetails bd ";
		sql += " on ps.sno=bd.sno ";
		sql += " order by tname, psorder ";
		
		List<Join04> joinlist = new ArrayList<Join04>();
		
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Join04 bean = new Join04();
				bean.setTname(rs.getString("tname"));
				bean.setPsorder(rs.getInt("상영회차"));
				bean.setSeatno(rs.getString("seatno"));
				
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
	//날짜별 영화관 회차 나간 좌석
	public List<Join04> SelectDataList(int psorder, String playdate) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select t.tname, ps.psorder as 상영회차, bd.seatno ";
		sql += " from (theathers t inner join playschedules ps ";
		sql += " on t.tid=ps.tid) inner join bookdetails bd ";
		sql += " on ps.sno=bd.sno ";
		sql += " and ps.psorder = ? ";
		sql += " and ps.playdate = ? ";
		sql += " order by tname, psorder ";
		
		List<Join04> joinlist = new ArrayList<Join04>();
		
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setInt(1, psorder);
			pstmt.setString(2, playdate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Join04 bean = new Join04();
				bean.setTname(rs.getString("tname"));
				bean.setPsorder(rs.getInt("상영회차"));
				bean.setSeatno(rs.getString("seatno"));
				
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
