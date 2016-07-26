package model;

public class Join06 {
	
	private int mvid;
	private String mname;
	private String playdate;
	private int psorder;
	private String stringImage;
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
	public int getPsorder() {
		return psorder;
	}
	public void setPsorder(int psorder) {
		this.psorder = psorder;
	}
	public String getStringImage() {
		return stringImage;
	}
	public void setStringImage(String stringImage) {
		this.stringImage = stringImage;
	}
	
	@Override
	public String toString() {
		return "Join06 [mvid=" + mvid + ", mname=" + mname + ", playdate=" + playdate + ", psorder=" + psorder
				+ ", stringImage=" + stringImage + "]";
	}
	
	

}


