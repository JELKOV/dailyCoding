package view;

import java.util.Scanner;

public class CalcView {
	static Scanner sc=new Scanner(System.in);
	//멤버 변수 만들면 ->>getter, setter
	//              ->>멤버변수 초기화 == 생성자
	//Scanner는 하나만 있으면 되는 애라서 할필요는 없다. !!클래스 변수로 전역 static으로 선언!!
	public void printIntInfo() { // 사용자에게 보여주는 내용은 void 
		System.out.println("정수 1개를 입력하세요");
		System.out.println(">> ");
	}


	public void printOpINfo() { // 사용자에게 보여주는 내용은 void 
		System.out.println("연산자를 입력하세요.");
		System.out.println("단 연산자는 +,-,x만 지원됩니다.");
		System.out.println(">> ");
	}

	public void printResult(int num1,String op,int num2,int result) { // 사용자에게 보여주는 내용은 void 
		System.out.println(num1+" "+op+" "+num2+" = "+result+"입니다."); // result값을 프론트단에서 계산하면 안된다 !!!!! 
	}

	public int inputInt() {// 사용자가 값을 입력하는 애들은 output이 있다.
		int num=sc.nextInt();
		return num;
		// 사용자가 써야 되니깐 리턴 해야된다.
	}

	public String inputOp() {// 사용자가 값을 입력하는 애들은 output이 있다.
		String op;
		while(true) {
			op=sc.next();
			if(op.equals("+")||op.equals("-")||op.equals("x")) {
				break;
			}
			System.out.println("다시입력해주세요");
			System.out.println(">> ");
		}
		return op;
	}




}
