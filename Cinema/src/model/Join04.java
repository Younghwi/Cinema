package model;
/*
 * 상영관, 상영회차, 예매 좌석
 * 를 나타내기위해 사용한 조인문장을 위한 클래스
 * 각각의 객체를 생성하는 것보다 효율적이라 생각.
 * */
public class Join04 {
	private String tname;
	private int psorder ;
	private int seatno ;
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getPsorder() {
		return psorder;
	}
	public void setPsorder(int psorder) {
		this.psorder = psorder;
	}
	public int getSeatno() {
		return seatno;
	}
	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}
	@Override
	public String toString() {
		return "Join04 [tname=" + tname + ", psorder=" + psorder + ", seatno=" + seatno + "]";
	}
	
}
	