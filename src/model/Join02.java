package model;
/*
 * 예매번호, 예매자, 예매영화, 예매일자, 예매수량, 총 금액
 * 를 나타내기위해 사용한 조인문장을 위한 클래스
 * 각각의 객체를 생성하는 것보다 효율적이라 생각.
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
