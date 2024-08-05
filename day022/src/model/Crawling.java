package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {
	public static ArrayList<ProductDTO> makeSample() {
		ArrayList<ProductDTO> datas=new ArrayList<ProductDTO>();

		String url="http://camelmart.godomall.com/main/index.php";
		Connection conn=Jsoup.connect(url);

		Document doc=null;
		try {
			doc=conn.get();
		} catch (IOException e) {
			System.err.println("doc 확보 실패 ...");
		}
		
		//Element는 따로 따로 받아야 한다. 겹치면 안된다.
		//따로따로 정제 가공해야한다.
		//가공(정제)작업이 중요하다 

		Elements elems = doc.select("strong.item_name");
		int cnt=0;
		for(Element elem:elems) {
			if(cnt%10 == 0) {
				ProductDTO data=new ProductDTO();
				data.setName(elem.text());
				datas.add(data);
			}
			cnt++;
		}

		Elements elems02 = doc.select("strong.item_price > span");
		cnt=0;
		int i=0;
		for(Element elem:elems02) {
			if(cnt%10 == 0) {
				String str=elem.text();
				str=str.replace("원", "");
				str=str.replace(",", "");
				int price=Integer.parseInt(str);
				datas.get(i++).setPrice(price);
			}
			cnt++;
		}
		
		Random rand=new Random();
		for(i=0; i<datas.size();i++) {
			datas.get(i).setCnt(rand.nextInt(6));
		}

		return datas;
	}
}
