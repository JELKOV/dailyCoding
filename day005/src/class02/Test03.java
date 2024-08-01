package class02;

import java.util.Scanner;

//객체 지향 코딩
//기본단위 ==class

// 학생에 대한 정의를 하기위해 존재하는 class
// 이 객체의 앖을 "식별"할수 있는 데이터가 있니 ?
// == PK

class Student{ // class는 객체지향코드의 기본단위이며 !! 자료형이다 !! 
	int num; // 학번 .PK역활 !! 겹치지 않는게 반드시 있어야 한다. 
	String name; 
	int score;
	char grade;
	Student(){
		System.out.println("숨겨진 생성자");
	}
}
// class는 배열은 아닌이유 관련성이 없어서 !!

//Student 라는 자료형이 있습니다.
//[학번, 이름,점수, 등급]을 저장할수 있습니다.

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// new -> 개발자 힙 메모리 영역
		int num = 0; //초기화x == 값 저장x
		int [] datas = new int[5]; // new -> 개발자 힙 메모리 영역
		System.out.println(num);
		System.out.println(datas[0]);
		
		//힙 메모리를 사용했기 때문에
		//기본적으로 int 0 double 0.0 String null ...
		//초기화를 보장해준다.

		Student stu1 = new Student();
		System.out.println("로그");
		//class 타입의 객체들은 new 연사자 활용 !!
		//클래스 변수명 = new 생성자();
		//클래스로 만든 변수 == 객체(instance, 인스턴스); 
	}

}
