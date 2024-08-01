package day007;

class Point {
	int x;
	int y;

//	Point(){
//		
//	}
	Point(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("부모생성자가 호출됨");
	}

	void printInfo() {
		System.out.println("(" + this.x + "," + this.y + ")");
	}

	void move() {
		this.x++;
		this.y++;
	}
}
//클래스를 상속받으면
// 해당 클래스의 코드를 전부 재사용할수 있다 !! 

class ColorPoint extends Point { // 자식 extends 부모
	String color;

	// 부모의 생성자를 바꿧는데 자식이 에러가 생긴다
	ColorPoint(String color, int x, int y) {
		// 자식은 가장먼저 하는 행동이 있다.
		// 가장먼저 호출하는 것이 있다.
		// 부모클래스의 기본 생성자를 호출한다.
		// 1. 부모클래스에 기본 생성자를 선언 (정의) -> 이렇게 먼저 하면 안된다.
		// => 먼저 작성된 코드를 나중에 작성되는 코드 때문에 변경하면 안된다. (부모클라스가 먼저 생겨났기 때문에)
		// => 기본생성자를 만들면 강제성이 없어진다 !!

		// 2. 부모한테 기본 생성자 없으면 ?? 다른 생성자를 가지고 있는데 !! 그걸 대신사용함
		super(x, y);
		// 자식클래스의 객체를 만들때에는
		// 부모클래스의 생성자 선 호출 -- >> 자식 클래스의 생성자 호출
		this.color = color;
//		this.x =x;
//		this.y =y;		
		System.out.println("자식생성자가 호출됨");
	}

	@Override
	void printInfo() {
		// TODO Auto-generated method stub
		System.out.println(this.color+"(" + this.x + "," + this.y + ")");
	}

	
	
}

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(10, 10);
		p1.printInfo();
		p1.move();
		p1.printInfo();

		ColorPoint p2 = new ColorPoint("초록", 1, 2);
		p2.printInfo();
		p2.move();
		p2.printInfo();
		
		ColorPoint cp = new ColorPoint("분홍", 1, 2);
		cp.printInfo();

	}

}
