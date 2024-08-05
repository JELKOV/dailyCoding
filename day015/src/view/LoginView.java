package view;

import java.util.ArrayList;

import model.BoardDTO;

public class LoginView extends View {
	// 로그아웃
	// 글 작성
	// 글 삭제
	// 글 내용 변경
	// 회원탈퇴
	// 글 작성
	
	public void printWrongpass() {
		System.out.println("비밀번호가 틀렸습니다");
	}
	public boolean checkDelPas(String password) {
		System.out.println("진짜 탈퇴하시려면 비밀번호를 한번 더 기입해주세요");
		String typePassword = sc.next();
		boolean flag =false;
		if(typePassword.equals(password)) {
			flag = true;
			return flag;
		}
		else {
			return flag;
		}
	}
	public String FixedContents(){
		System.out.println("수정내용입력");
		String content=sc.next();
		return content;
	}
	public void printValidFalse() {
		System.out.println("본인인 쓴글의 번호가 아닙니다.");
	}
	public boolean validCheckDel(ArrayList<BoardDTO> datas, int num) {
		boolean flag;
		while(true) {
			for(int i=0; i<datas.size(); i++) {
				if(datas.get(i).getNum()==num) {
					flag=true;
					return flag;
				}
			}
			return false;
		}
		
	}

	public int inputNum() {
		System.out.println("선택할 글의 번호를 입력하세요");
		int num=sc.nextInt();
		return num;
	}
	public BoardDTO inputBoardData(){
		System.out.println("제목입력");
		String title=sc.next();
		System.out.println("내용입력");
		String content=sc.next();

		BoardDTO data=new BoardDTO();
		data.setTitle(title);
		data.setContent(content);
		return data;
	}

	public void printMenuList() {
		System.out.println("7. 로그아웃");
		System.out.println("8. 글 작성");
		System.out.println("9. 글 삭제");
		System.out.println("10. 글 내용 변경");
		System.out.println("11. 회원탈퇴");
	}
}
