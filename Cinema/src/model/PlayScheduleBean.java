package model;

public class PlayScheduleBean {
	private int sno;
	private int mvno;
	private int tid;
	private String playdate;
	private String starttime;
	private int psorder;
	public int getSno() {
		return sno;
	}
	public int getMvno() {
		return mvno;
	}
	public int getTid() {
		return tid;
	}
	public String getPlaydate() {
		return playdate;
	}
	public String getStarttime() {
		return starttime;
	}
	public int getPsorder() {
		return psorder;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public void setMvno(int mvno) {
		this.mvno = mvno;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public void setPlaydate(String playdate) {
		this.playdate = playdate;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public void setPsorder(int psorder) {
		this.psorder = psorder;
	}
	@Override
	public String toString() {
		return "PlayScheduleBean [sno=" + sno + ", mvno=" + mvno + ", tid=" + tid + ", playdate=" + playdate
				+ ", starttime=" + starttime + ", psorder=" + psorder + "]";
	}

}
