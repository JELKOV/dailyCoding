package view;

import java.util.ArrayList;
import java.util.Scanner;

import service.model.StudentDTO;

public class StudentView {
	static Scanner sc=new Scanner(System.in);
	
	public void print01() {
		System.out.println("=== 메 뉴 ===");
		System.out.println("1. 학생추가");
		System.out.println("2. 전체출력");
		System.out.println("3. 번호검색");
		System.out.println("4. 이름검색");
		System.out.println("5. 평균출력");
		System.out.println("6. 점수변경");
		System.out.println("7. 학생삭제");
		System.out.println("0. 프로그램 종료");
		System.out.println("==========");
	}
	public void print02() {
		System.out.print("추가할 학생의 이름 입력 >> ");
	}
	public void print03() {
		System.out.print("추가할 학생의 성적 입력 >> ");
	}
	public void print04() {
		System.out.println("학생 추가 완료!");
	}
	public void print05(ArrayList<StudentDTO> datas) {
		System.out.println("=== 전체 목록 ===");
		for(StudentDTO data:datas) {// 반복문 왜 쓰는가 ?
			System.out.println(data);
		}
		System.out.println("===============");
	}
	public void print06() {
		System.out.println("출력할 데이터가 없습니다!");
	}
	public void print07() {
		System.out.print("검색할 학생의 번호 입력 >> ");
	}
	public void print08(StudentDTO data) {
		if(data==null) {
			System.out.println("검색할 데이터가 없습니다.");
			//저희가 설계를 했는데 
			//view에서 메서드를 2개를 작성한 상황이었습니다.
			//그래서 controller에서 분기처리를 하였습니다.
			return;
		}
		System.out.println("=== 검색 결과 ===");
		System.out.println(data);
		System.out.println("===============");
	}
	public void print09() {
		System.out.print("삭제할 학생의 번호 입력 >>");
	}
	public void print10() {
		System.out.println("학생 삭제 완료!");
	}
	public void print11() {
		System.out.println("삭제실패하엿습니다");
		System.out.println("관계자에게 문의하세요");
	}
	
	public void print12() {
		System.out.print("검색할 이름을 입력 >>");
	}
	public void print13(ArrayList<StudentDTO> datas) {
		System.out.println("===이름 검색 결과 ===");
		for(StudentDTO data:datas) {
			System.out.println(data);
		}
		System.out.println("===================");
	}
	public void print14() {
		System.out.println("점수를 변경할 학생의 번호 입력>>");
	}
	public void print15() {
		System.out.println("학생의 변경할 점수를 입력>>");
	}
	public void print16() {
		System.out.println("점수를 변경하였습니다.");
	}
	public void print17() {
		System.out.println("점수변경에 실패하였습니다.");
	}
	public void print18(double avg) {
		 System.out.println("총 평균은"+avg+"점 입니다.");
	}
	
	public int inputAction() {
		int action=sc.nextInt();
		return action;
	}
	public String inputName() {
		String name=sc.next();
		return name;
	}
	public int inputScore() {
		int score;
		while(true) {
			score=sc.nextInt();
			if(score<=100) {
				break;
			}
			System.out.println("100 이하의 값을 입력해주세요 !");
		}
		return score;
	}
	public int inputNum(int lastPK) {// 알수 없는건 인자로
		int num;
		while(true) {
			num =sc.nextInt();
			if(100<num && num<lastPK) {
				break;
			}
			System.out.println("제대로 입력해주세요 !");
		}
		return num;
	}
}