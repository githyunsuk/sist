package smk;

public class MemberVO {

	private String memberId;
	private String password;
	private String name;
	
	public MemberVO() {
		
	}
	
	public MemberVO(String memberId, String password, String name) {
		super();
		this.memberId = memberId;
		this.password = password;
		this.name = name;
	}

	public String getMemberId() {
		return memberId;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", password=" + password + ", name=" + name + "]";
	}
	
}

