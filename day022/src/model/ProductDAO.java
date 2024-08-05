package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
	private final String INSERT="INSERT INTO PRODUCT (NUM,NAME,PRICE,CNT) VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM PRODUCT),?,?,?)";
	private final String DELETE="DELETE FROM PRODUCT WHERE NUM=?";
	private final String SELECTONE_ISEMPTY="SELECT COUNT(*) AS TOTAL FROM PRODUCT";
	private final String SELECTONE_SEARCHNUM="SELECT NUM,NAME,PRICE,CNT FROM PRODUCT WHERE NUM=?";
	private final String SELECTALL_DEFAULT="SELECT NUM,NAME,PRICE,CNT FROM PRODUCT ORDER BY NUM";
	private final String SELECTALL_SEARCHNAME="SELECT NUM,NAME,PRICE,CNT FROM PRODUCT WHERE NAME LIKE '%'||?||'%'";
	private final String SELECTALL_ORDERPRICE="SELECT NUM,NAME,PRICE,CNT FROM PRODUCT ORDER BY PRICE";
	private final String UPDATE_BUY="UPDATE PRODUCT SET CNT=CNT-? WHERE NUM=?";
	//가져올때 DB에서 가져


	public boolean insert(ProductDTO productDTO) {
		Connection conn=JDBCUtil.connect();

		PreparedStatement pstmt= null;
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, productDTO.getName());
			pstmt.setInt(2, productDTO.getPrice());
			pstmt.setInt(3, productDTO.getCnt());
			int result = pstmt.executeUpdate();
			if(result<=0) {
				System.err.println("SQL문은 올바른데 DTO값이 이상할수도 있음");
				return false;
			}
		} catch (SQLException e) {
			System.err.println("[3]단계 실패");
		} finally {
			System.err.println("DB에 데이터 write <상품추가>");
		}

		//패턴화된 코드
		boolean flag=JDBCUtil.disconnect(conn, pstmt);
		return flag;
	}
	public boolean update(ProductDTO productDTO) {
		//C에서 장바구니를 productDTO에 담아서 줄거야
		//그걸 받고 재고를 빼주고 토탈 가격을 보내주자.
		Connection conn=JDBCUtil.connect();//[1]드라이버 로드[2]CONN 확보
		PreparedStatement pstmt= null;
		try {
			pstmt = conn.prepareStatement(UPDATE_BUY);
			pstmt.setInt(1, productDTO.getCnt());
			pstmt.setInt(2, productDTO.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("[3]단계 실패");
		} finally {
			System.err.println("DB에 데이터 write <재고감소 성공>");
		}
		
		//패턴화된 코드
		boolean flag=JDBCUtil.disconnect(conn, pstmt);
		return flag;
	}
	public boolean delete(ProductDTO productDTO) {
		Connection conn=JDBCUtil.connect();
		PreparedStatement pstmt= null;

		try {
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setInt(1, productDTO.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("[3]단계 실패");
		} finally {
			System.err.println("DB에 데이터 write <삭제>");
		}
		//패턴화된 코드
		boolean flag=JDBCUtil.disconnect(conn, pstmt);
		return flag;
	}
	public ArrayList<ProductDTO> selectAll(ProductDTO productDTO) {
		ArrayList<ProductDTO> datas= new ArrayList<ProductDTO>();// 배열반환할거야

		Connection conn=JDBCUtil.connect();
		PreparedStatement pstmt= null;

		try {
			if(productDTO.getCondition().equals("DEFAULT")) {
				pstmt=conn.prepareStatement(SELECTALL_DEFAULT);
			}
			else if(productDTO.getCondition().equals("SEARCHNAME")) {
				pstmt= conn.prepareStatement(SELECTALL_SEARCHNAME);
				pstmt.setString(1, productDTO.getName());
			}
			else if(productDTO.getCondition().equals("ORDERBYPRICE")) {
				pstmt= conn.prepareStatement(SELECTALL_ORDERPRICE);
			}
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO data=new ProductDTO();
				data.setNum(rs.getInt("NUM"));
				data.setName(rs.getString("NAME"));
				data.setPrice(rs.getInt("PRICE"));
				data.setCnt(rs.getInt("CNT"));
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JDBCUtil.disconnect(conn, pstmt);
		System.err.println("DB에 데이터 write <SA 성공>");

		return datas;
	}
	public ProductDTO selectOne(ProductDTO productDTO) {
		Connection conn=JDBCUtil.connect();

		PreparedStatement pstmt=null;
		try {
			if(productDTO.getCondition().equals("ISEMPTY")) {
				pstmt = conn.prepareStatement(SELECTONE_ISEMPTY);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					ProductDTO data=new ProductDTO();
					data.setTotal(rs.getInt("TOTAL"));
					return data;
				}
			}
			else if(productDTO.getCondition().equals("SEARCHNUM")) {
				pstmt = conn.prepareStatement(SELECTONE_SEARCHNUM);
				pstmt.setInt(1, productDTO.getNum());
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					ProductDTO data=new ProductDTO();
					data.setNum(rs.getInt("NUM"));
					data.setName(rs.getString("NAME"));
					data.setPrice(rs.getInt("PRICE"));
					data.setCnt(rs.getInt("CNT"));
					return data;
				}
			}
			return null;
		} catch (SQLException e) {
			System.err.println("[3]단계 실패 ...");
			return null;
		} finally {
			System.err.println("DB로부터 데이터를 read<SO 성공>");
			boolean flag=JDBCUtil.disconnect(conn, pstmt);
			if(!flag) {
				return null;
			}
		}


	}
	
}
