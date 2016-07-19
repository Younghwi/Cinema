package model;
/*
 * 예매번호, 예매자, 예매영화, 예매일자, 상영일자, 상영관, 예매좌석
 * 를 나타내기위해 사용한 조인문장을 위한 클래스
 * 각각의 객체를 생성하는 것보다 효율적이라 생각.
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
