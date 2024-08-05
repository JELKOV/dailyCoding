package model;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DataDAO {
	private ArrayList<DataDTO> datas;
	public DataDAO() {
		int pk=1001;
		datas=new ArrayList<DataDTO>();
		
		String url="http://camelmart.godomall.com/";
		// 웹 페이지에서 "index"란, 표지 페이지(첫 페이지)를 의미함
		
		Connection conn = Jsoup.connect(url);
		// Jsoup으로 url 연결시도
		// 연결객체가 반환됨
		
		// Jsoup은 JAVA의 기본 패키지가 아니다.
		//                   라이브러리 == 소스코드모음집
		// Jsoup 라이브러리를 별도로 설치해야함
		//  .jar JAVA아카이브==JAVA압축파일==소스코드모음집==라이브러리==패키지
		
		try {
			Document doc = conn.get();
			
			Elements elems= doc.select("div.item_tit_box");
			Elements priceAll = doc.select("strong.item_price");
			
			for(Element price:priceAll) {
				DataDTO data=new DataDTO();
				data.setPk(pk++);
				data.setTitle(price.text());
				datas.add(data);
			}
		} catch (IOException e) {
			System.out.println("연결중 에러발생!");
		}	
	}
	
	public ArrayList<DataDTO> selectAll(DataDTO dto){
		return datas;
	}

}
