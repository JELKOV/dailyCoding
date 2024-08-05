package crawling;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
// import 패키지 확인 !!!

import model.ProductDTO;

// 라이브러리 == jar == JAVA 압축파일 == JAVA 소스코드 모음집 == 패키지

public class Crawling {

	// 객체와 무관하게(객체화 하지않고) 그냥 쓰세요~~~
	public static ArrayList<ProductDTO> makeSample() {

		String url="http://camelmart.godomall.com/main/index.php";
		Connection conn=Jsoup.connect(url); // ☆ 객체화 x
		// 연결 확보

		Document doc=null;
		try {
			doc=conn.get();
			// 웹 페이지 문서 확보
		} catch (IOException e) {
			System.err.println("doc 확보 실패 !");
		} finally {
			System.out.println("웹 페이지 문서 확보 --- 수행 완료");
		}

		///System.out.println(doc);
		// 문서 확인

		ArrayList<ProductDTO> datas=new ArrayList<ProductDTO>();

		Elements elems = doc.select("strong.item_name");
		int cnt=0;
		for(Element elem:elems) {
			if(cnt%10 == 0) {
				///System.out.println(elem.text());
				ProductDTO data=new ProductDTO();
				data.setName(elem.text());
				datas.add(data);
			}
			cnt++;
		}
		///System.out.println("cnt = "+cnt);
		// 크롤링 가능한 데이터 80개
		///System.out.println("datas의 size = "+datas.size());

		Elements elems02 = doc.select("strong.item_price > span");
		// [선택자]를 활용
		cnt=0;
		int i=0; // datas의 index
		for(Element elem:elems02) {
			if(cnt%10 == 0) {
				///System.out.println(elem.text());
				String str=elem.text();
				str=str.replace("원", "");
				str=str.replace(",", "");
				int price=Integer.parseInt(str);
				datas.get(i++).setPrice(price);
			}
			cnt++;
		}

		return datas;

	}

}
