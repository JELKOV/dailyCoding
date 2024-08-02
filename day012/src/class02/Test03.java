package class02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//Point Class가 있다.
//점은 x,y 좌표를 속성으로 갖는다.
//x,y좌표위치를 정하여 point 객체를 생성한다.
//101번 점 p1 102번 점 p2를 생성하여
//map 컬렉션으로 관리해주세요

class Point {
	//한글코딩
	//1. Point class를 생성한다.
	//2. 멤버변수 x,y를 지정한다.
	private int x;
	private int y;
	
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	


	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	@Override
	public String toString() {
		return "Point [x=" + getX() + ", y=" + getY() + "]";
	}
	

	
}
public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Map<Integer, Point> map = new HashMap<Integer, Point>();
		
		int PK =101;
		map.put(PK++,new Point(3,10));
		map.put(PK++,new Point(4,7));
//		Point p1 = new Point(3,10);
//		Point p2 = new Point(4,7);
//		
//		map.put(101, p1);
//		map.put(102, p2);
		
		System.out.println(map);
	

	}

}
