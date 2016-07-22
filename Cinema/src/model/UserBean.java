package model;

public class UserBean {
	private String id;			//ȸ�� ���̵�
	private String password;	//ȸ�� ��й�ȣ
	private String name;		//ȸ�� �̸�
	private String gender;		//ȸ�� ����
	private String birth;		//ȸ�� ������� date������ string����
	private String zipcode ;	//�����ȣ �߰�
	private String address1;	//�ּ� 1
	private String address2;	//�ּ� 2
	private String phone;	//�ڵ��� ��ȣ
	private int point;			//����� ���� ����Ʈ
	private String grade;		//ȸ�� ���
	
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
