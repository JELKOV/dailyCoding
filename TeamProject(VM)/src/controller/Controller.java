package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.MemberDAO;
import model.MemberDTO;
import model.ProductDAO;
import model.ProductDTO;
import view.LoginView;
import view.LogoutView;
import view.MainView;

public class Controller {
	private ProductDAO productDAO;
	private MemberDAO memberDAO;
	private MainView mainView;
	private LoginView loginView;
	private LogoutView logoutView;
	private MemberDTO user;
	private String condition_Login;
	private String condition_CheckId;
	private String condition_Product;
	private String condition_Cart;	

	public Controller() {
		this.productDAO = new ProductDAO();
		this.memberDAO = new MemberDAO();
		this.mainView = new MainView();
		this.loginView = new LoginView();
		this.logoutView = new LogoutView();
		this.user = null;
		this.condition_Login = "LOGIN";
		this.condition_CheckId = "CHECKID";
		this.condition_Product = "PRODUCT";
		this.condition_Cart = "CART";	
	}

	public void start() {

		while(true) {
			this.mainView.printMenuList();//this.mainView.전체 사용자가 볼수있는 메뉴();//메뉴 0, 4
			if(this.user != null) {
				this.loginView.printMenuList();//this.loginView.로그인한 사용자가 볼수있는 메뉴();//메뉴 3, 5, 6, 7, 8
			}
			else {
				this.logoutView.printMenuList();//this.logoutView.로그아웃한 사용자가 볼수있는 메뉴();//메뉴 1, 2
			}

			
			int action = this.mainView.inputMenuNum(); //this.mainView.사용자가 메뉴를 입력하도록 함();

			
			if(action == 0) {//0. 종료
				break;
			}//0. 종료 끝
			//1. 로그인 시작
			else if(action == 1) {
				if(this.user != null) {
					continue;
				}
				MemberDTO member = this.logoutView.inputLoginInfo();//this.logoutView.사용자가 ID를 입력할 수 있도록 안내(); 사용자가 password를 입력할 수 있도록 안내();
				//String password = this.logoutView.

				MemberDTO data = new MemberDTO(); // 로그인 정보 저장 공간
				data.setMemberId(member.getMemberId());//로그인 저장 공간에 입력된 아이디를 추가
				data.setPassword(member.getPassword());//로그인 저장 공간에 입력된 비밀번호를 추가
				data.setCondition(this.condition_Login); //selectOne에 따라 바뀔 수 있음

				MemberDTO user = this.memberDAO.selectOne(data);//추가된 사용자DAO를 넘김

				if(user != null) { //로그인이 되었다면
					this.logoutView.loginSuccess();//this.logoutView.로그인 되었습니다();
					this.user = user;
					continue;
				}

				//로그인이 안되면 if문을 통과하지 못하여 아래 내용 출력
				this.logoutView.loginFail(); //this.logoutView.로그인 정보가 잘못되었습니다();	


			}//1. 로그인 끝
			//2. 회원가입 시작
			else if(action == 2) {
				if(this.user != null) {
					continue;
				}

				MemberDTO idData;//회원가입 ID 정보 저장공간
				while(true) { //ID 중복 체크
					String memberid = this.logoutView.inputMemberId();//logoutView.사용자가 ID를 입력할 수 있도록 안내();

					idData = new MemberDTO();//회원가입 ID 정보 저장공간
					idData.setMemberId(memberid);//새로운 사용자DAO에 입력된 아이디를 추가
					idData.setCondition(this.condition_CheckId); //selectOne에 따라 바뀔 수 있음

					MemberDTO isId = this.memberDAO.selectOne(idData);
					if(isId == null) {
						break;
					}
					this.logoutView.failID();
				}

				String password = this.logoutView.inputPassword();//this.logoutView.사용자가 패스워드를 입력할 수 있도록 안내(); // view에서 중복체크

				MemberDTO data = new MemberDTO(); //회원가입 정보 저장공간
				data.setMemberId(idData.getMemberId()); // 중복 체크 완료된 ID입력
				data.setPassword(password); // 중복체크 완료된 PW입력

				boolean isJoin =  this.memberDAO.insert(data); //회원가입이 되었는지 T/F로 반환받기

				if(isJoin == true) { //회원가입이 되었는지 확인을 위함
					this.logoutView.createMember();//this.logoutView.회원가입이 완료되었습니다();
				}
				else {
					this.logoutView.failMember();//this.loginView.회원가입이 실패하였습니다 \n 관리자에게 문의해주시기 바랍니다();	
				}
			}//2. 회원가입 끝
			//3. 로그아웃 시작
			else if(action == 3) {
				if(this.user == null) {
					continue;
				}

				ArrayList<ProductDTO> wishList = isCart(); // 장바구니를 새로운 배열에 등록	
				boolean flag = false;
				for(int i=0; i < wishList.size(); i++) { // 배열개수만큼 삭제
					wishList.get(i).setCondition("CART");
					flag = this.productDAO.delete(wishList.get(i));
				}

				if(!flag) {
					this.loginView.removeFail(); //this.logoutView.삭제되지 못한 장바구니가 있습니다 \n 이후 로그인시 장바구니가 남아있을 수 있습니다();
				}

				this.user = null; //다른 이상이 없다면 로그아웃

			}//3. 로그아웃 끝
			//4. 상품 목록 출력 시작
			else if(action == 4) {
				
				ArrayList<ProductDTO> productList = isProduct();
				this.mainView.productInfo(productList); //this.mainView.상품 전체 출력(productList);

			}//4. 상품 목록 출력 끝
			//5. 장바구니에 상품담기 시작
			else if(action == 5) {
				if(this.user == null) {
					continue;
				}

				ArrayList<ProductDTO> productList = isProduct();//상품 목록 전체를 받아와서

				ProductDTO wish = this.loginView.inputProductNum(productList);//this.loginView.상품을 선택해주세요.(productList);//사용자가 원하는 데이터를 불러오게 해준다.
				int cnt = this.loginView.addCart(wish.getCnt());//this.loginView.장바구니에 담을 개수를 입력해주세요(wishOne.getCnt());//내가 선택한 상품의 개수가 넘으면 안되니 개수를 넘겨준다.
				int sum = cnt * wish.getPrice(); //해당 상품 전체 금액 적용

				ProductDTO wishOne = new ProductDTO();
				wishOne.setNum(wish.getNum());
				wishOne.setName(wish.getName());
				wishOne.setCnt(cnt);//받은 개수를 wishOne에 저장해주고
				wishOne.setPrice(sum);//받아온 개수를 계산하여 저장
				wishOne.setCondition(this.condition_Cart);

				boolean flag = this.productDAO.update(wishOne); //장바구니에 상품이 있다면 개수 증가

				if(!flag) {
					flag = this.productDAO.insert(wishOne);
				}

				if(flag) { // update OR insert가 완료 되면 저장	
					this.loginView.successCart();//this.loginView.장바구니에 등록되었습니다.
				}
				else {
					//이건 좀 만들었으면 하네요...
					this.loginView.failCart();//this.loginView.장바구니에 상품을 담는데 실패하였습니다 \n 관리자에게 문의해주세요();
				}

			}//5. 장바구니에 상품담기 끝
			//6. 장바구니에 담긴 상품 목록 출력 시작
			else if(action == 6) {
				if(this.user == null) {
					continue;
				}
				
				ArrayList<ProductDTO> wishList = isCart();
				
				this.loginView.cartInfo(wishList);//this.loginView.상품 전체 출력(wishList);

			}//6. 장바구니에 담긴 상품 목록 끝
			//7. 장바구니에 담긴 상품 구매 시작
			else if(action == 7) {
				if(this.user == null) {
					continue;
				}
				
				ArrayList<ProductDTO> wishList = isCart();
				if(wishList.size() <= 0) {
					continue;
				}

				ProductDTO productData = new ProductDTO();
				productData.setCondition(this.condition_Product);//selectALL에 따라 달라질 수 있음
				ArrayList<ProductDTO> productList = this.productDAO.selectAll(productData); //상품 배열 받아오기
				
				ArrayList<ProductDTO> hashList = this.loginView.buyCart(productList, wishList);//this.loginView.비교된 값을 전체를 보내줘(wishList,produntList);
				for(ProductDTO data: hashList) {
					data.setCondition(this.condition_Product);
					boolean productflag = this.productDAO.update(data);
					if(!productflag) {
						this.loginView.failBuy();//this.loginView.구매에 실패하였습니다. 관리자에게 문의해주세요();
					}

					boolean wishflag = this.productDAO.delete(data);                        
					if(!wishflag) {
						this.loginView.failCart(); //this.loginView.장바구니 정리가 안되었습니다. 관리자에게 문의해주세요();
					}
				}
		
			}//7. 장바구니에 담긴 상품 구매 끝
			//8. 장바구니에서 상품 빼기 시작
			else if(action == 8) {
				if(this.user == null) {
					continue;
				}
				
				ArrayList<ProductDTO> datas = isCart(); // isCart()에서 데이터 받아옴
				if(datas.size() <= 0) {
					continue;
				}
				
				//내용 변경이 필요합니다.
				ProductDTO data = this.loginView.inputProductNum(datas); //loginView.장바구니 번호 입력해줘(datas);

				boolean flag = this.productDAO.delete(data);

				if(!flag) {
					this.loginView.removeFail(); //this.loginView.장바구니 상품제거에 실패하였습니다.
				}
				else {
					this.loginView.removeCart();//this.loginView.상품 제거 완료();
				}


			}
			else if(action==10) {
				if(this.user == null) {
					continue;
				}
				System.out.println("상품전체데이터를 텍스트에 저장합니다.");
				String filePath="C:\\AHN-WorkSpace\\day020\\src\\class01\\";
				String fileName="text.txt";
				// 확장자를 반드시 함께 작성
				ArrayList<ProductDTO> productList = isProduct();
				this.mainView.productInfo(productList); //this.mainView.상품 전체 출력(productList);
				
				FileWriter fileWriter;
				try {
					fileWriter = new FileWriter(filePath+fileName);
		
					BufferedWriter writer=new BufferedWriter(fileWriter);
					for(ProductDTO product:productList) {
						writer.write(product.toString());
						writer.newLine();
					}
					System.out.println("10 상품 메모장 출력");
					writer.close();
					this.loginView.printSuccess();
				} catch (IOException e) {
					System.out.println("파일 입출력 에러가 발생했습니다!");
				}		
				
			}
			//8. 장바구니에서 상품 빼기 끝
			else { //잘못된 번호를 입력했을 때
				//넘김
			}
		}

	}
	
	public ArrayList<ProductDTO> isCart() {
		ProductDTO condition = new ProductDTO();
		condition.setCondition(this.condition_Cart);
		ArrayList<ProductDTO> datas = this.productDAO.selectAll(condition);
		return datas;
	}
	
	public ArrayList<ProductDTO> isProduct() {
		ProductDTO condition = new ProductDTO();
		condition.setCondition(this.condition_Product);
		ArrayList<ProductDTO> datas = this.productDAO.selectAll(condition);
		return datas;
	}
}
