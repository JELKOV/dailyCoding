package service.controller;

import java.util.ArrayList;

import service.model.BoardDAO;
import service.model.BoardDTO;
import view.BoardView;

public class BoardController {
	private BoardView view; // C는 V,M을 멤버변수로 갖는다는 점
	private BoardDAO model;
	private int PK;
	public BoardController() { // 멤버변수 초기화 == 생성자
		this.view=new BoardView();
		this.model=new BoardDAO();
		this.PK=102;
	}

	public void start() {
		while(true) {
			view.printMenuList();
			int action=view.inputMenuNum();

			if(action==0) { // 프로그램 종료
				view.exit();
				break;
			}
			else if(action==1) { // 게시글 작성
				BoardDTO data = view.boardWrite();

				BoardDTO boardDTO=new BoardDTO();
				boardDTO.setNum(PK++);
				boardDTO.setTitle(data.getTitle());
				boardDTO.setContent(data.getContent());
				boolean flag=model.insert(boardDTO);
				if(flag) {
					view.printTrue();
				}
				else {
					view.printFalse();
				}
			}
			else if(action==2) { // 전체목록출력
				BoardDTO boardDTO=new BoardDTO();
				boardDTO.setCondition("ALL");
				view.printBoardList(model.selectAll(boardDTO));
			}
			else if(action==3) { // 글 1개 검색 == 글 선택
				int num=view.inputNum();

				BoardDTO boardDTO=new BoardDTO();
				boardDTO.setNum(num);
				BoardDTO data = model.selectOne(boardDTO);
				boardDTO.setCondition("VIEW"); // 방문즉시 조회수++
				boolean flag=model.update(boardDTO);
				if(!flag) {
					view.printFalse();
					continue;
				}

				if(data!=null) {
					view.printBoardData(data);
				}
				else {
					view.printFalse();
				}
			}
			else if(action==4) { // 내용 변경
				int num=view.inputNum();
				String content=view.inputContent();

				BoardDTO boardDTO=new BoardDTO();
				boardDTO.setNum(num);
				boardDTO.setContent(content);
				boardDTO.setCondition("CONTENT");
				boolean flag=model.update(boardDTO);
				if(flag) {
					view.printTrue();
				}
				else {
					view.printFalse();
				}
			}
			else if(action==5) { // 제목 변경
				int num=view.inputNum();
				String title=view.inputTitle();

				BoardDTO boardDTO=new BoardDTO();
				boardDTO.setNum(num);
				boardDTO.setTitle(title);
				boardDTO.setCondition("TITLE");
				boolean flag=model.update(boardDTO);
				if(flag) {
					view.printTrue();
				}
				else {
					view.printFalse();
				}
			}
			else if(action==6) { // 글 삭제
				int num=view.inputNum();
				BoardDTO boardDTO=new BoardDTO();
				boardDTO.setNum(num);
				BoardDTO data=model.selectOne(boardDTO);
				if(data!=null) {
					view.printBoardData(data);
					boolean check=view.deleteData();
					if(!check) {
						view.checkFalse();
					}
					else if(check) {
						boolean flag=model.delete(boardDTO);
						if(!flag) {
							view.printFalse();
							continue;
						}
						else if(flag) {
							//삭제완료
							view.checkTrue();
						}
					}
				}
				else {
					view.printFalse();
				}
			}
			else if(action==7) { // 제목으로 검색
				String title = view.searchTitle();
				BoardDTO boardDTO=new BoardDTO();
				boardDTO.setTitle(title);
				boardDTO.setCondition("TITLESEARCH");
				ArrayList<BoardDTO> datas=model.selectAll(boardDTO);
				view.printBoardList(datas);
			}
		}
	}
}
