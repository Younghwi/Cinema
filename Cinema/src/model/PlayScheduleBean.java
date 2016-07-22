package model;

public class PlayScheduleBean {
	private int sno;
	private int mvid;
	private int tid;
	private String playdate;
	private String starttime;
	private int psorder;
	public int getSno() {
		return sno;
	}
	public int getMvid() {
		return mvid;
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
	public void setMvid(int mvid) {
		this.mvid = mvid;
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
		return "PlayScheduleBean [sno=" + sno + ", mvid=" + mvid + ", tid=" + tid + ", playdate=" + playdate
				+ ", starttime=" + starttime + ", psorder=" + psorder + "]";
	}

}
