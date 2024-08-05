package model;

import java.util.ArrayList;

public class MemberDAO {
	private ArrayList<MemberDTO> datas;

	public MemberDAO() {
		this.datas = new ArrayList<MemberDTO>();
	}

	public boolean insert(MemberDTO memberDTO) { // 회원가입
		//회원가입 로직
		System.out.println("MemberDTO insert 시작로그");
		MemberDTO data =new MemberDTO(); //가입할회원데이터객체 생성;
		data.setMemberId(memberDTO.getMemberId()); //가입할 아이디 변경
		data.setPassword(memberDTO.getPassword()); //가입할 비밀번호 변경
		this.datas.add(data); //DB에 넣어줌
		System.out.println("MemberDTO insert 종료로그");
		return true;
	}

	public MemberDTO selectOne(MemberDTO memberDTO) { // selectOne 
		// 로그인 확인 로직 selectOne
		if (memberDTO.getCondition().equals("LOGIN")) { // 조건이 "로그인"인지 확인
			System.out.println("MemberDTO 로그인 selectOne log 시작");
			for (MemberDTO data : this.datas) { // 모든 회원 데이터를 순회
				if (data.getMemberId().equals(memberDTO.getMemberId())) { // 현재 데이터의 아이디가 입력된 아이디와 일치하는지 확인
					if (data.getPassword().equals(memberDTO.getPassword())) { // 비밀번호 일치 여부 확인
						System.out.println("MemberDTO 로그인 selectOne log 성공");
						return data; // 일치하는 회원 데이터 반환
					} else {
						System.out.println("MemberDTO 로그인 selectOne log 실패: 비밀번호 오류");
					}
				}
			}
			System.out.println("MemberDTO 로그인 selectOne log 실패: 아이디 없음");
			return null;
		} else if (memberDTO.getCondition().equals("CHECKID")) { // 조건이 "아이디중복확인"인지 확인
			// 회원 가입 중복 데이터 확인 selectOne
			System.out.println("MemberDTO 회원가입중복검사 selectOne log 시작");; // 아이디 중복 확인 시작 로그 출력
			for (MemberDTO data : this.datas) { // 모든 회원 데이터를 순회
				if (data.getMemberId().equals(memberDTO.getMemberId())) { // 현재 데이터의 아이디가 입력된 아이디와 일치하는지 확인
					System.out.println("MemberDTO 회원가입중복검사 selectOne log 아이디 중복"); // 아이디 중복 로그 출력
					return data; // 중복된 아이디 데이터 반환
				}
			}
		}
		System.out.println("MemberDTO 회원가입중복검사 selectOne log 아이디 없음 종료"); // 회원 조회 종료 로그 출력
		return null; // null 반환
	}
}