package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Join05DAO extends SuperDAO {

	public List<Join05> SelectDataList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select  m.mname, c.mid, c.writedate, c.comments ";
		sql += " from movies m inner join comments c ";
		sql += " on m.mvid = c.mvid ";
		
		List<Join05> joinlist = new ArrayList<Join05>();

		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Join05 bean = new Join05();
				bean.setMname(rs.getString("mname"));
				bean.setMid(rs.getString("mid"));
				bean.setComments(rs.getString("comments"));
				bean.setWritedate(String.valueOf(rs.getDate("writedate")));
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
	
	public List<Join05> SelectDataList(int mvid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select  m.mname, c.mid, c.writedate, c.comments, c.starpoint";
		sql += " from movies m inner join comments c ";
		sql += " on m.mvid = c.mvid ";
		sql += " and m.mvid = ? ";
		
		List<Join05> joinlist = new ArrayList<Join05>();

		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setInt(1, mvid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Join05 bean = new Join05();
				bean.setMid(rs.getString("mid"));
				bean.setMname(rs.getString("mname"));
				bean.setWritedate(String.valueOf(rs.getDate("writedate")));
				bean.setComments(rs.getString("comments"));
				bean.setStarpoint(rs.getInt("starpoint"));
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

