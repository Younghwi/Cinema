package model;

public class Join05 {

	private String mname;
	private String mid;
	private String writedate;
	private String comments;
	private int starpoint;
	
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public int getStarpoint() {
		return starpoint;
	}
	public void setStarpoint(int starpoint) {
		this.starpoint = starpoint;
	}
	@Override
	public String toString() {
		return "Join05 [mname=" + mname + ", mid=" + mid + ", writedate=" + writedate + ", comments=" + comments
				+ ", starpoint=" + starpoint + "]";
	}

}


