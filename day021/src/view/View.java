package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.ProductDTO;

public class View {
	private static Scanner sc=new Scanner(System.in);
	private final static int MENUNUM=2;
	// 1. static : 객체와 무관하게 == 클래스 변수 == 공유 자원(모든 객체들이 값을 공유)
	// 2. final : 상수화 == 값 변경 x

	public void printMenuList() {
		System.out.println("1. 전체목록출력");
		System.out.println("2. 선택출력");
		System.out.println("0. 종료");
	}
	public void printNoData() { // 함수화(모듈화)
		System.out.println("보여줄 데이터가 없습니다!");
	}
	public void print01(ArrayList<ProductDTO> datas) {
		if(datas.size() <= 0) {
			printNoData();
			return;
		}

		for(ProductDTO data:datas) {
			System.out.println(data);
		}
	}
	public int inputProductNum() {
		int productNum;
		while(true) {
			try {
				System.out.print("상품번호입력 >> ");
				productNum=View.sc.nextInt();
			}
			catch(Exception e) {
				System.err.println("정수로만 입력해주세요!");
				View.sc.nextLine();
				continue;
			}
			break;
		}
		return productNum;
	}
	public void print02(ProductDTO data) {
		if(data == null) {
			printNoData();
			return;
		}
		
		System.out.println("검색된 데이터");
		System.out.println(data);
	}
	public void print00() {
		for(int i=0;i<5;i++) {
			System.out.println(".");
			try {
				Thread.sleep(1000);
				// ☆ 객체화 x --->> 클래스.메서드(); 의 형태
			} catch (InterruptedException e) {
				// e.printStackTrace();
				System.err.println("스레드에서 에러발생!");
			}
		}
		System.out.println("프로그램을 종료합니다!");
	}
	public int inputMenuNum() {
		int menuNum;
		while(true) {
			try {
				System.out.print("메뉴번호입력 >> ");
				menuNum=View.sc.nextInt();
			}
			catch(Exception e) {
				System.err.println("정수로만 입력해주세요!");
				View.sc.nextLine();
				continue;
			}
			if(0<=menuNum && menuNum<=View.MENUNUM) {
				break;
			}
			System.out.println("0~"+View.MENUNUM+" 사이의 정수를 입력해주세요!");
		}
		return menuNum;
	}
}
