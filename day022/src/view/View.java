package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.ProductDTO;

public class View {
	public static Scanner sc=new Scanner(System.in);
	public void func01() {
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("7. 상품 목록 출력");
		System.out.println("8. 상품 이름으로 검색");
		System.out.println("9. 상품 가격순으로 정렬 출력");
		System.out.println("0. 프로그램 종료");
	}
	public void func02() {
		System.out.println("3. 로그아웃");
		System.out.println("4. 비밀번호 변경");
		System.out.println("5. 회원탈퇴");
		System.out.println("10. 상품을 장바구니에 추가");
		System.out.println("11. 장바구니 목록 구매");
	}
	//관리자 모드
	public void func03() {
		System.out.println("6. 상품추가"); //관리자
		System.out.println("12. 상품삭제"); // 관리자
	}
	public int func04() {
		System.out.print("메뉴번호입력 >> ");
		int num=sc.nextInt();
		return num;
	}
	public String func05() {
		System.out.print("회원아이디입력 >> ");
		String id=sc.next();
		return id;
	}
	public String func06() {
		System.out.print("회원비밀번호입력 >> ");
		String password=sc.next();
		return password;
	}
	public void func07(ArrayList<ProductDTO> datas) {
		for(ProductDTO data:datas) {
			if(data.getCnt()<=0) {
				System.out.println("품절상품");
				continue;
			}
			System.out.println(data);
		}
	}
	public void func08() {
		System.out.println("성공!");
	}
	public void func09() {
		System.out.println("실패...");
	}
	public int func10() {
		System.out.println("상품번호입력 >> ");
		int num=sc.nextInt();
		return num;
	}
	public String func11() {
		System.out.println("상품이름입력 >> ");
		String name=sc.next();
		return name;
	}
	public String func12() {
		System.out.println("회원이름입력 >> ");
		String name=sc.next();
		return name;
	}
	public int func13() {
		System.out.println("상품가격입력 >> ");
		int num=sc.nextInt();
		return num;
	}
	public int func14() {
		System.out.println("재고수량입력 >> ");
		int num=sc.nextInt();
		return num;
	}
	public void showTotalPrice(int totalPrice) {
        System.out.println("총 구매 금액: " + totalPrice + "원");
    }
}
