package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayScheduleDAO extends SuperDAO{
	
	public List<PlayScheduleBean> SelectDataList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select * from movies ";
		List<PlayScheduleBean> movielist = new ArrayList<PlayScheduleBean>();
		
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				PlayScheduleBean bean = new PlayScheduleBean();
				bean.setSno(rs.getInt("sno"));
				bean.setMvno(rs.getInt("mvno"));
				bean.setTid(rs.getInt("tid"));
				bean.setPlaydate(String.valueOf(rs.getDate("playdate")));
				bean.setStarttime(rs.getString("starttime"));
				bean.setPsorder(rs.getInt("psorder"));

				movielist.add(bean);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( pstmt != null) pstmt.close();
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return movielist;
	}

	public int InsertMovie(PlayScheduleBean movie) {
		PreparedStatement pstmt = null;
		String sql = " insert into movies(mvid, mname, opendate, director, genre, playingtime, story, rating, distributor, actor, condition, image) ";
		sql += " values(?,?,?,?,?,?,?,?,?,?,?,?) ";
		
		int cnt = -99999;
		
		try {
			if(super.conn == null) { super.getConnection(); }
			
			super.conn.setAutoCommit(false);
			
			cnt = pstmt.executeUpdate();
			super.conn.commit();
		
		} catch (Exception e) {
			SQLException err = (SQLException) e; // sql error code 잡아내기
			cnt = -err.getErrorCode(); // 오라클 오류상수가 리턴
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return cnt;
	}
	 public int UpdateMovie(PlayScheduleBean movie){
	      PreparedStatement pstmt = null;
	      
	      String sql = " Update movies set mname = ?, opendate = ?, director = ?, genre = ?, ";
	      sql+= " playingtime = ?, story = ?, rating = ?, distributor = ?, actor = ?, condition = ?, Image = ? where mvid = ? ";
	      int cnt = -99999;
	      
	      try {
	         if(super.conn == null) { super.getConnection(); }
	         
	         super.conn.setAutoCommit(false);
	         
	         pstmt = super.conn.prepareStatement(sql);

	         
	         cnt = pstmt.executeUpdate();
	         super.conn.commit();
	      
	      } catch (Exception e) {
	         SQLException err = (SQLException) e; // sql error code 잡아내기
	         cnt = -err.getErrorCode(); // 오라클 오류상수가 리턴
	         e.printStackTrace();
	         try {
	            conn.rollback();
	         } catch (Exception e1) {
	            e1.printStackTrace();
	         }
	      } finally {
	         try {
	            if (pstmt != null)
	               pstmt.close();
	            super.closeConnection();
	         } catch (Exception e2) {
	            e2.printStackTrace();
	         }
	         
	      }
	      return cnt;
	   }
	 
	public int DeleteMovie(int mvid) {
		PreparedStatement pstmt = null;
		String sql = "delete from movies where mvid = ?";
		int cnt = -99999;
		try {
			if (super.conn == null) {
				super.conn = super.getConnection();
			}
			super.conn.setAutoCommit(false);
			pstmt = super.conn.prepareStatement(sql);

			pstmt.setInt(1, mvid);

			cnt = pstmt.executeUpdate();
			super.conn.commit();
		} catch (Exception e) {
			SQLException err = (SQLException) e;// sql error code 잡아내기
			cnt = -err.getErrorCode(); // 오라클 오류상수가 리턴
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return cnt;
	}

}
