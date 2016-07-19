package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Join02DAO extends SuperDAO {

	public List<Join02> SelectDataList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select b.bno, u.name, m.mname, b.bookdate, b.amount, (b.amount * t.price) as totalprice ";
		sql += " from ((users u inner join books b ";
		sql += " on u.id = b.mid) inner join movies m ";
		sql += " on b.mvid = m.mvid) inner join theathers t ";
		sql += " on b.tid = t.tid ";
		sql += " order by bno ";
			
		List<Join02> joinlist = new ArrayList<Join02>();
		
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Join02 bean = new Join02();
				bean.setBno(rs.getInt("bno"));
				bean.setName(rs.getString("name"));
				bean.setMname(rs.getString("mname"));
				bean.setBookdate(String.valueOf(rs.getDate("bookdate")));
				bean.setAmount(rs.getInt("amount"));
				bean.setTotalprice(rs.getInt("totalprice"));
				
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
	
	public List<Join02> SelectDataList(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select b.bno, u.name, m.mname, b.bookdate, b.amount, (b.amount * t.price) as totalprice ";
		sql += " from ((users u inner join books b ";
		sql += " on u.id = b.mid) inner join movies m ";
		sql += " on b.mvid = m.mvid) inner join theathers t ";
		sql += " on b.tid = t.tid ";
		sql += " and u.id = ? ";
		sql += " order by bno ";
		
		List<Join02> joinlist = new ArrayList<Join02>();

		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Join02 bean = new Join02();
				bean.setBno(rs.getInt("bno"));
				bean.setName(rs.getString("name"));
				bean.setMname(rs.getString("mname"));
				bean.setBookdate(String.valueOf(rs.getDate("bookdate")));
				bean.setAmount(rs.getInt("amount"));
				bean.setTotalprice(rs.getInt("totalprice"));
				
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
