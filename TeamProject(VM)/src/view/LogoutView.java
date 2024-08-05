package view;

import java.util.Scanner;

import model.MemberDTO;

public class LogoutView {
	private static Scanner sc; 

	public LogoutView(){
		sc = new Scanner(System.in);
	}
	//2.회원가입
	//회원가입
	//아이디와 비밀번호(유효성)를 입력
	//이비밀번호가 확실합니까?
	//비밀번호 확인 :
	//위의 비밀번호랑 아래비밀번호가 같으면 성공~


	//-유효성검사
	//성공하면 회원가입 완료!
	//실패하면 실패..관리자에게 연락부탁드립니다..
	public void printMenuList() {
		//로그인
		//회원가입
		System.out.println("1.로그인");
		System.out.println("2.회원가입");
	}
	//회원가입
	//아이디입력

	public String inputMemberId() {
		//아이디입력
		System.out.print("아이디 입력 >> ");
		String memberId=sc.next();
		return memberId;

	}
	//아이디 중복 체크 실패시
	public void failID() {
		System.out.println("아이디가 중복되었습니다 다시 입력해주세요");
	}
	//비밀번호입력
	public String inputPassword() {
		String password;
		String secondPassword;
		while(true) {
			System.out.print("비밀번호 입력 >> ");
			password=sc.next();
			//비밀번호 확인유효성
			//2번째 비밀번호 입력
			System.out.println("비밀번호 확인 >>");
			secondPassword=sc.next();
			if(password.equals(secondPassword) ) {//첫번째 비밀번호와 두번째 비밀번호가 같다면
				//비밀번호 입력

				return password;
			}
			System.out.println("다시입력해주세요");
		}
	}
	public void createMember() {
		//회원가입 성공
		System.out.println("회원가입에 성공하셨습니다! 환영합니다!");
	}
	public void failMember() {
		//회원가입 실패
		System.out.println("회원가입에 실패하셨습니다");
	}



	//	1.로그인
	//
	//아이디와 비밀번호 입력
	//성공하면 로그인 성공!
	//실패하면 실패..
	public MemberDTO inputLoginInfo() {
		//아이디입력
		//비밀번호입력
		System.out.print("아이디 입력 >> ");
		String loginId=sc.next();
		System.out.print("비밀번호 입력 >> ");
		String loginPassword=sc.next();
		MemberDTO data=new MemberDTO();
		data.setMemberId(loginId);
		data.setPassword(loginPassword);
		return data;

	}
	//로그인 성공
	public void loginSuccess() {
		//로그인에 성공했습니다! 환영합니다!
		System.out.println("로그인에 성공했습니다! 환영합니다!");
	}
//로그인 실패
	public void loginFail() {
		System.out.println("로그인 정보가 잘못되었습니다");
	}

}
