package class01;

class Product{
	int num; // pk 상품번호
	String name;
	int cnt;
	int price;
	//생성자 오버로딩ㅂ
	Product(int num, String name){
		//멤버변수 초기화 -> 생성자 함수가 담당을 한다.
//		this.num=시스템에서 부여하는 값;
//		this.name =상품명;
//		this.cnt=재고;
//		this.price =가격;
		this.num=num;
		this.name =name;
		this.cnt=0;// 재고
		this.price =0; // 특정할인기간
	}
	//자바에서는 함수명이 중복이 된다 
	//함수 메서드 오버로딩 !! 반드시 알아두고 요약해보기 !! 
	//메서드 시그니처(매서드이름/매개변수리스트)가 다르다면 같은 함수명을 사용해도 이를 헝용한다는 특징
	//함수명 중복정의 허용
	//비슷하거나 유사하거나 같은 기능일때의 사용
	//ex)println() 함수 오버로딩
	Product(int num, String name, int cnt, int price){
		//재고나 가격을 주고 싶을때
		this.num=num;
		this.name =name;
		this.cnt=cnt;// 재고
		this.price =price; // 특정할인기간
	}
}

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product p1 = new Product(1001,"운동화");
		Product p2 = new Product(1001,"운동화",10, 4000);
	}

}
