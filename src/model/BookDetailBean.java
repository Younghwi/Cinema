package model;

public class BookDetailBean {
	private int bdno;
	private int bno;
	private int sno;
	private String seatno;
	
	public int getBdno() {
		return bdno;
	}
	public void setBdno(int bdno) {
		this.bdno = bdno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSeatno() {
		return seatno;
	}
	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}
	@Override
	public String toString() {
		return "BookDetailBean [bdno=" + bdno + ", bno=" + bno + ", sno=" + sno + ", seatno=" + seatno + "]";
	}
	
	
	
	
}
