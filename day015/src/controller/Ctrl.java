package controller;

import java.util.ArrayList;

import model.BoardDAO;
import model.BoardDTO;
import model.MemberDAO;
import model.MemberDTO;
import view.LoginView;
import view.LogoutView;
import view.MainView;

// 로그아웃
public class Ctrl {
	private BoardDAO boardDAO; //v와M멤버변수
	private MemberDAO memberDAO;
	private MainView mainView;
	private LoginView loginView;
	private LogoutView logoutView;
	private int PK;
	private MemberDTO user;// 현재 로그인 상태인지 아닌지 판단하는 변수
	public Ctrl() {
		this.boardDAO=new BoardDAO();//생성자
		this.memberDAO=new MemberDAO();
		this.mainView=new MainView();
		this.loginView=new LoginView();
		this.logoutView=new LogoutView();
		this.PK=1001;
		this.user=null;
	}

	public void start() {
		while(true) {
			mainView.printMenuList();
			if(user==null) { //로그아웃 상태라면,
				logoutView.printMenuList();
			}
			else{
				loginView.printMenuList();
			}
			int menu=mainView.inputMenuNum();

			if(menu==0) {//"0. 종료"
				break;
			}
			else if(menu==1) {//"1. 글 전체 출력"
				BoardDTO boardDTO=new BoardDTO();// 
				boardDTO.setcondition("ALL");
				mainView.printBoardList(boardDAO.selectAll(boardDTO));					
			}
			else if(menu==2) {//"2. 글 검색 : 제목"
				//				String title=mainview.제목입력 받기
				String title=mainView.searchTitle();
				BoardDTO boardDTO=new BoardDTO();
				boardDTO.setTitle(title);
				boardDTO.setcondition("SEARCH_TITLE");
				ArrayList<BoardDTO> datas=boardDAO.selectAll(boardDTO);
				mainView.printBoardList(boardDAO.selectAll(boardDTO));	
			}
			else if(menu==3) {//"3. 글 검색 : 작성자"!
				//				String writer=view. 작성자 받기
				String writer=mainView.searchWriter();
				BoardDTO boardDTO=new BoardDTO();
				boardDTO.setWriter(writer);
				boardDTO.setcondition("SEARCH_WRITER");
				ArrayList<BoardDTO> datas=boardDAO.selectAll(boardDTO);
				mainView.printBoardList(boardDAO.selectAll(boardDTO));	
				
			}
			else if(menu==4) {//"4. 글 1개 선택"
				//검색할 글의 pk값을 view에서 사용자에게 받아오세요
				int num=mainView.inputNum();
				//받은 값을 boardDTO에 저장후에 보내줘라
				BoardDTO boardDTO=new BoardDTO();
				boardDTO.setNum(num);
				BoardDTO data=boardDAO.selectOne(boardDTO);
				boardDTO.setcondition("VIEW");
				boolean flag=boardDAO.update(boardDTO);
				if(!flag) {
					mainView.printFalse();//조회수가 올라가지 않을때
				}
				if(data!=null) {
					mainView.printBoardData(data);// 데이터가 있으면 보여준다.
				}
				else {
					mainView.printFalse();// 데이터가 없으면 보여주지 않는다.
				}
			}
			else if(menu==5) { // 로그인
				//				V에서 사용자에게 아이디, 비밀번호를 받아올 예정
				//				DB에게 사용자가 입력한 아이디와 비밀번호를 전달해주고
				//				DB가 아이디와 비밀번호가 있는지, 맞는지 확인해서 
				//				C가 V에게 알려줘야 한다.
				//				로그인됬다,안됬다 알려주기!! 
				MemberDTO data=logoutView.inputLoginInfo();
				//				System.out.println("로그 01");
				//				System.out.println(data);
				data.setCondition("LOGIN");
				data=memberDAO.selectOne(data);
				//				System.out.println("로그 02");
				//				System.out.println(data);

				if(data != null) { // 로그인에 성공한 경우
					user=data; // 로그인 상태로 변환 !!!
					mainView.printTrue();
				}
				else {
					mainView.printFalse();
				}
			}
//			else if(menu==6) {//"6. 회원가입 아이디 따로 비밀번호 따로
//				//V에서 아이디 값을 받는다 ..
//				String mid=logoutView.inputMid();
//				//M(DB)한테 아이디가 중복인지를 물어봐야함
//				//중복일때
//				//아닐떄
//				while(true) {
//					if(중복이 아닐떄) {
//						break;
//					}
//				}
//				//비밀번호와 이름을 마저 입력
//				//아이디랑+비번 조합해서 M한테 Insert 시키면된다 !!
//				//성공  / 실패
//			}
			else if(menu==6) {//"6. 회원가입 아이디 비밀번호 같이
				//회원 가입을 하기 위해서 우선 아이디 비밀번호 이름을 기입해야 한다.
				MemberDTO data;				
				while(true) { //아이디 중복확인
					data = logoutView.inputSignUp();
					data.setCondition("SEACHMID");
					MemberDTO memberDTO = memberDAO.selectOne(data); //아이디 중복 확인
					if(memberDTO == null) {
						break;
					}
					logoutView.printcation();
				}
				boolean flag = memberDAO.insert(data);
				if(flag) {
					logoutView.printSinUpTrue();
				}
				else {
					logoutView.printSinUpFalse();
				}

			}
			else if(menu==7) {//7. 로그아웃
				user = null;
				mainView.printTrue();
			}
			else if(menu==8) {//8. 글 작성
				//로그인 한사람이 글을 쓸건데
				BoardDTO data=loginView.inputBoardData();
				//제목,내용을 작성하면
				data.setNum(PK++);
				data.setWriter(user.getMid());
				//M한테 제목,내용+ 누가썻는지 까지 정보를 보내주면 
				//M이 DB에 INSERT하겠지
				boolean flag=boardDAO.insert(data);

				//잘 작성됬으면 T / 아니면 F
				if(flag) {
					mainView.printTrue();
				}
				else {
					mainView.printFalse();
				}

			}
			else if(menu==9) {//9. 글 삭제
				//로그인 한사람이 글을 삭제
				//내가 쓴글을 검색한다.
				//유효성검사를 꼼꼼하게 해보자
				BoardDTO boardDTO=new BoardDTO();
				boardDTO.setWriter(user.getMid());
				boardDTO.setcondition("SEARCH_WRITER");
				ArrayList<BoardDTO> datas=boardDAO.selectAll(boardDTO);
				mainView.printBoardList(boardDAO.selectAll(boardDTO));	
				int num=loginView.inputNum(); ; //검색한 글중에 삭제할 글을 선택한다.
				boolean valid = loginView.validCheckDel(datas, num);
				//num하고 boardDTO.getNum()가 같은지 확인
				if(valid) {
					//확인이 됫으면 
					//V로부터 받은 정보를 DB에 보내준다.
					//dto를 하나 더 만들어야 한다. 
					boardDTO.setNum(num);
					BoardDTO data=boardDAO.selectOne(boardDTO);
					boolean flag=boardDAO.delete(data);
					//삭제 되었으면 삭제 안됫으면 안됨
					if(flag) {
						mainView.printTrue();
					}
					else {
						mainView.printFalse();
					}
				}
				if(!valid) {
					loginView.printValidFalse();//잘못된 유효값 숫자를 기입
				}


			}
			else if(menu==10) {//10. 글 내용변경
				//내가 쓴글을 검색한다.
				BoardDTO boardDTO=new BoardDTO();
				boardDTO.setWriter(user.getMid());
				boardDTO.setcondition("SEARCH_WRITER");
				ArrayList<BoardDTO> datas=boardDAO.selectAll(boardDTO);
				mainView.printBoardList(boardDAO.selectAll(boardDTO));
				//수정할 글을 선택한다.
				int num=loginView.inputNum(); ; //검색한 글중에 삭제할 글을 선택한다.
				boolean valid = loginView.validCheckDel(datas, num);
				//num하고 boardDTO.getNum()가 같은지 확인
				if(valid) {
					//확인이 됫으면 
					//V로부터 받은 정보를 DB에 보내준다.
					boardDTO.setNum(num);
					BoardDTO data=boardDAO.selectOne(boardDTO);
					String content = loginView.FixedContents();
					data.setContent(content);
					data.setcondition("CONTENT");
					boolean flag=boardDAO.update(data);
					//수정 되었으면 성공/ 안되었으면 실패
					if(flag) {
						mainView.printTrue();
					}
					else {
						mainView.printFalse();
					}
				}
				else if(!valid) {
					loginView.printValidFalse();//잘못된 유효값 숫자를 기입
				}

			}
			else if(menu==11) {//11. 회원탈퇴
				String password = user.getPassword();
				boolean checkResult=loginView.checkDelPas(password);
				if(checkResult) {
					MemberDTO memberDTO=new MemberDTO();
					memberDTO.setMid(user.getMid());
					boolean flag=memberDAO.delete(memberDTO);
					if(flag) {
						user = null;
						mainView.printTrue();
					}
					else {
						mainView.printFalse();
					}
				}
				if(!checkResult) {
					loginView.printWrongpass();
				}
			}
		}
	}
}
