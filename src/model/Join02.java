package model;
/*
 * ���Ź�ȣ, ������, ���ſ�ȭ, ��������, ���ż���, �� �ݾ�
 * �� ��Ÿ�������� ����� ���ι����� ���� Ŭ����
 * ������ ��ü�� �����ϴ� �ͺ��� ȿ�����̶� ����.
 * */
public class Join02 {
		
	private int bno;
	private String name;
	private String mname;
	private String bookdate;
	private int amount ;
	private int totalprice ;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getBookdate() {
		return bookdate;
	}
	public void setBookdate(String bookdate) {
		this.bookdate = bookdate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	@Override
	public String toString() {
		return "Join02 [bno=" + bno + ", name=" + name + ", mname=" + mname + ", bookdate=" + bookdate + ", amount="
				+ amount + ",  totalprice=" + totalprice + "]";
	}

}
