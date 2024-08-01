package class01;

import java.util.Scanner;

//Object Java의 최상위 클래스

// [다형성]
class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("   로그 : 부모 생성자 호출됨");
	}

	void move() {

	}

	void move(int x) {

	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + this.x + "," + this.y + ")";
	}
	
}

class ColorPoint extends Point {
	String color;

	ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
		System.out.println("   로그 : 자식 생성자 호출됨");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.color +"(" + this.x + "," + this.y + ")";
	}
}

public class Test02 {
	public static void main(String[] args) {
		
		//정리 println()객체를 넣을수가 있다.
		
//		Point p = new Point(2,2);
//		System.out.println(p);

		Scanner sc = new Scanner(System.in);
		Point[] datas = new Point[3];
		datas[0] = new Point(1, 2);
		datas[1] = new ColorPoint(10, 20, "파랑");
		int cnt = 2; // 현재 저장된 점의 개수

		while (true) {
			System.out.println("1. 점 추가");
			System.out.println("2. 전체 점 목록 출력");
			System.out.println("3. 점 움직이기");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 입력 >> ");
			int menu = sc.nextInt();
			if (menu == 0) {
				break;
			} else if (menu == 1) {
				System.out.println("1. 점");
				System.out.println("2. 색깔점");
				System.out.print("번호 입력 >> ");
				int num = sc.nextInt();
				if (num == 1) {
					System.out.print("x 좌표 입력 >> ");
					int x = sc.nextInt();
					System.out.print("y 좌표 입력 >> ");
					int y = sc.nextInt();
					datas[cnt++] = new Point(x, y);
				} else {
					System.out.print("x 좌표 입력 >> ");
					int x = sc.nextInt();
					System.out.print("y 좌표 입력 >> ");
					int y = sc.nextInt();
					System.out.print("색 입력 >> ");
					String color = sc.next();
					datas[cnt++] = new ColorPoint(x, y, color);
				}
			} else if (menu == 2) {
				for (int i = 0; i < cnt; i++) {
//					datas[i].printInfo();
					// 점 객체가 printInfo()를 수행합니다.
					// 점 --->> (x,y)
					// 색깔점 --->> 색(x,y)
					// "동적바인딩"이 발생했다!
					// "다형성"을 실현할수있다!
					// == 똑같은 메서드를 수행시키더라도
					// 메서드 수행 주체가 어떤 객체냐인지에따라
					// 다른 메서드가(오버라이딩된 메서드가) 수행되는 것
				}
			} else if (menu == 3) {
				//좌표를 새로 입력하고 저장한다.

			} else {
				System.out.println("잘못된 메뉴입니다.");
			}
		}

	}
}
