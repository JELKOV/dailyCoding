package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import crawling.Crawling;
import model.SongDTO;

public class DBconnect {
	public static void main(String[] args) {
		String driverName="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String userName="AHNJAEHO";
		String password="1234";
		String createTable= "CREATE TABLE MUSIC("
				+ "NUM INT PRIMARY KEY, "
				+ "TITLE VARCHAR(300) NOT NULL, "
				+ "ARTIST VARCHAR(150) NOT NULL)";
		String deleteTable="DROP TABLE MUSIC";
		String selectAll="SELECT NUM,TITLE,ARTIST FROM MUSIC";
		String insert="INSERT INTO MUSIC (NUM, TITLE, ARTIST) VALUES (?, ?, ?)";

		while(true) {
			//1. JDBC 드라이버를 메모리에 로드
			try {
				Class.forName(driverName);
			} catch (ClassNotFoundException e) {
				System.err.println("해당 드라이버를 찾을수가 없습니다.");
			} finally {
				System.out.println("1. JDBC 드라이버를 메모리에 로드 성공");
			}

			//2. DB와 연결
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(url, userName, password);
			} catch (SQLException e) {
				System.err.println("DB 연결실패");
			} finally {
				System.out.println("2. DB 연결 성공");
			}
			//3. DB 데이터 읽어오기

			//3. DB에 insert 하기
			PreparedStatement pstmt = null;//매개변수를 포함하는 SQL 문을 실행할 때 사용
			Statement stmt = null; //고정된 SQL 문을 실행할 때 사용

			Scanner sc = new Scanner(System.in);
			System.out.println("원하는 작업을 선택하세요");
			System.out.println("0. 종료");
			System.out.println("1. 전체 데이터 조회");
			System.out.println("2. 크롤링 데이터 입력");
			System.out.println("3. MUSIC테이블 생성");
			System.out.println("4. MUSIC테이블 삭제");
			int number= sc.nextInt();
			if(number==1) {
				try {
					pstmt=conn.prepareStatement(selectAll);
					ResultSet rs = pstmt.executeQuery();
					if (!rs.isBeforeFirst()) { // ResultSet이 비어있는지 확인 false면 데이터 없음
						//isBeforeFirst() 메서드는 ResultSet의 커서가 첫 번째 행 앞에 있는지를 확인하여 true 또는 false를 반환
						System.out.println("데이터가 없습니다.");
					}else {
						while(rs.next()) {
							System.out.println("NUM : "+rs.getInt("NUM"));
							System.out.println("TITLE : "+rs.getString("TITLE"));
							System.out.println("ARTIST : "+rs.getString("ARTIST"));
							System.out.println();
						}
					}
				} catch (SQLException e) {
					System.err.println("SQL문이 올바르지않습니다!");
				}finally {
					// 4. DB 연결 해제
					try {
						//finally 블록이 아니라 try 블록 안에 있어서 연결 해제가 올바르게 수행되지 않을수 있어서 조건 걸어줌
						if (pstmt != null) {
							pstmt.close(); 
						}
						if (conn != null) {
							conn.close();
						}
						System.out.println("4. 연결 해제 성공");
					} catch (SQLException e) {
						System.err.println("연결을 해제할 수 없습니다!");
					}
				}
			}//1번종료
			else if(number==2) {
				ArrayList<SongDTO> dbDatas = Crawling.crawlData();
				try {
					pstmt = conn.prepareStatement(insert);
					for (SongDTO dbData : dbDatas) {
						pstmt.setInt(1, dbData.getPk()); //PK 입력
						pstmt.setString(2, dbData.getTitle()); //노래제목 입력
						pstmt.setString(3, dbData.getArtist());//가수 입력
						pstmt.executeUpdate();
					}
					System.out.println("3. DB에 insert 하기 성공");
				} catch (SQLException e) {
					System.err.println("SQL문이 바르지 않습니다.");
				} finally {
					// 4. DB 연결 해제
					try {
						if (pstmt != null) {
							pstmt.close();
						}
						if (conn != null) {
							conn.close();
						}
						System.out.println("4. 연결 해제 성공");
					} catch (SQLException e) {
						System.err.println("연결을 해제할 수 없습니다!");
					}
				}
			}//2번종료
			else if(number == 3){
				try {
					stmt = conn.createStatement();
					stmt.executeUpdate(createTable);
					System.out.println("3. table 생성 성공");
				} catch (SQLException e) {
					// 이미 테이블이 존재하는 경우 예외가 발생할 수 있으므로 이를 무시함
					System.err.println("테이블이 이미 존재하거나 SQL문이 올바르지 않습니다");
				} finally {
					// 4. DB 연결 해제
					try {
						if (stmt != null) {
							stmt.close();
						}
						if (conn != null) {
							conn.close();
						}
						System.out.println("4. 연결 해제 성공");
					} catch (SQLException e) {
						System.err.println("연결을 해제할 수 없습니다!");
					}
				}
			}//3번종료
			else if (number == 4) {
				try {
					stmt = conn.createStatement();
					stmt.executeUpdate(deleteTable);
					System.out.println("4. table 삭제 성공");
				} catch (SQLException e) {
					System.err.println("테이블 삭제 실패");
				} finally {
					// DB 연결 해제
					try {
						if (stmt != null) {
							stmt.close();
						}
						if (conn != null) {
							conn.close();
						}
						System.out.println("4. 연결 해제 성공");
					} catch (SQLException e) {
						System.err.println("연결을 해제할 수 없습니다!");
					}
				}
			}//4번종료
			else if(number==0) {// 종료
				break;
			}
		}
		System.out.println("jdbc가 종료되었습니다");
	}
}
