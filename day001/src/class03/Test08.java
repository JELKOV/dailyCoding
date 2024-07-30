package class03;

import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//3.정수 2개를 입력받아서 연산자 1개를 입력 전체 계산 결과 (연산자 +-)	
//		Scanner sc = new Scanner(System.in);
//		int num1 = sc.nextInt();
//        int num2 = sc.nextInt();
//        System.out.println("연산자를 입력하세요 (+, -):");
//		char operator = sc.next().charAt(0); // 연산자 입력 받기
//		switch (operator) {
//        case '+':
//            System.out.println("+" + (num1 + num2));
//            break;
//        case '-':
//            System.out.println("-" + (num1 - num2));
//            break;
//            }
//		
//	}
	// 정수 2개를 입력받고
	// 연산자 1개를 입력 받음
	
	// 정수 + 연산자 + 정수
	// 연산자가 + 였다면
	//연산자 +연산자
	// 연산자가 - 였다면
	// 정수- 정수
	Scanner sc = new Scanner(System.in);
	int num1,num2; // 사용자에게 입력받을 정수
	String op; // 연산자
	//문자열은 일반 변수가 아니고 원시타입 ! 
	//연산자는 일반 변수만 계산할수 있다.
	//연산자로는 객체를 계산할수가 없다. 
	int res;// 결과
	
	System.out.println("정수 2개를 입력하여 결과를 출력");
	System.out.print("정수 1입력");
	num1=sc.nextInt();
	System.out.print("정수 2입력");
	System.out.print("로그01");
	num2=sc.nextInt();
	System.out.print("연산자 입력");
	sc.nextLine();//버퍼 공간 비우기
	System.out.print("로그02");
	op= sc.nextLine();
	System.out.print("op =["+op+"]");// 버퍼 이미 전달 할 값이 남아있어서 사용자가 입력했다고 착각함!
	// 유효성 검사
	if(!(op.equals("+")||op.equals("-"))) {
		//> +이거나 -여야하는데 둘다 아니라면!(op=="+"||op=="-")
		//> +도 아니고 -도 아니면 op!="+" && op!="-"
		// 유효성검사
		res=0;
		System.out.print("로그03");
	}
	
	else if(op=="+") {
		res=num1+num2;
		System.out.print("로그04");
	}
	else {
		res=num1-num2;
		System.out.print("로그05");
	}
	
	System.out.println(num1+" "+op+" "+num2+" "+res);
	}
}
