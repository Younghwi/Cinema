package model;
/*
 * ���Ź�ȣ, ������, ���ſ�ȭ, ��������, ������, �󿵰�, �����¼�
 * �� ��Ÿ�������� ����� ���ι����� ���� Ŭ����
 * ������ ��ü�� �����ϴ� �ͺ��� ȿ�����̶� ����.
 * */
public class Join01 {
	
	private int bno;
	private String name;
	private String mname;
	private String bookdate;
	private String playdate;
	private int psorder;
	private String tname;
	private int seatno;
	
	public int getBno() {
		return bno;
	}
	public String getName() {
		return name;
	}
	public String getMname() {
		return mname;
	}
	public String getBookdate() {
		return bookdate;
	}
	public String getPlaydate() {
		return playdate;
	}
	public int getPsorder() {
		return psorder;
	}
	public String getTname() {
		return tname;
	}
	public int getSeatno() {
		return seatno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public void setBookdate(String bookdate) {
		this.bookdate = bookdate;
	}
	public void setPlaydate(String playdate) {
		this.playdate = playdate;
	}
	public void setPsorder(int psorder) {
		this.psorder = psorder;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}
	@Override
	public String toString() {
		return "Join01 [bno=" + bno + ", name=" + name + ", mname=" + mname + ", bookdate=" + bookdate + ", playdate="
				+ playdate + ", psorder=" + psorder + ", tname=" + tname + ", seatno=" + seatno + "]";
	}
	
	

}
