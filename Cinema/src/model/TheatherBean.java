package model;

public class TheatherBean {
   private int tid;      //��ȭ�� ������ȣ
   private String tname;   //��ȭ�� �̸�
   private int startseat;   //��ȭ�� ���� �¼���ȣ
   private int endseat;   //��ȭ�� �� �¼���ȣ
   private int price;      //��ȭ���� ����
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