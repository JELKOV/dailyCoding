package day007;

class Shape {
	String name;
	double area;
	String color;

	Shape(String name) {
		// 반드시 넣어야 되니깐 name  설정안했을때는 검정
		this(name, "검정");
		System.out.println("부모로그1");
	}

	Shape(String name, String color) {
		this.name = name;
		this.color = color;
		this.area = 0.0;
		System.out.println("부모로그2");
	}

	void draw() {
		System.out.println(this.color + "색 " + this.name + "모양 넓이 : " + this.area);
	}

	void setArea() {
		System.out.println("Shape에서 호출한 setArea()");
	}
}

class Circle extends Shape {
	int radius;
	static final double PI = 3.14; // final == 상수화, static == 클래스변수 => 바로 초기화

	Circle() {
		this(1, "검정");
	}

	Circle(String color) {
		this(1, color);
	}

	Circle(int radius) {
		this(radius, "검정");
	}

	Circle(int radius, String color) {
		super("원", color);
		this.radius = radius;
		this.setArea();
	}

	@Override
	void setArea() {
		System.out.println("Circle에서 호출한 setArea()");
		this.area = this.radius * this.radius * Circle.PI;
	}
}

class Rectangle extends Shape {
	int x;
	int y;

	Rectangle(int x) {
		this(x, "검정");
		System.out.println("로그1");
	}

	Rectangle(int x, String color) {
		super("정사각형", color);
		this.x = x;
		this.y = x;
		this.setArea();
		System.out.println("로그2");
	}

	Rectangle(int x, int y) {
		this(x, y, "검정");
		System.out.println("로그3");
	}

	Rectangle(int x, int y, String color) {
		super("직사각형", color);
		this.x = x;
		this.y = y;
		System.out.println("로그4");
		this.setArea();
	}

	// 오버로딩 : 함수명 중복정의 허용
	// 오버라이딩 : 메서드 재정의
	@Override // @ 어노테이션,애너테이션
	void setArea() {
		System.out.println("Rectangle에서 호출한 setArea()");
		this.area = this.x * this.y;
	}
}

/*
 * [요구사항대로 문제해결하기] 모양 Shape String name 이름 double area 넓이 String color 색 void
 * draw() ㅁㅁ색 ㅁㅁ모양은 ㅁㅁ.ㅁㅁ만큼의 넓이 원 Circle int radius 반지름 double PI 3.14 원주율 사각형
 * Rectangle int x,y 가로,세로
 * 
 * 요구사항 1. 이름이 없는 모양 객체는 없음 2. 어떤 모양의 색을 별도로 지정하지않으면 기본 색은 검정 3. 원의 경우, 반지름을 별도로
 * 지정하지않으면 기본 1 4. new 사각형(10) == 정사각형 5. new 사각형(10,20) == 직사각형
 */
public class Test05 {
	public static void main(String[] args) {

//		Shape s = new Shape("모양");
//		s.setArea();
//
//		Circle c = new Circle(1);
//		c.setArea();
//		c.draw();

		Rectangle r = new Rectangle(10);
//		r.setArea();
		r.draw();

		// 객체지향의 핵심
		// 같은 메서드를 수행시켜도
		// 다른 주체자가 수행했다면
		// 다른 결과가 나온다.

	}
}
