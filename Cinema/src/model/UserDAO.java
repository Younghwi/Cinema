package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends SuperDAO{

   public List<UserBean> SelectDataList() {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = " select * from users ";
      List<UserBean> userlist = new ArrayList<UserBean>();
      
      try {
         if (conn == null) {
            super.conn = super.getConnection();
         }
         pstmt = super.conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         while(rs.next()){
            UserBean bean = new UserBean();
            bean.setId(rs.getString("id"));
            bean.setPassword(rs.getString("password"));
            bean.setName(rs.getString("name"));
            bean.setGender(rs.getString("gender"));
            bean.setBirth(String.valueOf(rs.getDate("birth")));
            bean.setZipcode(rs.getString("zipcode"));
            bean.setAddress1(rs.getString("address1"));
            bean.setAddress2(rs.getString("address2"));
            bean.setPhone(rs.getString("phone"));
            bean.setPoint(rs.getInt("point"));
            bean.setGrade(rs.getString("grade"));
            userlist.add(bean);
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
      
      
      return userlist;
   }
   
   public UserBean SelectDataPK(String id) {
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = " select * from users where id = ? ";
	      UserBean bean = null ;
	      try {
	         if (conn == null) {
	            this.conn = this.getConnection();
	         }
	         pstmt = this.conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()){
            	bean = new UserBean() ;
	            bean.setId(rs.getString("id"));
	            bean.setPassword(rs.getString("password"));
	            bean.setName(rs.getString("name"));
	            bean.setGender(rs.getString("gender"));
	            bean.setBirth(String.valueOf(rs.getDate("birth")));
	            bean.setZipcode(rs.getString("zipcode"));
	            bean.setAddress1(rs.getString("address1"));
	            bean.setAddress2(rs.getString("address2"));
	            bean.setPhone(rs.getString("phone"));
	            bean.setPoint(rs.getInt("point"));
	            bean.setGrade(rs.getString("grade"));
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
	      
	      
	      return bean;
	   }

   public int InsertUser(UserBean user) {
      PreparedStatement pstmt = null;
      String sql = " insert into users(id, password, name, gender, birth, zipcode, address1, address2, phone, point, grade) ";
      sql += " values(?,?,?,?,?,?,?,?,?,?,?) ";
      
      int cnt = -99999;
      
      try {
         if(super.conn == null) { super.getConnection(); }
         
         super.conn.setAutoCommit(false);
         
         pstmt = super.conn.prepareStatement(sql);
         pstmt.setString(1, user.getId());
         pstmt.setString(2, user.getPassword());
         pstmt.setString(3, user.getName());
         pstmt.setString(4, user.getGender());
         pstmt.setString(5, user.getBirth());
         pstmt.setString(6, user.getZipcode());
         pstmt.setString(7, user.getAddress1());
         pstmt.setString(8, user.getAddress2());
         pstmt.setString(9, user.getPhone());
         pstmt.setInt(10, user.getPoint());
         pstmt.setString(11, user.getGrade());
         
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
   
   public int UpdateUser(UserBean user){
      PreparedStatement pstmt = null;
      
      String sql = " Update users set password = ?, name = ?, gender = ?, birth = ?, zipcode = ?, ";
      sql+= " address1 = ?, address2 = ?, phone = ?, point = ?, grade = ? where id = ? ";
      int cnt = -99999;
      
      try {
         if(super.conn == null) { super.getConnection(); }
         
         super.conn.setAutoCommit(false);
         
         pstmt = super.conn.prepareStatement(sql);
         
         pstmt.setString(1, user.getPassword());
         pstmt.setString(2, user.getName());
         pstmt.setString(3, user.getGender());
         pstmt.setString(4, user.getBirth());
         pstmt.setString(5, user.getZipcode());
         pstmt.setString(6, user.getAddress1());
         pstmt.setString(7, user.getAddress2());
         pstmt.setString(8, user.getPhone());
         pstmt.setInt(9, user.getPoint());
         pstmt.setString(10, user.getGrade());
         pstmt.setString(11, user.getId());
         
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

   public int DeleteUser(String id) {
      PreparedStatement pstmt = null;
      String sql = "delete from users where id = ?";
      int cnt = -99999;
      try {
         if (super.conn == null) {
            super.conn = super.getConnection();
         }
         super.conn.setAutoCommit(false);
         pstmt = super.conn.prepareStatement(sql);

         pstmt.setString(1, id);

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
   
   public List<Zipcode> SelectDataZipcode(String dong) {
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql = "select * from zipcodes " ;
		sql += " where dong like '" + dong + "%'" ;
		sql += " order by sido asc, gugun asc, dong asc " ; 
		List<Zipcode> lists = new ArrayList<Zipcode>();
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			pstmt = super.conn.prepareStatement(sql) ;			
			 
			rs = pstmt.executeQuery() ;			
			while( rs.next() ){
				Zipcode bean = new Zipcode();
				bean.setSido( rs.getString("sido") );
				bean.setBunji( rs.getString("bunji") );
				bean.setDong( rs.getString("dong") );
				bean.setGugun( rs.getString("gugun") );
				bean.setZipcode( rs.getString("zipcode") );
				bean.setSeqnum( Integer.parseInt( rs.getString("seqnum") ));
				 
				lists.add( bean ) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if( rs != null ){ rs.close(); }
				if( pstmt != null ){ pstmt.close(); }
				super.closeConnection(); 
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}		
		return lists ;
	}


}