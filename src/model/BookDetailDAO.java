package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDetailDAO extends SuperDAO{

	public List<BookDetailBean> SelectDataList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select * from movies ";
		List<BookDetailBean> BookDetaillist = new ArrayList<BookDetailBean>();
		
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BookDetailBean bean = new BookDetailBean();
				bean.setBdno(rs.getInt("bdno"));
				bean.setBno(rs.getInt("bno"));
				bean.setSno(rs.getInt("sno"));
				bean.setSeatno(rs.getString("seatno"));
				BookDetaillist.add(bean);
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
		
		
		return BookDetaillist;
	}

	public int InsertMovie(BookDetailBean bookdetail) {
		int cnt = -99999;
		
		PreparedStatement pstmt = null;
		String sql = " insert into bookdetails(bdno, bno, sno, seatno) ";
		sql += " values(bookdetailseq.nextval,?,?,?) ";

		try {
			if(super.conn == null) { super.getConnection(); }
			
			super.conn.setAutoCommit(false);
			
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setInt(1, bookdetail.getBno());
			pstmt.setInt(2, bookdetail.getSno());
			pstmt.setString(3, bookdetail.getSeatno());
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
	 public int UpdateMovie(BookDetailBean movie){
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

	public BookDetailBean SelectDataPK(int mvid) {
			PreparedStatement pstmt = null ;
			ResultSet rs = null ;				
			String sql = "select * " ;
			sql += " from movies " ; 
			sql += " where mvid = ? " ;
			BookDetailBean bean = null ;
			try {
				if( this.conn == null ){ this.conn = this.getConnection() ; }			
				pstmt = this.conn.prepareStatement(sql) ;			
				//placehodelr 치환은 반드시 execute 메소드 실행 바로 직전에 하세요. 
				pstmt.setInt( 1, mvid ); 
				rs = pstmt.executeQuery() ; 
				
				if ( rs.next() ) {
					bean = new BookDetailBean() ;

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
