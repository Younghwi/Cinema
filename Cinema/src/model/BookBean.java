package model;

public class BookBean {

   private int bno;      //예약번호
   private String mid;      //예약자 아이디
   private int mvid;      //영화번호
   private int tid;      //영화관번호
   private String bookdate;//예매일   
   private int amount;      //예매 수량
   private String renote;   //회원탈퇴시 저장할 정보
   public int getBno() {
      return bno;
   }
   public String getMid() {
      return mid;
   }
   public int getMvid() {
      return mvid;
   }
   public int getTid() {
      return tid;
   }
   public String getBookdate() {
      return bookdate;
   }
   public int getAmount() {
      return amount;
   }
   public String getRenote() {
      return renote;
   }
   public void setBno(int bno) {
      this.bno = bno;
   }
   public void setMid(String mid) {
      this.mid = mid;
   }
   public void setMvid(int mvid) {
      this.mvid = mvid;
   }
   public void setTid(int tid) {
      this.tid = tid;
   }
   public void setBookdate(String bookdate) {
      this.bookdate = bookdate;
   }
   public void setAmount(int amount) {
      this.amount = amount;
   }
   public void setRenote(String renote) {
      this.renote = renote;
   }
   @Override
   public String toString() {
      return "BookBean [bno=" + bno + ", mid=" + mid + ", mvid=" + mvid + ", tid=" + tid + ", bookdate=" + bookdate
            + ", amount=" + amount + ", renote=" + renote + "]";
   }
}