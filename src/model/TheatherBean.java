package model;

public class TheatherBean {
   private int tid;      //��ȭ�� ������ȣ
   private String tname;   //��ȭ�� �̸�
   private int startseat;   //��ȭ�� ���� �¼���ȣ
   private int endseat;   //��ȭ�� �� �¼���ȣ
   private int price;  
   private String timage;//��ȭ���� ����
   public int getTid() {
      return tid;
   }
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
public int getStartseat() {
	return startseat;
}
public void setStartseat(int startseat) {
	this.startseat = startseat;
}
public int getEndseat() {
	return endseat;
}
public void setEndseat(int endseat) {
	this.endseat = endseat;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getTimage() {
	return timage;
}
public void setTimage(String timage) {
	this.timage = timage;
}
public void setTid(int tid) {
	this.tid = tid;
}
@Override
public String toString() {
	return "TheatherBean [tid=" + tid + ", tname=" + tname + ", startseat=" + startseat + ", endseat=" + endseat
			+ ", price=" + price + ", timage=" + timage + "]";
}
 
}