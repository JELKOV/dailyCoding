package service.model;

import java.util.ArrayList;

// CRUD(비즈니스 메서드, 핵심 관심, 핵심 로직)
// CRUD 인자를 DTO로 통합하자!!!!! == 코드의 결합도를 낮추기위함
public class BoardDAO {
	private ArrayList<BoardDTO> datas; // DB 역할
	public BoardDAO() {
		this.datas=new ArrayList<BoardDTO>();

		// 샘플 데이터 추가할수있는 공간
		BoardDTO data=new BoardDTO();
		data.setNum(101);
		data.setTitle("샘플");
		data.setContent("ㅈㄱㄴ");
		data.setCnt(0);
		this.datas.add(data);
	}

	public boolean insert(BoardDTO boardDTO) {
		System.out.println("insert 시작 log");
		BoardDTO data=new BoardDTO();
		data.setNum(boardDTO.getNum());
		data.setTitle(boardDTO.getTitle());
		data.setContent(boardDTO.getContent());
		data.setCnt(0);
		this.datas.add(data);
		System.out.println("insert 성공 log");
		return true;
	}
	public boolean update(BoardDTO boardDTO) {
		System.out.println("update 시작 log");
		if(boardDTO.getCondition().equals("VIEW")) {
			for(BoardDTO data:this.datas) {
				if(data.getNum() == boardDTO.getNum()) {
					data.setCnt(data.getCnt()+1); // 현재방문자수+1
					System.out.println("update 조회수 성공 log");
					return true;
				}
			}
			System.out.println("update 조회수 실패 log");
			return false;
		}
		else if(boardDTO.getCondition().equals("CONTENT")) {
			for(BoardDTO data:this.datas) {
				if(data.getNum() == boardDTO.getNum()) {
					data.setContent(boardDTO.getContent());
					System.out.println("update 내용수정 성공 log");
					return true;
				}
			}
			System.out.println("update 내용수정 실패 log");
			return false;
		}
		else if(boardDTO.getCondition().equals("TITLE")) {
			for(BoardDTO data:this.datas) {
				if(data.getNum() == boardDTO.getNum()) {
					data.setTitle(boardDTO.getTitle());
					System.out.println("update 제목수정 성공 log");
					return true;
				}
			}
			System.out.println("update 제목수정 실패 log");
			return false;
		}
		System.out.println("update 실패 log");
		return false;
	}
	public boolean delete(BoardDTO boardDTO) {
		System.out.println("delete 시작 log");
		for(int i=0; i<datas.size(); i++) {
			if(datas.get(i).getNum()==boardDTO.getNum()) {
				datas.remove(i);
				System.out.println("delete 성공 log");
				return true;
			}
		}
		System.out.println("delete 실패 log");
		return false;
	}

//	public ArrayList<BoardDTO> selectAll(BoardDTO boardDTO){
//		System.out.println("selectAll 시작 log");
//		if(boardDTO.getCondition().equals("ALL")) {
//			System.out.println("selectAll 전체출력 종료 log");
//			return this.datas;	
//		}
//		else if(boardDTO.getCondition().equals("TITLESEARCH")) {
//			ArrayList<BoardDTO> searchData=new ArrayList<BoardDTO>();
//			for(BoardDTO data:this.datas) {
//				if(data.getTitle().contains(boardDTO.getTitle())) {
//					searchData.add(data);
//				}
//			}
//			System.out.println("selectAll 제목검색 종료 log");
//			return searchData;
//		}
//		else {
//			System.out.println("selectAll 실패 log");
//			return null;
//		}
//	}
	public ArrayList<BoardDTO> selectAll(BoardDTO boardDTO){
		ArrayList<BoardDTO> datas=new ArrayList<BoardDTO>();
		if(boardDTO.getCondition().equals("ALL")) {
			for(BoardDTO data:this.datas) {
				datas.add(data);
			}
		}
		else if(boardDTO.getCondition().equals("SEARCH_TITLE")) {
			for(BoardDTO data:this.datas) {
				if(data.getTitle().contains(boardDTO.getTitle())) {
					datas.add(data);
				}
			}
		}
		return datas;
	}
	
	public BoardDTO selectOne(BoardDTO boardDTO){
		System.out.println("selectOne 시작 log");
		for(BoardDTO data:this.datas) {
			if(data.getNum() == boardDTO.getNum()) {
				System.out.println("selectOne 성공 log");
				return data;
			}
		}
		System.out.println("selectOne 실패 log");
		return null;
	}
}
