package model;

public class TheatherBean {
   private int tid;      //영화관 고유번호
   private String tname;   //영화관 이름
   private int startseat;   //영화관 시작 좌석번호
   private int endseat;   //영화관 끝 좌석번호
   private int price;      //영화관별 가격
   public int getTid() {
      return tid;
   }
   public String getTname() {
      return tname;
   }
   public int getStartseat() {
      return startseat;
   }
   public int getEndseat() {
      return endseat;
   }
   public int getPrice() {
      return price;
   }
   public void setTid(int tid) {
      this.tid = tid;
   }
   public void setTname(String tname) {
      this.tname = tname;
   }
   public void setStartseat(int startseat) {
      this.startseat = startseat;
   }
   public void setEndseat(int endseat) {
      this.endseat = endseat;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   @Override
   public String toString() {
      return "TheatherBean [tid=" + tid + ", tname=" + tname + ", startseat=" + startseat + ", endseat=" + endseat
            + ", price=" + price + "]";
   }

}