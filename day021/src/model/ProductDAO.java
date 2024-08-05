package model;

import java.util.ArrayList;
import java.util.Random;

import crawling.Crawling;

public class ProductDAO {
	private ArrayList<ProductDTO> datas; // DB 역할
	public ProductDAO() {
		this.datas=new ArrayList<ProductDTO>();
		
		// 샘플 데이터들을 추가하는 코드
		ArrayList<ProductDTO> sampleDatas=Crawling.makeSample();
		Random rand=new Random();
		int PK=101;
		for(ProductDTO sampleData:sampleDatas) {
			ProductDTO data=new ProductDTO();
			data.setNum(PK++);
			data.setName(sampleData.getName());
			data.setPrice(sampleData.getPrice());
			data.setCount(rand.nextInt(11));
			this.datas.add(data);
		}
	}
	public ProductDTO selectOne(ProductDTO productDTO) {
		for(ProductDTO data:this.datas) {
			if(productDTO.getNum() == data.getNum()) {
				return data;
			}
		}
		return null;
	}
	public ArrayList<ProductDTO> selectAll(ProductDTO productDTO) {
		// 여러 기능을 하나의 비즈니스 메서드에서 처리하는 이유
		//  : 높은 응집도 ▶ 유지보수 용이
		ArrayList<ProductDTO> datas=new ArrayList<ProductDTO>();
		for(ProductDTO data:this.datas) {
			datas.add(data);
		}
		return datas;
	}
	// 인자를 DTO로 고정하는 이유
	//  : 낮은 결합도 ▶ 유지보수 용이
	private boolean insert(ProductDTO productDTO) {
		return false;
	}
	private boolean update(ProductDTO productDTO) {
		return false;
	}
	private boolean delete(ProductDTO productDTO) {
		return false;
	}
}
