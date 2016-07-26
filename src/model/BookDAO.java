package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO extends SuperDAO{

	public List<BookBean> SelectDataList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select * from books ";
		
		List<BookBean> bookinglist = new ArrayList<BookBean>();
		
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BookBean bean = new BookBean();
				bean.setBno(rs.getInt("bno"));
				bean.setMid(rs.getString("mid"));
				bean.setMvid(rs.getInt("mvid"));
				bean.setTid(rs.getInt("tid"));
				bean.setBookdate(String.valueOf(rs.getDate("bookdate")));
				bean.setAmount(rs.getInt("amount"));
				bookinglist.add(bean);

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
		
		return bookinglist;
	}

	public int InsertBook(BookBean booking) {
		PreparedStatement pstmt = null;
		String sql = " insert into books(bno, mid, mvid, tid, bookdate, amount) ";
		sql += " values(bookseq.nextval,?,?,?,?,?) ";
		
		int cnt = -99999;
		
		try {
			if(super.conn == null) { super.getConnection(); }
			
			super.conn.setAutoCommit(false);
			
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setString(1, booking.getMid());
			pstmt.setInt(2, booking.getMvid());
			pstmt.setInt(3, booking.getTid());
			pstmt.setString(4, booking.getBookdate());
			pstmt.setInt(5, booking.getAmount());
			
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
	 public int UpdateBook(MovieBean movie){
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

	public MovieBean SelectDataPK(int mvid) {
			PreparedStatement pstmt = null ;
			ResultSet rs = null ;				
			String sql = "select * " ;
			sql += " from movies " ; 
			sql += " where mvid = ? " ;
			MovieBean bean = null ;
			try {
				if( this.conn == null ){ this.conn = this.getConnection() ; }			
				pstmt = this.conn.prepareStatement(sql) ;			
				//placehodelr 치환은 반드시 execute 메소드 실행 바로 직전에 하세요. 
				pstmt.setInt( 1, mvid ); 
				rs = pstmt.executeQuery() ; 
				
				if ( rs.next() ) {
					bean = new MovieBean() ;
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
				}
				
			} catch (SQLException e) {			
				e.printStackTrace();
			} finally{
				try {
					if( rs != null){ rs.close(); } 
					if( pstmt != null){ pstmt.close(); } 
					this.closeConnection() ;
				} catch (Exception e2) {
					e2.printStackTrace(); 
				}
			} 		
			return bean  ;
	}

}
