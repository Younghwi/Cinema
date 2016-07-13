package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Join01DAO extends SuperDAO {

	public List<Join01> SelectDataList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select b.bno, u.name, m.mname, b.bookdate, ps.playdate, ps.psorder, t.tname, bd.seatno ";
		sql += " from ((((users u inner join books b ";
		sql += " on u.id = b.mid ) inner join movies m ";
		sql += " on b.mvid = m.mvid) inner join theathers t ";
		sql += " on b.tid = t.tid) inner join bookdetails bd ";
		sql += " on b.bno = bd.bno) inner join playschedules ps ";
		sql += " on bd.sno = ps.sno ";
		sql += " order by bno ";
		
		List<Join01> joinlist = new ArrayList<Join01>();

		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Join01 bean = new Join01();
				bean.setBno(rs.getInt("bno"));
				bean.setName(rs.getString("name"));
				bean.setMname(rs.getString("mname"));
				bean.setBookdate(String.valueOf(rs.getDate("bookdate")));
				bean.setPlaydate(String.valueOf(rs.getDate("playdate")));
				bean.setPsorder(rs.getInt("psorder"));
				bean.setTname(rs.getString("tname"));
				bean.setSeatno(rs.getInt("seatno"));
				
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
	
	public List<Join01> SelectDataList(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select b.bno, u.name, m.mname, b.bookdate, ps.playdate, ps.psorder, t.tname, bd.seatno ";
		sql += " from ((((users u inner join books b ";
		sql += " on u.id = b.mid ) inner join movies m ";
		sql += " on b.mvid = m.mvid) inner join theathers t ";
		sql += " on b.tid = t.tid) inner join bookdetails bd ";
		sql += " on b.bno = bd.bno) inner join playschedules ps ";
		sql += " on bd.sno = ps.sno ";
		sql += " and u.id = ? ";
		sql += " order by bno ";
		
		List<Join01> joinlist = new ArrayList<Join01>();

		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Join01 bean = new Join01();
				bean.setBno(rs.getInt("bno"));
				bean.setName(rs.getString("name"));
				bean.setMname(rs.getString("mname"));
				bean.setBookdate(String.valueOf(rs.getDate("bookdate")));
				bean.setPlaydate(String.valueOf(rs.getDate("playdate")));
				bean.setPsorder(rs.getInt("psorder"));
				bean.setTname(rs.getString("tname"));
				bean.setSeatno(rs.getInt("seatno"));
				
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
