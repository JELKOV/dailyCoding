package ctrl;

import java.util.ArrayList;

import model.Crawling;
import model.MemberDAO;
import model.MemberDTO;
import model.ProductDAO;
import model.ProductDTO;
import view.View;

public class Ctrl {
	private View view;
	private MemberDAO memberDAO;
	private ProductDAO productDAO;
	// 일회성 데이터
	private String user; // 로그인한 사람의 정보
	private MemberDTO userData;// 로그인한 사람의 전체정보
	private ArrayList<ProductDTO> cartList; // 로그인한 사람이 이용하는 장바구니 정보
	public Ctrl() {
		view=new View();
		memberDAO=new MemberDAO();
		productDAO=new ProductDAO();
		user=null;
		cartList=null;
	}
	// 모듈화(함수화,컴포넌트화)
	public boolean logout() {
		if(user==null) {
			view.func09();
			return false;
		}
		user=null;
		cartList=null;
		view.func08();
		return true;
	}
	/*강사님 코드 배열에 해당 상품이 존재하는지 확인하는 코드
	private int cartIndex(ProductDTO data) { // 인덱스로 존재하는지 확인하는 함수
		int index=-1;
		for(int i=0;i<cartList.size();i++) {
			if(cartList.get(i).getNum() == data.getNum()) {
				return i;
			}
		}
		return index;
	}
	*/
	private boolean isProductTableEmpty() {
		ProductDTO productDTO=new ProductDTO();
		productDTO.setCondition("ISEMPTY");
		productDTO=productDAO.selectOne(productDTO);
		if(productDTO.getTotal() <= 0) {
			return true;
		}
		return false;
	}
	private void makeSample() {
		ArrayList<ProductDTO> datas=Crawling.makeSample();
		for(ProductDTO data:datas) {
			boolean flag=productDAO.insert(data);
			if(!flag) {
				view.func09();
				return;
			}
		}
		view.func08();
	}

	private void addToCart(ProductDTO productToCart, int myCnt, int invenProduct) {
		boolean found = false;
		if(cartList.size() == 0) { // 첫 상품
			if(myCnt > invenProduct) {
				System.out.println("재고 초과했습니다. " + invenProduct + "개, 재고 전부 드려요");
				myCnt = invenProduct;
			}
			productToCart.setCnt(myCnt); // 컨트롤러가 책임지고 들고다녀야 하는 것은 가벼울수록 좋으니깐
			// 네임이나 가격은 넣지 않는다.
			cartList.add(productToCart);
			System.out.println(cartList);
			view.func08(); // 장바구니에 추가 완료
		} else {
			for(int i = 0; i < cartList.size(); i++) { //이 for문때문에 한개일때를 따로 빼놧습니다. 0<0 이 먼가 불능 값인것 같습니다.
				// 카트에 있는 상품 번호와 구매하려는 상품의 번호가 같을 때
				if(cartList.get(i).getNum() == invenProduct) {
					if(cartList.get(i).getNum()+myCnt >= invenProduct) {
						System.out.println("재고 초과했습니다. " + invenProduct + "개, 재고 전부 드려요");
						cartList.get(i).setCnt(invenProduct);
						System.out.println(cartList); // 장바구니를 한번 보여줌
						found = true;
						break;// 동일한 상품을 찾았으므로 루프 종료
					}
					else if(cartList.get(i).getNum()+myCnt < invenProduct) {
						cartList.get(i).setCnt(cartList.get(i).getCnt() + myCnt);
						System.out.println(cartList); // 장바구니를 한번 보여줌
						found = true;
						break;// 동일한 상품을 찾았으므로 루프 종료
					}
				}
			}
			if(!found) { // 중복 상품 없을 시
				if(myCnt > invenProduct) {
					System.out.println("재고 초과했습니다. " + invenProduct + "개, 재고 전부 드려요");
					myCnt = invenProduct;
				}
				productToCart.setCnt(myCnt);
				cartList.add(productToCart);
				System.out.println(cartList); // 장바구니를 한번 보여줌
				view.func08(); // 장바구니에 추가 완료
			} else {
				view.func08();
			}
		}
	}


	public void start() {
		//샘플데이터가 없다라는것을 무엇으로 정의할것인가 
		//컨디션값이 SAMPLE인것들이 sampleDatas.length 까지 있다면
		if(isProductTableEmpty()) {
			makeSample();
		}	

		while(true) {
			if(user==null) {
				System.out.println("로그오프상태");
				view.func01();
			}
			else {
				view.func02();
				if(user.equals("ADMIN")) {
					view.func03();
				}
			}

			int num=view.func04();
			if(num==0) {
				view.func08();
				break;
			}
			else if(num==1) { //회원가입
				// 인증(인가,허가,보안) 로직
				if(user!=null) {
					view.func09();
					continue;
				}
				//회원가입 로직
				//사용자가 회원가입하고 싶은 id값을 입력
				String mid;
				while(true) { //컨디션을 추가해서  해야 하
					MemberDTO memberDTO = new MemberDTO();
					mid = view.func05();
					memberDTO.setMid(mid);
					memberDTO.setCondition("IDCHECK");
					memberDTO = memberDAO.selectOne(memberDTO);
					if(memberDTO == null) {
						break;
					}
					view.func09();
				}
				String password = view.func06();
				String name = view.func12();
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setMid(mid);
				memberDTO.setPassword(password);
				memberDTO.setName(name);
				boolean flag = memberDAO.insert(memberDTO);
				if(!flag) {//가입실패
					view.func09();
				}
				else {//가입성공
					view.func08();
				}

			}
			else if(num==2) { //로그인
				if(user!=null) {
					view.func09();
					continue;
				}

				String mid=view.func05();
				String password=view.func06();

				MemberDTO memberDTO=new MemberDTO();
				memberDTO.setMid(mid);
				memberDTO.setPassword(password);
				memberDTO.setCondition("LOGIN");

				userData=memberDAO.selectOne(memberDTO);

				if(userData==null) {
					view.func09();
					continue;
				}
				user=userData.getMid();
				cartList=new ArrayList<ProductDTO>();
				view.func08();
			}
			else if(num==3) { //로그아웃
				if(!logout()) {
					continue;
				}
			}
			else if(num==4) { //비밀번호변경
				if(user==null) {
					view.func09();
					continue;
				}
				String password=view.func06();
				MemberDTO newPasswordData=new MemberDTO();
				newPasswordData.setMid(userData.getMid());
				newPasswordData.setPassword(password);

				/////비밀번호 변경 로직
				boolean flag = memberDAO.update(newPasswordData);
				if(!flag) {//변경 실패
					view.func09();
				}
				else {//변경 성공
					view.func08();
					logout();
				}

				if(!logout()) {
					continue;
				}
			}
			else if(num==5) { //회원탈퇴
				if(user==null) {
					view.func09();
					continue;
				}
				MemberDTO delUserData=new MemberDTO();
				delUserData.setMid(userData.getMid());

				/////회원탈퇴 로직
				boolean flag = memberDAO.delete(delUserData);
				if(!flag) {//탈퇴 실패
					view.func09();
				}
				else {//탈퇴 성공
					view.func08();
					logout();// 탈퇴를 했는데 로그인을 할수가 있는가 ???
				}

				if(!logout()) {
					continue;
				}
			}
			else if(num==6) { //관리자모드
				if( user==null || !( user.equals("ADMIN"))) {
					view.func09();
					continue;
				}
				String productName= view.func11();
				int productPrice= view.func13();
				int productCnt=view.func14();

				ProductDTO productDTO=new ProductDTO();
				productDTO.setName(productName);
				productDTO.setPrice(productPrice);
				productDTO.setCnt(productCnt);

				/////상품추가 로직
				boolean flag= productDAO.insert(productDTO);
				if(!flag) {//상품추가 실패
					view.func09();
				}
				else {//상품추가성공
					view.func08();
				}
			}
			else if(num==7) {///상품 목록 출력 로직
				// 사용자가 목록 출력을 눌렀을때  216번라인에 기입을 합니다.
				// A는 PRODUCTDAO가보여줘야한다.
				//SAll() 를 호출해야함 DTO를 호출해야함
				// 사용자에게 PRODUCT DB(=>A)를 보여줘야 한다.
				ProductDTO productDTO=new ProductDTO();
				productDTO.setCondition("DEFAULT");
				ArrayList<ProductDTO> datas=productDAO.selectAll(productDTO);
				view.func07(datas);		
			}
			else if(num==8) {//상품 이름으로 검색 로직
				String hasSearchName = view.func11();
				ProductDTO productDTO=new ProductDTO();// 담아줄 DTO 생성
				productDTO.setCondition("SEARCHNAME");//SA에 컨디션이 있어서 컨디션 작성
				productDTO.setName(hasSearchName);// 이름 저장해서 보내줌
				ArrayList<ProductDTO> datas=productDAO.selectAll(productDTO);// SA 요청
				System.out.println("check"+datas);
				if(datas!=null) {
					view.func07(datas);
				}
				else if(datas==null){
					view.func08();
				}		
			}
			else if(num==9) {//상품 가격순으로 정렬 출력
				ProductDTO productDTO=new ProductDTO();
				productDTO.setCondition("ORDERBYPRICE");
				ArrayList<ProductDTO> datas=productDAO.selectAll(productDTO);// SA 요청
				view.func07(datas);
			}
			/* 강사님 코드
			else if(num==10) {
				if(user==null) {
					view.func09();
					continue;
				}

				int productNum=view.func10();
				ProductDTO productDTO=new ProductDTO();
				productDTO.setCondition("ONE");
				productDTO.setNum(productNum);
				productDTO=productDAO.selectOne(productDTO);
				if(productDTO==null || productDTO.getCnt()<=0) {
					view.func09();
					continue;
				}

				int cnt=view.buy(productDTO);
				ProductDTO cartData=new ProductDTO();
				cartData.setNum(productDTO.getNum());
				cartData.setCnt(cnt);
				
				int index=cartIndex(cartData);
				if( index >= 0 ) {
					cartList.get(index).setCnt( cartList.get(index).getCnt() + cnt );
				}
				else {
					cartList.add(cartData);
				}
				view.func08();
			}
			*/
			else if(num==10) {//상품을 장바구니에 추가 로직
				if(user==null) {
					view.func09();
					continue;
				}
				//1. KEY값으로 상품을 정해서 DB에 SA 요청을 한다.
				int productNum = view.func10(); // 장바구니에 추가할 상품 번호 입력 받기
				ProductDTO productDTO = new ProductDTO();
				productDTO.setNum(productNum);
				productDTO.setCondition("SEARCHNUM");
				ProductDTO productToCart = productDAO.selectOne(productDTO);
				int invenProduct = productToCart.getCnt();//DB에 저장되어 있는 상품 재고
				// SO의 번호가 없는 경우
				if(productToCart == null || invenProduct<=0) {// 상품이 존재하지 않거나// 재고가 없을경우
					System.out.println("상품이 존재하지 않거나 재고가 없습니다.");
					view.func09(); 
				} 
				// SO의 번호가 있는 경우
				else if(productToCart != null && invenProduct>=0) {// 상품이 존재하면서 재고가 있는 경우
					int myCnt = view.func14(); // 원하는 개수
					addToCart(productToCart, myCnt , invenProduct);
				}
			}
			/*강사님코드
			//여러사람이 구매할수 있기 때문에, selectOne을 하고 
		    //update를 해야한다.
			//실무 출고까지 2주소요됩니다.
		    //상품이 창고DB에서 데이터를 얘네도 불러와야아는 상황
			else if(num==11) {
				if(user==null) {
					view.func09();
					continue;
				}

				view.func07(cartList);
				boolean flag=false;
				for(ProductDTO dto:cartList) {
					dto.setCondition("ONE");
					ProductDTO tmp=productDAO.selectOne(dto);
					if(tmp.getCnt()<dto.getCnt()) {
						flag=false;
						break;
					}
					flag=productDAO.update(dto);
					if(!flag) {
						break;
					}
				}
				if(!flag) {
					view.func09();
					continue;
				}
				cartList.clear();
				view.func08();
			}
			*/
	
			else if(num==11) {//장바구니 목록 구매 로직
				if(user==null) {
					view.func09();
					continue;
				}
				//1.장바구니의 리스트를 update에 보낸다.
				//2.장바구니가 없는경우
				if(cartList.size()==0) {
					System.out.println("장바구니에 담긴 상품이 없습니다");
				}
				else if(cartList.size()>0) {
					int totalPrice =0;
					//3.cnt를 비교해서 빼준다. // DAO에서 할일
					for(ProductDTO cartData:cartList) {
						totalPrice += cartData.getPrice()*cartData.getCnt();
						boolean flag = productDAO.update(cartData);
						if(!flag) {
							view.func09();
							break;
						}
						else if(flag) {
							//3.장바구니를 비어준다.
							cartList=null;
							view.func08();
						}
					}
					//4.구매금액을 알려준다.
					view.showTotalPrice(totalPrice);
				}
			}
			else if(num==12) {
				if( user==null || !( user.equals("ADMIN") ) ) {
					view.func09();
					continue;
				}
				ProductDTO productDTO=new ProductDTO();
				int numProduct =view.func10();
				productDTO.setNum(numProduct);

				//상품삭제 로직
				boolean flag= productDAO.delete(productDTO);
				if(!flag) {//상품삭제실패
					view.func09();
				}
				else {//상품삭제성공
					view.func08();
				}
			}
		}
	}
}
