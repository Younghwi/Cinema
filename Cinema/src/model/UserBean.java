package model;

public class UserBean {
	private String id;			//회원 아이디
	private String password;	//회원 비밀번호
	private String name;		//회원 이름
	private String gender;		//회원 성별
	private String birth;		//회원 생년월일 date이지만 string으로
	private String zipcode ;	//우편번호 추가
	private String address1;	//주소 1
	private String address2;	//주소 2
	private String phone;	//핸드폰 번호
	private int point;			//등급을 나눌 포인트
	private String grade;		//회원 등급
	
	//getter
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public String getBirth() {
		return birth;
	}
	public String getZipcode() {
		return zipcode;
	}
	public String getAddress1() {
		return address1;
	}
	public String getAddress2() {
		return address2;
	}
	public String getPhone() {
		return phone;
	}
	public int getPoint() {
		return point;
	}
	public String getGrade() {
		return grade;
	}
	
	//setter
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", password=" + password + ", name=" + name + ", gender=" + gender + ", birth="
				+ birth + ", zipcode=" + zipcode + ", address1=" + address1 + ", address2=" + address2 + ", phone="
				+ phone + ", point=" + point + ", grade=" + grade + "]";
	}
	

}
