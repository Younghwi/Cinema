package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public int SelectTotalCount(int mvid) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select count(*) as cnt";
		sql += " from movies m inner join comments c";
		sql += " on m.mvid = c.mvid";
		sql += " and m.mvid = 1";

		int cnt = 0;// 없는 경우의 기본값
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (pstmt != null) {pstmt.close();}
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return cnt;
	}

	public List<Join05> SelectDataList(int mvid, int beginRow, int endRow) {
		// 랭킹을 이용하여 조회하되 writer이 작성한 항목만 조회한다.
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select cno, mid, mname, comments, writedate, starpoint, ranking ";
		sql += " from ";
		sql += " ( ";
		sql += " select c.cno, c.mid, mname, c.comments, c.writedate, c.starpoint, rank() over( order by c.cno desc ) as ranking ";
		sql += " from movies m inner join comments c ";
		sql += " on m.mvid = c.mvid ";
		sql += " and m.mvid = ? ";
		sql += " ) ";
		sql += " where ranking between ? and ? ";

		List<Join05> commentlist = new ArrayList<Join05>();
		try {
			if (this.conn == null) {this.conn = this.getConnection();}
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, mvid);
			pstmt.setInt(2, beginRow);
			pstmt.setInt(3, endRow);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Join05 bean = new Join05();
				bean.setCno(rs.getInt("cno"));
				bean.setMid(rs.getString("mid"));
				bean.setMname(rs.getString("mname"));
				bean.setComments(rs.getString("comments"));
				bean.setWritedate(String.valueOf(rs.getDate("writedate")));
				bean.setStarpoint(rs.getInt("starpoint"));
				commentlist.add(bean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				this.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return commentlist;
	}

}
