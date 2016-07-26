package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TheatherDAO extends SuperDAO{	
	
   public List<TheatherBean> SelectTheather() {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = " select * from theathers ";
      List<TheatherBean> theatherslist = new ArrayList<TheatherBean>();
      
      try {
         if (conn == null) {
            super.conn = super.getConnection();
         }
         pstmt = super.conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         while(rs.next()){
        	 TheatherBean tbean = new TheatherBean();
            tbean.setTid(rs.getInt("tid"));
            tbean.setTname(rs.getString("tname"));
            tbean.setStartseat(rs.getInt("startseat"));
            tbean.setEndseat(rs.getInt("endseat"));
            tbean.setPrice(rs.getInt("price"));
            tbean.setTimage(rs.getString("timage"));
            theatherslist.add(tbean);

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
      
      
      return theatherslist;
   }

   public int InsertTheather(TheatherBean Theather) {
      PreparedStatement pstmt = null;
      String sql = " insert into theathers(tid, tname, startseat, endseat, price,timage) ";
      sql += " values(?,?,?,?,?,?) ";
      
      int cnt = -99999;
      
      try {
         if(super.conn == null) { super.getConnection(); }
         
         super.conn.setAutoCommit(false);
         
         pstmt = super.conn.prepareStatement(sql);
         pstmt.setInt(1, Theather.getTid());
         pstmt.setString(2, Theather.getTname());
         pstmt.setInt(3, Theather.getStartseat());
         pstmt.setInt(4, Theather.getEndseat());
         pstmt.setInt(5, Theather.getPrice());
         pstmt.setString(5, Theather.getTimage());
         
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
    public int UpdateTheater(TheatherBean Theather){
         PreparedStatement pstmt = null;
         
         String sql = " Update Theathers set tname = ?, startseat = ?,"
         		+ " endseat = ?, price = ?, timage = ? where tid = ? ";         
         int cnt = -99999;
         
         try {
            if(super.conn == null) { super.getConnection(); }
            
            super.conn.setAutoCommit(false);
            
            pstmt = super.conn.prepareStatement(sql);
  
          pstmt.setString(1, Theather.getTname());          
          pstmt.setInt(2, Theather.getStartseat());
          pstmt.setInt(3, Theather.getEndseat());
          pstmt.setInt(4, Theather.getPrice());
          pstmt.setString(1, Theather.getTimage());     
          pstmt.setInt(5, Theather.getTid());   
          
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
    
   public int DeleteTheater(int tid) {
      PreparedStatement pstmt = null;
      String sql = "delete from Theathers where tid = ?";
      int cnt = -99999;
      try {
         if (super.conn == null) {
            super.conn = super.getConnection();
         }
         super.conn.setAutoCommit(false);
         pstmt = super.conn.prepareStatement(sql);

         pstmt.setInt(1, tid);

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