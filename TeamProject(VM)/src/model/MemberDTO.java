package model;

public class MemberDTO {
	private String memberId;
	private String password;
	private String condition;

	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	@Override
	public String toString() {
		return "MemberDTO [memberId=" + memberId + ", password=" + password + ", condition=" + condition + "]";
	}
  
}