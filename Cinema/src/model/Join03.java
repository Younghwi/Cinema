package model;
/*
 * �󿵰�, ���ſ�ȭ, ������, �󿵽ð�, ��ȸ��
 * �� ��Ÿ�������� ����� ���ι����� ���� Ŭ����
 * ������ ��ü�� �����ϴ� �ͺ��� ȿ�����̶� ����.
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
	