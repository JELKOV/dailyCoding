package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.ProductDTO;

public class LoginView {
	private static Scanner sc; 

	public LoginView(){
		sc = new Scanner(System.in);
	}


	public void printMenuList() {
		//	3.로그아웃
		//	5.장바구니에 상품담기 -- 찜하기
		//	6.장바구니에 담긴 상품 목록 출력
		//	7.장바구니에 담긴 상품 목록 구매
		//	8.장바구니에서 상품 빼기
		System.out.println("3.로그아웃");
		System.out.println("5.장바구니에 상품담기");
		System.out.println("6.장바구니 상품 목록 출력");
		System.out.println("7.장바구니 상품 목록 구매");
		System.out.println("8.장바구에서 상품 빼기");
		System.out.println("10.상품 메모장에 출력");
	}

	//장바구니에 상품 담기, 장바구니 번호입력받기
	public ProductDTO inputProductNum(ArrayList<ProductDTO> datas) {
		while(true) {
			cartInfo(datas);
			//입력받기
			int cartNum=0;
			try {
			System.out.println("장바구니의 상품번호를 입력하세요>>");
			cartNum = sc.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("번호를 입력해주세요");
			}
			if(0<cartNum && cartNum<=datas.size() && datas.get(cartNum-1).getCnt() > 0 ) {//0보다크고 데이터사이즈보다 작거나 같을 때 리턴

				return datas.get(cartNum-1);
			}
			System.out.println("다른 상품을 선택해주세요.");
		}
	}


	//무러바ㅑ지
	//장바구니에 담을 상품 개수 입력
	public int addCart(int num) {
		while(true) {
			//몇개 담을지
			int cntNum=0;
			try {
			System.out.println("담고싶은 개수를 입력하세요>>");
			cntNum = sc.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("개수를 입력해 주세요");
			}
			if(0<cntNum && cntNum<=num) {//0~상품의 남은 재고만큼이라면
				return cntNum;
			}
			System.out.println("다시 입력해주세요");
		}
	}



	//장바구니출력
	public void cartInfo(ArrayList<ProductDTO> datas) {
		if(datas.size()>0) {
			for(int i=0;i<datas.size();i++) {
				if(datas.get(i).getCnt()<=0) {
					System.out.println((i+1)+"번 "+datas.get(i).getName() + "은(는) 품절입니다.");

				}
				else{
					System.out.println((i+1)+"번 | "+datas.get(i).getName() +" | 개수 :"+ datas.get(i).getCnt() +" | 가격 : "+ datas.get(i).getPrice()+"원");
				}
			}

		}
	}
	//장바구니 보여줄때
	//===장바구니리스트===


	   //장바구니 구매
	   public ArrayList<ProductDTO> buyCart(ArrayList<ProductDTO> productList, ArrayList<ProductDTO> whishList) {
	      ArrayList<ProductDTO> datas = new ArrayList<ProductDTO>(); 
	      ProductDTO hash = new ProductDTO();
	      int total=0;
	      for(ProductDTO data:productList) {//상품

	         for(int i=0;i<whishList.size();i++){//장바구니

	            if(data.getNum() == whishList.get(i).getNum()){//상품번호와 장바구니번호가 같으면
	               int cnt = data.getCnt()-whishList.get(i).getCnt(); //상품재고 - 장바구니구매개수
	               if(cnt>=0) { 
	                  hash.setNum(data.getNum());
	                  hash.setName(data.getName());
	                  hash.setPrice(data.getPrice());
	                  hash.setCnt(cnt);
	                  datas.add(hash);
	                  total += whishList.get(i).getPrice();
	               }
	               else {
	                  hash.setNum(data.getNum());
	                  hash.setName(data.getName());
	                  hash.setPrice(data.getPrice());
	                  hash.setCnt(0);
	                  datas.add(hash);
	                  total += data.getCnt()*data.getPrice();
	               }

	            }

	         }

	      }


	      totalCost(total);
	      return datas;
	   }

	//구매된 전체 금액 출력
	public void totalCost(int total) {
		System.out.println("구매된 전체금액은"+total+"입니다");
	}
	//장바구니에 담기 성공
	public void successCart() {
		//장바구니에 담겼습니다
		System.out.println("장바구니에 담겼습니다.");
	}
	//장바구니에 담기 실패
	public void failCart() {
		System.out.println("장바구니에 상품을 담는데 실패 하셨습니다.");
	}
	//구매 성공했을 때
	public void successBuy() {
		//구매 완료
		System.out.println("구매를 성공적으로 마쳤습니다.");
	}
	//구매 실패했을 때
	public void failBuy() {
		System.out.println("구매에 실패하였습니다.");
	}
	//빼기 성공했을 때
	public void removeCart() {
		//빼기 성공!
		System.out.println("장바구니를 성공적으로 비웠습니다.");
	}
	//장바구니 비우기 실패했을때
	public void removeFail() {
		System.out.println("삭제되지 못한 장바구니가 있습니다 이후 로그인시 장바구니가 남아있을 수 있습니다");
	}
	//출력성공
	public void printSuccess() {
		System.out.println("++++++++++++++++++++프린트성공++++++++++++++++++++==");
	}

}
