package model;
/*
 * �󿵰�, ��ȸ��, ���� �¼�
 * �� ��Ÿ�������� ����� ���ι����� ���� Ŭ����
 * ������ ��ü�� �����ϴ� �ͺ��� ȿ�����̶� ����.
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
	