package model;

public class CommentBean {
   private int cno;         // 한줄평 고유번호
   private String mid;         // 작성자 아이디
   private int mvid;         // 영화 고유번호
   private String comments;   // 한줄평
   private String writedate;   // 작성일자
   private int startpoint;      // 별점
   public int getCno() {
      return cno;
   }
   public String getMid() {
      return mid;
   }
   public int getMvid() {
      return mvid;
   }
   public String getComments() {
      return comments;
   }
   public String getWritedate() {
      return writedate;
   }
   public int getStartpoint() {
      return startpoint;
   }
   public void setCno(int cno) {
      this.cno = cno;
   }
   public void setMid(String mid) {
      this.mid = mid;
   }
   public void setMvid(int mvid) {
      this.mvid = mvid;
   }
   public void setComments(String comments) {
      this.comments = comments;
   }
   public void setWritedate(String writedate) {
      this.writedate = writedate;
   }
   public void setStartpoint(int startpoint) {
      this.startpoint = startpoint;
   }
   @Override
   public String toString() {
      return "CommentBean [cno=" + cno + ", mid=" + mid + ", mvid=" + mvid + ", comments=" + comments + ", writedate="
            + writedate + ", startpoint=" + startpoint + "]";
   }
   
}