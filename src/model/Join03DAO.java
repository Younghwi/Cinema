package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Join03DAO extends SuperDAO {

	public List<Join03> SelectDataList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select t.tname, m.mname, m.mvid, ps.playdate, ps.starttime, ps.psorder as 상영회차 , t.startseat, t.endseat, ps.sno";
		sql += " from (movies m inner join playschedules ps ";
		sql += " on m.mvid = ps.mvid) inner join theathers t ";
		sql += " on ps.tid= t.tid ";
		sql += " order by t.tname asc, ps.psorder asc ";
			
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
				bean.setMvid(rs.getInt("mvid"));
				bean.setPlaydate(String.valueOf(rs.getDate("playdate")));
				bean.setStarttime(rs.getString("starttime"));
				bean.setPsorder(rs.getInt("상영회차"));
				bean.setStartseat(rs.getInt("startseat"));
				bean.setEndseat(rs.getInt("endseat"));
				bean.setSno(rs.getInt("sno"));
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
	
	public List<Join03> SelectDataList(int mvid) {//관별 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select t.tname, m.mvid, m.mname, ps.playdate, ps.starttime, ps.psorder as 상영회차, t.startseat, t.endseat, t.price, t.tid, ps.sno";
		sql += " from (movies m inner join playschedules ps ";
		sql += " on m.mvid = ps.mvid) inner join theathers t ";
		sql += " on ps.tid= t.tid ";
		sql += " and m.mvid = ? ";
		sql += " order by t.tname asc, ps.psorder asc  ";

		List<Join03> joinlist = new ArrayList<Join03>();

		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setInt(1, mvid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Join03 bean = new Join03();
				bean.setTname(rs.getString("tname"));
				bean.setMname(rs.getString("mname"));
				bean.setMvid(rs.getInt("mvid"));
				bean.setPlaydate(String.valueOf(rs.getDate("playdate")));
				bean.setStarttime(rs.getString("starttime"));
				bean.setPsorder(rs.getInt("상영회차"));
				bean.setStartseat(rs.getInt("startseat"));
				bean.setEndseat(rs.getInt("endseat"));
				bean.setPrice(rs.getInt("price"));
				bean.setTid(rs.getInt("tid"));
				bean.setSno(rs.getInt("sno"));
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
				//super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return joinlist;
	}
	
	public List<Join03> SelectDataList(int mvid, String playdate) {//관별 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		String sql = " select t.tname, m.mvid, m.mname, ps.playdate, ps.starttime, ps.psorder as 상영회차, t.startseat, t.endseat, t.price, t.tid, ps.sno";
		sql += " from (movies m inner join playschedules ps ";
		sql += " on m.mvid = ps.mvid) inner join theathers t ";
		sql += " on ps.tid= t.tid ";
		sql += " and m.mvid = ? and ps.playdate = to_date(?, 'yyyy/MM/dd') ";
		sql += " order by t.tname asc, ps.psorder asc  ";

		List<Join03> joinlist = new ArrayList<Join03>();

		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setInt(1, mvid);
			pstmt.setString(2, playdate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Join03 bean = new Join03();
				bean.setTname(rs.getString("tname"));
				bean.setMname(rs.getString("mname"));
				bean.setMvid(rs.getInt("mvid"));
				String imsi = String.valueOf(rs.getDate("playdate"));
				String resultPlaydate = "";
				StringTokenizer st = new StringTokenizer(imsi);
				while (st.hasMoreElements()) {
					resultPlaydate += (String) st.nextToken("-");
				}
				bean.setPlaydate(resultPlaydate);

				bean.setStarttime(rs.getString("starttime"));
				bean.setPsorder(rs.getInt("상영회차"));
				bean.setStartseat(rs.getInt("startseat"));
				bean.setEndseat(rs.getInt("endseat"));
				bean.setPrice(rs.getInt("price"));
				bean.setTid(rs.getInt("tid"));
				bean.setSno(rs.getInt("sno"));
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
				//super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return joinlist;
	}
	
	public Join03 SelectDataList(int mvid, int psorder, String playdate) {//관별 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select t.tname, m.mvid, m.mname, ps.playdate, ps.starttime, ps.psorder as 상영회차, t.startseat, t.endseat, t.price, t.tid, ps.sno";
		sql += " from (movies m inner join playschedules ps ";
		sql += " on m.mvid = ps.mvid) inner join theathers t ";
		sql += " on ps.tid= t.tid ";
		sql += " and m.mvid = ? and ps.psorder = ? and ps.playdate = ?";
		sql += " order by t.tname asc, ps.psorder asc  ";

		Join03 bean = new Join03();

		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setInt(1, mvid);
			pstmt.setInt(2, psorder);
			pstmt.setString(3, playdate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bean.setTname(rs.getString("tname"));
				bean.setMname(rs.getString("mname"));
				bean.setMvid(rs.getInt("mvid"));
				String imsi = String.valueOf(rs.getDate("playdate"));
				String resultPlaydate = "";
				StringTokenizer st = new StringTokenizer(imsi);
				while (st.hasMoreElements()) {
					resultPlaydate += (String) st.nextToken("-");
				}
				bean.setPlaydate(resultPlaydate);
				bean.setStarttime(rs.getString("starttime"));
				bean.setPsorder(rs.getInt("상영회차"));
				bean.setStartseat(rs.getInt("startseat"));
				bean.setEndseat(rs.getInt("endseat"));
				bean.setPrice(rs.getInt("price"));
				bean.setTid(rs.getInt("tid"));
				bean.setSno(rs.getInt("sno"));
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

		return bean;
	}
}
