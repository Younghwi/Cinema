package model;

public class CommentBean {
   private int cno;         // ������ ������ȣ
   private String mid;         // �ۼ��� ���̵�
   private int mvid;         // ��ȭ ������ȣ
   private String comments;   // ������
   private String writedate;   // �ۼ�����
   private int starpoint;      // ����
   
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
   public int getStarpoint() {
      return starpoint;
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
   public void setStarpoint(int starpoint) {
      this.starpoint = starpoint;
   }
   @Override
   public String toString() {
      return "CommentBean [cno=" + cno + ", mid=" + mid + ", mvid=" + mvid + ", comments=" + comments + ", writedate="
            + writedate + ", starpoint=" + starpoint + "]";
   }
   
}