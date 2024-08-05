package view;

import java.util.ArrayList;
import java.util.Scanner;

import service.model.BoardDTO;

public class BoardView {
	static Scanner sc=new Scanner(System.in);
	public String searchTitle() {
		System.out.println("검색할 제목을 입력하세요");
		String title=sc.next();
		return title;
	}
	public void checkTrue() {
		System.out.println("게시글을 삭제했습니다.");
	}
	public void checkFalse() {
		System.out.println("게시글을 삭제를 취소했습니다.");
	}
	public boolean deleteData() {
		boolean flag;
		while(true) {
			System.out.println("게시글을 삭제하겠습니까? Y or N");
			String ans = sc.next();
			if(ans.equals("Y")) {
				flag=true;
				break;
			}
			else if(ans.equals("N")) {
				flag=false;
				break;
			}
			else {
				System.out.println("올바른 입력값을 적으세요");
			}
		}
		return flag;
	}

	public String inputTitle() {
		System.out.print("제목 입력 >> ");
		String title=sc.next();
		return title;
	}
	public String inputContent() {
		System.out.print("내용 입력 >> ");
		String content=sc.next();
		return content;
	}
	public void printBoardData(BoardDTO data) {
		// "인자로 넘어오는 data가 null일 수 없다!"는 자세
		//  == C가 잘주겠지~~~
		System.out.println("제목 : "+data.getTitle());
		System.out.println("내용 : "+data.getContent());
		System.out.println("조회수 : "+data.getCnt());
	}
	public int inputNum() {
		System.out.print("글 번호 입력 >> ");
		int num=sc.nextInt();
		return num;
	}
	public void printTrue() {
		System.out.println("성공!");
	}
	public void printFalse() {
		System.out.println("실패...");
		System.out.println("관리자에게 문의해주세요!");
	}
	public BoardDTO boardWrite() {
		System.out.print("글 제목 입력 >> ");
		String title=sc.next();
		System.out.print("글 내용 입력 >> ");
		String content=sc.next();

		BoardDTO data=new BoardDTO();
		data.setTitle(title);
		data.setContent(content);
		System.out.println("   로그 : VIEW boardWrite() "+data);
		return data;
	}
	public void printBoardList(ArrayList<BoardDTO> datas) {
		if(datas.size()<=0) {
			System.out.println("보여줄 데이터 없음!");
			return;
		}

		System.out.println("=== 전체 목록 ===");
		System.out.println("번호 | 제목 | 조회수");
		for(BoardDTO data:datas) {
			System.out.println(data.getNum()+" | "+data.getTitle()+" | "+data.getCnt());
		}
		System.out.println("===============");
	}
	public void printMenuList() {
		System.out.println("=== 메뉴 목록 ===");
		System.out.println("1. 글 작성");
		System.out.println("2. 전체출력");
		System.out.println("3. 1개검색");
		System.out.println("4. 내용변경");
		System.out.println("5. 제목변경");
		System.out.println("6. 글 삭제");
		System.out.println("7. 제목으로 검색");
		System.out.println("0. 프로그램 종료");
		System.out.println("===============");
	}
	public int inputMenuNum() {
		System.out.print("메뉴입력 >> ");
		int num=sc.nextInt();
		return num;
	}
	public void exit() {
		System.out.println("프로그램을 종료합니다...");
	}
}