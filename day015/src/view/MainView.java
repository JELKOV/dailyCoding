package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.BoardDTO;

abstract class View {
	public static Scanner sc=new Scanner(System.in);
}

public class MainView extends View {
	// 글 전체 출력
	// 글 검색 : 제목
	// 글 검색 : 작성자
	// 글 1개 선택
	public int inputNum() {
		System.out.println("검색할 글의 번호를 입력하세요");
		int num=sc.nextInt();
		return num;
	}
	public String searchWriter() {
		System.out.println("글작성자의 이름을 입력하세요");
		String writer=sc.next();
		return writer;
	}
	public String searchTitle() {
		System.out.println("검색할 제목을 입력하세요");
		String title=sc.next();
		return title;
	}
	public void printBoardData(BoardDTO data) {
		System.out.println("제목 : "+data.getTitle());
		System.out.println("내용 : "+data.getContent());
		System.out.println("조회수 : "+data.getCnt());
		System.out.println("작성자 : "+data.getWriter());
	}
	public void printBoardList(ArrayList<BoardDTO> datas) {
		if(datas.size()<=0) {
			System.out.println("보여줄 데이터 없음!");
			return;
		}

		System.out.println("=== 전체 목록 ===");
		System.out.println("번호 | 제목 | 조회수 | 작성자 | 내용");
		for(BoardDTO data:datas) {
			System.out.println(data.getNum()+" | "+data.getTitle()+" | "+data.getCnt()+" | "+data.getWriter()+" | "+data.getContent());
		}
		System.out.println("===============");
	}
	public void printTrue() {
		System.out.println("성공");
	}
	public void printFalse() {
		System.out.println("실패");
	}
	public void printMenuList() {
		System.out.println("0. 종료");
		System.out.println("1. 글 전체 출력");
		System.out.println("2. 글 검색 : 제목");
		System.out.println("3. 글 검색 : 작성자");
		System.out.println("4. 글 1개 선택");
	}
	public int inputMenuNum() {
		System.out.print("메뉴입력 >> ");
		int num=sc.nextInt();
		return num;
	}
}
