package model;
/*
 * �󿵰�, ���ſ�ȭ, ������, �󿵽ð�, ��ȸ��
 * �� ��Ÿ�������� ����� ���ι����� ���� Ŭ����
 * ������ ��ü�� �����ϴ� �ͺ��� ȿ�����̶� ����.
 * */
public class Join03 {
		
	private String tname;
	private String mname;
	private int mvid;
	private String playdate;
	private String starttime ;
	private int psorder ;
	private int startseat;
	private int endseat;
	private int price;
	private int tid;
	private int sno;
	
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getMvid() {
		return mvid;
	}
	public void setMvid(int mvid) {
		this.mvid = mvid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getPlaydate() {
		return playdate;
	}
	public void setPlaydate(String playdate) {
		this.playdate = playdate;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public int getPsorder() {
		return psorder;
	}
	public void setPsorder(int psorder) {
		this.psorder = psorder;
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
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	@Override
	public String toString() {
		return "Join03 [tname=" + tname + ", mname=" + mname + ", mvid=" + mvid + ", playdate=" + playdate
				+ ", starttime=" + starttime + ", psorder=" + psorder + ", startseat=" + startseat + ", endseat="
				+ endseat + ", price=" + price + ", tid=" + tid + ", sno=" + sno + "]";
	}
	



	
}
	