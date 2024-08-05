package model;

import java.util.ArrayList;

public class BoardDAO {
	private ArrayList<BoardDTO> datas;
	
	public BoardDAO() {
		this.datas = new ArrayList<BoardDTO>();
	}

	public boolean insert(BoardDTO boardDTO) {
		// 글 작성
		System.out.println("insert log 시작");
		BoardDTO data=new BoardDTO(); // 새로운 정보를 저장할 데이터 공간을 생성
		data.setNum(boardDTO.getNum()); // pk값 
		data.setTitle(boardDTO.getTitle());// 제목값
		data.setContent(boardDTO.getContent()); //내용값
		data.setWriter(boardDTO.getWriter());//작성자
		data.setCnt(0); // 조회수
		this.datas.add(data); //저장
		System.out.println("insert log 종료");
		return true;
	}
	public boolean update(BoardDTO boardDTO) {
		// 글 내용 변경
		System.out.println("update log 시작");
		if(boardDTO.getcondition().equals("CONTENT")) {
			for(BoardDTO data:this.datas) {
				if(data.getNum() == boardDTO.getNum()) {
					data.setContent(boardDTO.getContent());
					System.out.println("update 내용수정 성공 log");
					return true;
				}
			}
		}
		else if(boardDTO.getcondition().equals("VIEW")) {
			for(BoardDTO data:this.datas) {
				if(data.getNum() == boardDTO.getNum()) {
					data.setCnt(boardDTO.getCnt()+1);
					System.out.println("update 조회수 상승 성공 log");
					return true;
				}
			}
		}
		System.out.println("update log 실패");
		return false;
	}
	public boolean delete(BoardDTO boardDTO) {
		// 글 삭제
		System.out.println("delete log 시작");
		for(int i=0; i<datas.size(); i++) {
			if(datas.get(i).getNum()==boardDTO.getNum()) {
				datas.remove(i);
				System.out.println("delete log 성공 종료");
				return true;
			}
		}
		System.out.println("delete log 실패");
		return false;
	}

	public ArrayList<BoardDTO> selectAll(BoardDTO boardDTO) {
		// 글 전체 출력
		ArrayList<BoardDTO> datas = new ArrayList<BoardDTO>();
		if(boardDTO.getcondition().equals("ALL")) {
			for(BoardDTO data:this.datas) {
				datas.add(data);
			}
		}
		// 글 검색 : 제목 검색
		else if(boardDTO.getcondition().equals("SEARCH_TITLE")) {
			for(BoardDTO data:this.datas) {
				if(data.getTitle().contains(boardDTO.getTitle())) {
					datas.add(data);
				}
			}
		}
		// 글 검색 : 작성자 검색
		else if(boardDTO.getcondition().equals("SEARCH_WRITER")) {
			for(BoardDTO data:this.datas) {
				if(data.getWriter().contains(boardDTO.getWriter())) {
					datas.add(data);
				}
			}
		}
		return datas;
	}
	public BoardDTO selectOne(BoardDTO boardDTO) {
		// 글 1개 선택
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
