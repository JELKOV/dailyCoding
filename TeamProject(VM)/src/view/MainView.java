package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.ProductDTO;




public class MainView {
private static Scanner sc; 

public MainView(){
	sc = new Scanner(System.in);
}
	//0.종료
	//	4.상품 목록 출력


	//====상품목록====

	//메뉴번호입력받기 - 유효성
	//만약 0~6번사이가 아니라면
	//다시 입력





	public void printMenuList() {
		//0.종료
		//		4.상품 목록 출력
		System.out.println("0.종료");
		System.out.println("4.상품 목록 출력");
	}

	public int inputMenuNum() {//메뉴번호입력받기
		while(true) {
			try {
				//메뉴입력 받기
				System.out.println("메뉴입력>>");
				int action = sc.nextInt();
				return action;
			}
			catch(InputMismatchException e) {
				System.out.println("다시입력해주세요");
			}
		}
	}


//상품 출력
public void productInfo(ArrayList<ProductDTO> datas) {
	if(datas.size()>0) {
		for(ProductDTO data : datas) {
			if(data.getCnt()<=0) {
				System.out.println(data.getName() + "은(는) 품절입니다.");

			}
			else{
							System.out.println(data.getName() +" | 개수 : "+ data.getCnt() +" | 가격 : "+data.getPrice()+"원");
			}
		}

	}
}


}
