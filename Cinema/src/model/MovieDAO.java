package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO extends SuperDAO{

	public List<MovieBean> SelectDataList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select * from movies ";
		List<MovieBean> movielist = new ArrayList<MovieBean>();
		
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				MovieBean bean = new MovieBean();
				bean.setMvid(rs.getInt("mvid"));
				bean.setMname(rs.getString("mname"));
				bean.setOpendate(String.valueOf(rs.getDate("opendate")));
				bean.setDirector(rs.getString("director"));
				bean.setGenre(rs.getString("genre"));
				bean.setPlayingtime(rs.getInt("playingtime"));
				bean.setStory(rs.getString("story"));
				bean.setRating(rs.getString("rating"));
				bean.setDistributor(rs.getString("distributor"));
				bean.setActor(rs.getString("actor"));
				bean.setCondition(rs.getInt("condition"));
				bean.setStringImage(rs.getString("image"));
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

	public int InsertMovie(MovieBean movie) {
		PreparedStatement pstmt = null;
		String sql = " insert into movies(mvid, mname, opendate, director, genre, playingtime, story, rating, distributor, actor, condition, image) ";
		sql += " values(?,?,?,?,?,?,?,?,?,?,?,?) ";
		
		int cnt = -99999;
		
		try {
			if(super.conn == null) { super.getConnection(); }
			
			super.conn.setAutoCommit(false);
			
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setInt(1, movie.getMvid());
			pstmt.setString(2, movie.getMname());
			pstmt.setString(3, movie.getOpendate());
			pstmt.setString(4, movie.getDirector());
			pstmt.setString(5, movie.getGenre());
			pstmt.setInt(6, movie.getPlayingtime());
			pstmt.setString(7, movie.getStory());
			pstmt.setString(8, movie.getRating());
			pstmt.setString(9, movie.getDistributor());
			pstmt.setString(10, movie.getActor());
			pstmt.setInt(11, movie.getCondition());
			pstmt.setString(12, movie.getStringImage());
			
			
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
	 public int UpdateMovie(MovieBean movie){
	      PreparedStatement pstmt = null;
	      
	      String sql = " Update movies set mname = ?, opendate = ?, director = ?, genre = ?, ";
	      sql+= " playingtime = ?, story = ?, rating = ?, distributor = ?, actor = ?, condition = ?, Image = ? where mvid = ? ";
	      int cnt = -99999;
	      
	      try {
	         if(super.conn == null) { super.getConnection(); }
	         
	         super.conn.setAutoCommit(false);
	         
	         pstmt = super.conn.prepareStatement(sql);
				
			 pstmt.setString(1, movie.getMname());
			 pstmt.setString(2, movie.getOpendate());
			 pstmt.setString(3, movie.getDirector());
			 pstmt.setString(4, movie.getGenre());
			 pstmt.setInt(5, movie.getPlayingtime());
			 pstmt.setString(6, movie.getStory());
			 pstmt.setString(7, movie.getRating());
			 pstmt.setString(8, movie.getDistributor());
			 pstmt.setString(9, movie.getActor());
			 pstmt.setInt(10, movie.getCondition());
			 pstmt.setString(11, movie.getStringImage());
	         pstmt.setInt(12, movie.getMvid());

	         
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
