package model;

public class Zipcode {
	private String zipcode;	//우편번호를 저장할 변수
	private String sido; //도시 또는 도를 저장할 변수
	private String gugun; //구 또는 소도시를 저장할 변수
	private String dong; //동 또는 면,리를 저장할 변수
	private String bunji; //주소의 번지를 저장할 변수
	private int seqnum ;
	
	public void setZipcode(String zipcode){ this.zipcode=zipcode;	}
	public void setSido(String sido){ this.sido=sido; 	}
	public void setGugun(String gugun){ this.gugun=gugun; 	}
	public void setDong(String dong){ this.dong=dong; 	}
	public void setBunji(String bunji){ this.bunji=bunji; 	}
	public String getZipcode(){ return zipcode; }
	public String getSido(){ return sido; }
	public String getGugun(){ 	return gugun; }
	public String getDong(){ 	return dong; 	}
	public String getBunji(){ 	return bunji;  	}
	public int getSeqnum() {return seqnum;}
	public void setSeqnum(int seqnum) { this.seqnum = seqnum;}	
}
