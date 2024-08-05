package view;

import model.MemberDTO;

public class LogoutView extends View {
	// 회원가입
	// 로그인
	public void printMenuList() {
		System.out.println("5. 로그인");
		System.out.println("6. 회원가입");
	}
	public void printSinUpFalse() {
		System.out.println("회원가입에 실패하였습니다");
	}
	public void printSinUpTrue() {
		System.out.println("회원가입에 성공했습니다");
	}
	public void printcation() {
		System.out.println("아이디가 중복되었습니다");
	}
	public MemberDTO inputSignUp(){
		System.out.print("원하는 아이디 입력 >> ");
		String mid=sc.next();
		System.out.print("원하는 비밀번호 입력 >> ");
		String password=sc.next();
		System.out.print("원하는 이름 입력 >> ");
		String name=sc.next();
		MemberDTO data=new MemberDTO();
		data.setMid(mid);
		data.setPassword(password);
		data.setName(name);
		return data;
		
	}
	public MemberDTO inputLoginInfo() {
		System.out.print("아이디 입력 >> ");
		String mid=sc.next();
		System.out.print("비밀번호 입력 >> ");
		String password=sc.next();
		MemberDTO data=new MemberDTO();
		data.setMid(mid);
		data.setPassword(password);
		return data;
	}
}
