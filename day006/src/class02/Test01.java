package class02;

class Point{
	int x;
	int y;
	Point(){
		this(0);// 생성자 함수 호출
		System.out.println("로그1");
//		this.x=0;
//		this.y=0;
	}
	Point(int x){
		this(x,x);//생성자 함수 호출
		System.out.println("로그2");
//		this.x=x;
//		this.y=x;
	}
	Point(int x, int y){
		this.x=x;
		this.y=y;
		System.out.println("로그3");
	}
	//1. 가장 인자가 많은 생성자 함수를 구현하고
	//2. 나머지 생성자 함수가 1을 재사용한다.
	
	//그냥 일반 오버로딩
	void move() {
		this.x++;
		this.y++;
	}
	void move(int x) {
		this.x+=x;
		this.y+=x;
	}
	void printInfo() {
		System.out.println("("+this.x+","+this.y+")");
	}
}

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1= new Point();
		Point p2= new Point(10);
		Point p3= new Point(1,2);
		p2.move(100);
		p2.printInfo();

	}

}
