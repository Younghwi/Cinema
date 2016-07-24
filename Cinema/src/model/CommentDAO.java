package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO extends SuperDAO {


	   public List<CommentBean> SelectDataList() {
		      PreparedStatement pstmt = null;
		      ResultSet rs = null;
		      String sql = " select * from comments ";
		      List<CommentBean> commentlist = new ArrayList<CommentBean>();
		      
		      try {
		         if (conn == null) {
		            super.conn = super.getConnection();
		         }
		         pstmt = super.conn.prepareStatement(sql);
		         rs = pstmt.executeQuery();
		         while(rs.next()){
		        	CommentBean bean = new CommentBean();
		            bean.setCno(rs.getInt("cno"));
		            bean.setMid(rs.getString("mid"));
		            bean.setMvid(rs.getInt("mvid"));
		            bean.setComments(rs.getString("comments"));
		            bean.setWritedate(String.valueOf(rs.getDate("writedate")));
		            bean.setStarpoint(rs.getInt("starpoint"));

		      
		    	   commentlist.add(bean);
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
		      
		      
		      return commentlist;
		   }
	   
	   

	   public int InsertComment(CommentBean comment) {
	      PreparedStatement pstmt = null;
	      String sql = " insert into comments(cno, mid, mvid, comments, writedate, starpoint) ";
	      sql += " values(commentseq.nextval,?,?,?,?,?) ";
	      
	      int cnt = -99999;
	      
	      try {
	         if(super.conn == null) { super.getConnection(); }
	         
	         super.conn.setAutoCommit(false);
	         
	         pstmt = super.conn.prepareStatement(sql);
	         pstmt.setString(1, comment.getMid());
	         pstmt.setInt(2, comment.getMvid());
	         pstmt.setString(3, comment.getComments());
	         pstmt.setString(4, comment.getWritedate());
	         pstmt.setInt(5, comment.getStarpoint());
	         
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
	   
	   
	   

	   public int UpdateComment(CommentBean comment){
	      PreparedStatement pstmt = null;
	      
	      String sql = " Update comments set mid = ?, mvid = ?, comments = ?, writedate = ?, startpoint = ? where cno = ? ";
	      int cnt = -99999;
	      
	      try {
	         if(super.conn == null) { super.getConnection(); }
	         
	         super.conn.setAutoCommit(false);
	         
	         pstmt = super.conn.prepareStatement(sql);

	         pstmt.setString(1, comment.getMid());
	         pstmt.setInt(2, comment.getMvid());
	         pstmt.setString(3, comment.getComments());
	         pstmt.setString(4, comment.getWritedate());
	         pstmt.setInt(5, comment.getStarpoint());
	         pstmt.setInt(6, comment.getCno());

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
	   
	   
	   
	   
	   

	   public int DeleteComment(int cno) {
	      PreparedStatement pstmt = null;
	      String sql = "delete from comments where cno = ?";
	      int cnt = -99999;
	      try {
	         if (super.conn == null) {
	            super.conn = super.getConnection();
	         }
	         super.conn.setAutoCommit(false);
	         pstmt = super.conn.prepareStatement(sql);

	         pstmt.setInt(1, cno);

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
