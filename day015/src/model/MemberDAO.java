package model;

import java.util.ArrayList;

public class MemberDAO {
	private ArrayList<MemberDTO> datas;
	public MemberDAO() {
		this.datas = new ArrayList<MemberDTO>();

		MemberDTO data=new MemberDTO();
		data.setMid("teemo");
		data.setPassword("1234");
		data.setName("작은티모");
		this.datas.add(data);
	}

	public boolean insert(MemberDTO memberDTO) {

		// 회원가입
		//C 신뢰 x
		//		for(MemberDTO data:this.datas) {
		//			if(data.getMid().equals(memberDTO.getMid())) {
		//				return false;
		//			}
		//		}
		//C 신뢰
		System.out.println("MDTO insert 시작 log");
		MemberDTO data=new MemberDTO();
		data.setMid(memberDTO.getMid());
		data.setPassword(memberDTO.getPassword());
		data.setName(memberDTO.getName());
		System.out.println(data);
		this.datas.add(data);
//		System.out.println("원본"+this.datas);
		System.out.println("MDTO insert 종료 log");
		return true;
	}
	private boolean update(MemberDTO memberDTO) {
		return false;
	}
	public boolean delete(MemberDTO memberDTO) {
		// 회원탈퇴
		System.out.println("MDTO delete 시작 log");
		for(int i=0; i<datas.size(); i++) {
			if(datas.get(i).getMid().equals(memberDTO.getMid())) {
				datas.remove(i); // remove할떄는 index가 필요해서
				System.out.println("MDTO delete 성공 log");
				return true;
			}
		}
		System.out.println("MDTO delete 실패 log");
		return false;
	}

	private ArrayList<MemberDTO> selectAll(MemberDTO memberDTO) {
		ArrayList<MemberDTO> datas = new ArrayList<MemberDTO>();
		return datas;
	}
	public MemberDTO selectOne(MemberDTO memberDTO) {
		System.out.println("MDTO selectOne 로그인 시작 log");
		// 로그인
		if(memberDTO.getCondition().equals("LOGIN")) {
			System.out.println("MDTO selectOne 로그인 시작 log");
			boolean flag=false;
			for(MemberDTO data:this.datas) {
				if (data.getMid().equals(memberDTO.getMid())) { // 아이디를 비교해서
					flag = true;
					if (data.getPassword().equals(memberDTO.getPassword())) { // 비밀번호를 비교해서
						System.out.println("MDTO selectOne 로그인 성공 log");
						return data;
					} else {
						System.out.println("MDTO selectOne 비밀번호 오류 log");
					}
				}
				if (!flag) {
					System.out.println("MDTO selectOne 아이디 없음 log");
				}
			}
		}
		else if(memberDTO.getCondition().equals("SEACHMID")){
			System.out.println("MDTO selectOne 회원가입아이디 중복 확인 시작 log");
			for(MemberDTO data:this.datas) {
				if(data.getMid().equals(memberDTO.getMid())) {
					System.out.println("로그 : SEACHMID 종료 아이디 중복 selectOne ");
					return data;
				}
			}
		}
		System.out.println("MDTO selectOne 종료  log");
		return null;
	}
}
