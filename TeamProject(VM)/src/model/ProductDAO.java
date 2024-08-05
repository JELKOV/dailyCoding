package model;


import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProductDAO {
	private ArrayList<ProductDTO> datas;
	private ArrayList<ProductDTO> cartDatas;

	public ProductDAO() {
		int num=100;
		this.datas=new ArrayList<ProductDTO>();
		this.cartDatas= new ArrayList<ProductDTO>();

		// 초기 상품 데이터 추가
		String url="http://camelmart.godomall.com/";
		Connection conn =Jsoup.connect(url);
		
		try {
			Document doc = conn.get();
			Elements elementsName =doc.select("strong.item_name");
			Elements priceAll = doc.select("strong.item_price");
			
			if (elementsName.size() == priceAll.size()) { // 배열에 길이가 같을때
                for (int i = 0; i < elementsName.size(); i++) {
                    ProductDTO data = new ProductDTO();
                    data.setNum(num++);
                    data.setName(elementsName.get(i).text());
                    String priceString = priceAll.get(i).text().replaceAll("[^0-9]", "");
                    //가격 문자열에서 숫자가 아닌 모든 문자를 제거
//                    System.out.println(priceString);
                    int price = Integer.parseInt(priceString); // int로 변환
                    data.setPrice(price);
                    data.setCnt(40); // 재고 임의 입력
                    datas.add(data);
                }
            } else {
                System.out.println("상품명과 가격의 수가 일치하지 않습니다!");
            }
        } catch (IOException e) {
            System.out.println("연결 중 에러 발생!");
            e.printStackTrace();
        }

//		ProductDTO product1 = new ProductDTO();
//		product1.setNum(101);
//		product1.setName("맥콜");
//		product1.setPrice(20000);
//		product1.setCnt(4);
//		this.datas.add(product1);
//
//		ProductDTO product2 = new ProductDTO();
//		product2.setNum(102);
//		product2.setName("솔의눈");
//		product2.setPrice(10000);
//		product2.setCnt(5);
//		this.datas.add(product2);
//
//		ProductDTO product3 = new ProductDTO();
//		product3.setNum(103);
//		product3.setName("아침햇살");
//		product3.setPrice(40000);
//		product3.setCnt(6);
//		this.datas.add(product3);
//
//		ProductDTO product4 = new ProductDTO();
//		product4.setNum(104);
//		product4.setName("닥터페퍼");
//		product4.setPrice(30000);
//		product4.setCnt(8);
//		this.datas.add(product4);
	}

	public boolean insert(ProductDTO productDTO) { //장바구니 제작
		System.out.println("ProductDAO 장바구니 insert log 시작");
		ProductDTO cartData = new ProductDTO(); // 새로운 정보를 저장할 데이터 공간을 생성
		cartData.setNum(productDTO.getNum()); // pk값
		cartData.setName(productDTO.getName());// 제품명
		cartData.setPrice(productDTO.getPrice()); //토탈가격
		cartData.setCnt(productDTO.getCnt()); // 구매하고싶은 개수
		this.cartDatas.add(cartData); //저장
		System.out.println("ProductDAO 장바구니 insert log 종료");
		return true;
	}


	public boolean update(ProductDTO productDTO) {
		if (productDTO.getCondition().equals("PRODUCT")) { // 상품 조건인지 확인
			// 상품 재고 변화 로직
			System.out.println("PrdouctDAO 상품재고 update log 시작"); // 시작 로그 출력
			boolean flag=false; // 상품 존재 여부 플래그
			for (ProductDTO data : this.datas) { // 모든 상품 데이터를 순회
				if (data.getNum() == productDTO.getNum()) { // 상품 번호 일치 여부 확인
					flag=true;
					data.setCnt(productDTO.getCnt()); // 재고 감소
					System.out.println("PrdouctDAO 상품재고 update log 성공완료"); // 완료 로그 출력
					return true; // 성공 반환
				}
			}
			if(!flag) { 
				System.out.println("PrdouctDAO 상품재고 update log 실패: 상품에 없는상품 오류"); // 상품 없음 로그 출력
			}
		} 
		else if (productDTO.getCondition().equals("CART")) { // 장바구니 조건인지 확인
			// 장바구니 업데이트 로직
			System.out.println("PrdouctDAO 장바구니추가 update log 시작"); // 시작 로그 출력
			boolean flag = false; // 장바구니에 상품 존재 여부 플래
			for (ProductDTO data : this.cartDatas) { // 모든 장바구니 데이터를 순회
				if (data.getNum() == productDTO.getNum()) { // 상품 번호 일치 여부 확인
					flag = true; // 일치하는 상품 발견
					data.setCnt(data.getCnt()+productDTO.getCnt()); // 장바구니 수량 업데이트
					int totalPrice = data.getPrice()+productDTO.getPrice();
					data.setPrice(totalPrice);
					System.out.println("PrdouctDAO 장바구니추가 update log 성공완료"); // 완료 로그 출력
					return true; // 성공 반환
				}
			}
			if(!flag) {
				System.out.println("PrdouctDAO 장바구니추가 update log 실패: 장바구니에 없는상품 오류"); // 상품 없음 로그 출력
			}
		}
		return false;// 조건이 맞지 않을 경우 실패 반환
	}

	public boolean delete(ProductDTO productDTO) { // 장바구니 삭제
		System.out.println("PrdouctDAO 장바구니삭제 delete log 시작");// 삭제 작업 시작 로그 출력
		for (int i = 0; i < cartDatas.size(); i++) { // 장바구니 데이터 리스트를 순회
			if (cartDatas.get(i).getNum() == productDTO.getNum()) { // 현재 장바구니 품목과 담긴 번호가 삭제할 상품품목의 번호와 일치하는지 확인
				cartDatas.remove(i); // 일치하면 해당 장바구니 리스트에서 제거
				System.out.println("PrdouctDAO 장바구니삭제 delete log 성공");// 삭제 성공 로그 출력
				return true; // 삭제 성공 반환
			}
		}
		System.out.println("PrdouctDAO 장바구니삭제 delete log 실패: 없는장바구니"); // 삭제 실패 로그 출력 (일치하는 찾지 못한 경우)
		return false; // 삭제 실패 반환
	}

	public ArrayList<ProductDTO> selectAll(ProductDTO productDTO) { //전체출력
		// 상품 전체 출력
		ArrayList<ProductDTO> datas= new ArrayList<ProductDTO>();
		if (productDTO.getCondition().equals("PRODUCT")) {
			System.out.println("PrdouctDAO 상품전체출력 selectAll log 시작");
			for(ProductDTO data:this.datas) {
				datas.add(data);
			}
		}
		// 장바구니 전체 출력
		else if (productDTO.getCondition().equals("CART")) {
			System.out.println("PrdouctDAO 장바구니전체출력 selectAll log 시작");
			for(ProductDTO data:this.cartDatas) {
				datas.add(data);
			}
		}
		System.out.println("PrdouctDAO selectAll log 종료");
		return datas;
	}

	public ProductDTO selectOne(ProductDTO productDTO) { 
		// 상품 1개 선택
		if (productDTO.getCondition().equals("PRODUCT")) { // 조건이 "상품"인지 확인
			System.out.println("PrdouctDAO 상품한개출력 selectOne log 시작");// 시작 로그 출력
			for (ProductDTO data : this.datas) { // 모든 상품 데이터를 순회
				if (data.getNum() == productDTO.getNum()) { // 현재 데이터의 번호가 찾는 번호와 일치하는지 확인
					System.out.println("PrdouctDAO 상품한개출력 selectOne log 성공"); // 성공 로그 출력
					return data; // 일치하는 데이터 반환
				}
			}
			System.out.println("PrdouctDAO 상품한개출력 selectOne log 실패:데이터없음"); // 실패 로그 출력 (일치하는 데이터를 찾지 못한 경우)
			return null; // null 반환
		} else if (productDTO.getCondition().equals("CART")) { // 조건이 "장바구니"인지 확인
			// 장바구니 1개 선택
			System.out.println("PrdouctDAO 장바구니한개출력 selectOne log 시작"); // 시작 로그 출력
			for (ProductDTO data : this.cartDatas) { // 모든 장바구니 데이터를 순회
				if (data.getNum() == productDTO.getNum()) { // 현재 데이터의 번호가 찾는 번호와 일치하는지 확인
					System.out.println("PrdouctDAO 장바구니한개출력 selectOne log 성공"); // 성공 로그 출력
					return data; // 일치하는 데이터 반환
				}
			}
			System.out.println("PrdouctDAO 장바구니한개출력 selectOne log 실패"); // 실패 로그 출력 (일치하는 데이터를 찾지 못한 경우)
			return null; // null 반환
		}
		return null; // 조건이 맞지 않을 경우 null 반환
	}
}