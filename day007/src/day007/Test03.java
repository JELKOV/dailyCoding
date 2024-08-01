//package day007;
//
//class Shape {
//	String name; // 이름
//	double area; // 넓이
//	String color;// 색
//
//	Shape(String name) { // 이름 강제성을 가지고 // 생성자 오버로딩하고
//		this(name, "검정"); // this 재사용
//	}
//
//	Shape(String name, String color) {
//		this.name = name;
//		this.color = color;
//		this.area= 0.0; // 멤버 변수 초기화
//	}
//
//	void draw() {
//		System.out.println(this.color + "색" + this.name + "모양은" + this.area + "만큼의 넓이 입니다");
//		// ㅇㅇ 색 ㅇㅇ 모양은 ㅇㅇ.ㅇㅇ 만큼의 넓이
//	}
//}
//
//class Circle extends Shape {
//	int radius;// 반지름
//	static final double PI = 3.14;
//
//	Circle(String name, String color) {
//		super("원", color);
//		this.radius = 1;
//		super.area = circleArea(this.radius);
//		super.draw();
//	}
//
//	Circle(String name, String color, int radius) {
//		super("원", color);
//		this.radius = radius;
//		super.area = circleArea(this.radius);
//		super.draw();
//	}
//
//	double circleArea(int radius) {
//		return radius * radius * Circle.PI;
//	}
//}
//
//class Rectangle extends Shape {
//	int x;
//	int y;
//
//	Rectangle(int x) {
//		super("사각형");
//		this.x = x;
//		this.y = x;
//		super.area = rectangleArea(this.x, this.y);
//		super.draw();
//	}
//
//	Rectangle(int x, String color) {
//		super("정사각형", color);
//		this.x = x;
//		this.y = x;
//		super.area = rectangleArea(this.x, this.y);
//		super.draw();
//	}
//	Rectangle(int x, int y) {
//		this(x, y, "검정");
//	}
//
//	Rectangle(int x, int y, String color) {
//		super("직사각형", color);
//		this.x = x;
//		this.y = y;
//		super.area = rectangleArea(this.x, this.y);
//		super.draw();
//	}
//
//	double rectangleArea(int x, int y) {
//		return x * y;
//	}
//}
//
////1. 이름이 없는 모양 객체는 없음 -> 강제성
////2. 색을 별도로 지정하지 않으면 기본 색은 검정
////3. 원의 경우, 반지름을 별도로 지정하지 않으면 기본 1
////4. new 사각형(10)== 정사각형
////5. new 사각형 (10,20) == 직사각형
//public class Test03 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Circle c1 = new Circle("원", "초록", 3);
//		Rectangle r1 = new Rectangle(3,"초록");
//		Rectangle r2 = new Rectangle(3, 5,"파란");
//	}
//
//}
//// 인자를 무엇을 넣어야하는지
//// 그리고 코드를 어떻게 단축시킬것인지
//// 
