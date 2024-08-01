package class01;

class Circle{
	//반지름
	//넓이 = 반지름 *	반지름 *pi
	String name;
	int radius;//반지름
	double area;//넓이
	static final double PI=3.14; //원주율 ( 키워드화-대문자: 세상에 있는 값)
	//이변수가 모두 공유한다. => 클래스 변수
	//클래스변수 초기화는 생성자함수(멤버변수만 초기화 하니깐) 말고 위에다가 한다.
	//final키워드 해당변수의 값이 절대 변경되지 않는것 == 상수화
	//객체마다 고유한 값을 가지면 그건 멤버변수
	
	
	//객체 c1의 값을 변경해도 또다른 객체 c2의 값에 영향을 주지 못하고 있다.
	//why? 두개가 독립적이니깐 !! 
	//문제 ? 메모리 과부하
	//PI는 객체와 무관하기 때문에 static을 써야한다.
	//주인이 객체 x 클래스 O
	
	Circle(String name, int radius){
//		Circle.PI=3.14;
		this.name = name;
		this.radius=radius;
		this.area=this.radius*this.radius*Circle.PI;
	}
}
public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c1 = new Circle("원01",1);
		Circle c2 = new Circle("원02",10);
		
		//파이 강제 변화 
//		c1.PI =2.1;
		//c1파이만 바뀐다
		//다른영역에 존재한다.
		System.out.println(c1.PI);
		System.out.println(c1.area);
		
		System.out.println(c2.PI);
		System.out.println(c2.area);

	}

}
