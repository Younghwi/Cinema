package model;
/*
 * 상영관, 예매영화, 상영일자, 상영시간, 상영회차
 * 를 나타내기위해 사용한 조인문장을 위한 클래스
 * 각각의 객체를 생성하는 것보다 효율적이라 생각.
 * */
public class Join03 {
		
	private String tname;
	private String mname;
	private String playdate;
	private String starttime ;
	private int psorder ;
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
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
	@Override
	public String toString() {
		return "Join03 [tname=" + tname + ", mname=" + mname + ", playdate=" + playdate + ", starttime=" + starttime
				+ ", psorder=" + psorder + "]";
	}
	
}
	