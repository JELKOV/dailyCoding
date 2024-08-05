package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	//가독성 높아짐
	//유지보수 높아짐
	//응집도 높아짐
	private final String INSERT="INSERT INTO MEMBER (MID,PASSWORD,NAME) VALUES(?,?,?)";
	private final String SELECTONE="SELECT MID,PASSWORD,NAME FROM MEMBER WHERE MID=? AND PASSWORD=?";
	private final String UPDATE="UPDATE MEMBER SET PASSWORD=? WHERE MID=?";
	private final String DELETE="DELETE FROM MEMBER WHERE MID=?";
	private final String CHECKID="SELECT MID,PASSWORD,NAME FROM MEMBER WHERE MID=?";

	public boolean insert(MemberDTO memberDTO) {
		// C에서 회원가입 하고싶은 사람의 정보들이 넘어오겠지?
		// (mid, password, name)넘어오겠지?
		// 정보들을 DB에 INSERT하면 되겠다.

		//Util류는 객체가 중요하지 않고 메서드가 중요하니깐 
		// 메서드를 클래스 메서드화(Static화==객체와 무관하게)
		// 패턴화된 코드
		//결론)
		//[1,2]단계를 수행했다면
		//conn객체를 줘야함
		Connection conn=JDBCUtil.connect();		
		PreparedStatement pstmt= null;

		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, memberDTO.getMid());
			pstmt.setString(2, memberDTO.getPassword());
			pstmt.setString(3, memberDTO.getName());
			int result = pstmt.executeUpdate();// int를 리턴
			if(result<=0) {
				System.err.println("SQL문은 올바른데 DTO값이 이상할수도 있음");
				return false;
			}
		} catch (SQLException e) {
			System.err.println("[3]단계 실패");
		} finally {
			System.err.println("DB에 데이터 write <가입>");
		}

		//패턴화된 코드
		boolean flag=JDBCUtil.disconnect(conn, pstmt);
		return flag;
	}
	public boolean update(MemberDTO memberDTO) {
		//C에서 아이디하고 비밀번호를 줄거야
		//그걸 받고 아이디를 확인하고 변경하자
		Connection conn=JDBCUtil.connect();//[1]드라이버 로드[2]CONN 확보
		PreparedStatement pstmt= null;

		try {
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setString(1, memberDTO.getPassword());
			pstmt.setString(2, memberDTO.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("[3]단계 실패");
		} finally {
			System.err.println("DB에 데이터 write <비밀번호변경성공>");
		}

		//패턴화된 코드
		boolean flag=JDBCUtil.disconnect(conn, pstmt);
		return flag;
	}
	public boolean delete(MemberDTO memberDTO) {
		//C에서 회원아이디를 줄거야
		//그것을 삭제해보자

		Connection conn=JDBCUtil.connect();	//[1]드라이버 로드[2]CONN 확보
		PreparedStatement pstmt= null;

		try {
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setString(1, memberDTO.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("[3]단계 실패");
		} finally {
			System.err.println("DB에 데이터 write <삭제성공>");
		}

		//패턴화된 코드
		boolean flag=JDBCUtil.disconnect(conn, pstmt);
		return flag;
	}
	private ArrayList<MemberDTO> selectAll(MemberDTO memberDTO) {
		return null;
	}
	public MemberDTO selectOne(MemberDTO memberDTO) {


		// C에서 로그인 정보가 온다.
		// id,password
		// 저 id,password를 가진 데이터가 있는지 확인
		// SELECT
		// 있으면 DTO 반환
		// 없으면 null 반환
		//[1]드라이버 로드
		//[2]CONN 확보
		Connection conn=JDBCUtil.connect();
		//[3]데이터를 read
		//[1,2] ,[4] 모듈화 [3] 다르다
		// 패턴화 된 코드 (템플릿화)된 코드
		// Util 이라고 부른다.
		//java.util.ArrayList
		//jaba.util.Random
		PreparedStatement pstmt= null;
		try {
			if(memberDTO.getCondition().equals("IDCHECK")) {
				pstmt = conn.prepareStatement(CHECKID);
				pstmt.setString(1, memberDTO.getMid());
			}
			else if(memberDTO.getCondition().equals("LOGIN")) {
				pstmt = conn.prepareStatement(SELECTONE);
				pstmt.setString(1, memberDTO.getMid());
				pstmt.setString(2, memberDTO.getPassword());	
			}
			// select
			ResultSet rs = pstmt.executeQuery();
			//있으면 DTO 반환
			if(rs.next()){
				MemberDTO data = new MemberDTO();
				//가독성을 위해 Oracle 파트를 대문자로 작성한다.
				data.setMid(rs.getString("MID"));
				data.setPassword(rs.getString("PASSWORD"));
				data.setName(rs.getString("NAME"));
				return data;
			}
			//없으면 null 반환
			else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("[3] DB 데이터 Read 실패....");
			return null; // 실패시 다머지는 실행되면 안되기 때문에 return false;를 반환해 주어야 한다.
		} finally {
			System.err.println("[3] DB 데이터 Read 성공!");	

			//DB Driver + SQL Query 를 finally안에 넣어둔 이유는
			//종료가 되고 무조건 실행 되기 떄문이다.
			//[4]2단계 확보한거 close() == 연결 해제
			boolean flag = JDBCUtil.disconnect(conn,pstmt);
			if(!flag) {
				return null;
			}
		}


	}
}
