package crwaling;
//스크랩핑: 데이터 모으기
//크롤링: 모인 데이터를 가공  - >> 빅데이터 파이썬과 잘 맞는다. 
//데이터시각화
//크롤링: 모아서 정제 및 가공
//웹크롤링 :웹데이터 모아서 정제 및 가공
//정적크롤링: 웹 페이지 데이터에만 접근 
//        : 페이지에 직접 작성된 데이터만 접근가능
//        : "페이지 소스 코드 보기"로 보이는 데이터만 가져오는 것 ex)jsoup <<
//동적크롤링: 웹 페이지가 참조하는 데이터까지 접근가능
//        : 본 서버의 데이터를 암호화했다면 접근 불가능
//         ex)셀레니움 << 웹포트폴리오 작업할때 사용해보세요

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//오피지지 웹사이트는
//페이지 골격코드만 만듦
//실시간으로 데이터를 본 서버에서 받아오는 구조
//=> 동적 크롤링을 사용해야함
public class Test01 {
	public static void main(String[] args) {
		
		String url="http://camelmart.godomall.com/";
		//웹페이지에서 index란 초기페이지를 의미한다.
		
		Connection conn = Jsoup.connect(url);
		//Jsoup으로 url 연결시도
		//연결객체가 봔환됨
		//Jsoup은 JAVA의 기본 패키지가 아니다. 라이브러리 === 소스코드모음집이 아니다.	
		//Jsoup을 별도로 설치해야합니다.
		// .jar java아카이브 == java압축파일 == 소스코드모음집 == 라이브러리 == 패키지	
		try {
			Document doc = conn.get();
//			거기에 해당하는요소들 = doc.select(찾고싶은데이터 이름)//css스크립트 // css쿼리 //css 이름을 입력하면 거기에 해당하는 요소들을 반환하겠다는 의미 이다 !! 
			Elements elems=doc.select("strong.item_name");
			for(Element elem:elems) {
				System.out.println(elem.text());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("연결중 에러발생");
			e.printStackTrace();
		}
		//Document란 ??
		//웹페이지 화면 문서를 의미함
	}

}
