package class01;

import java.util.Scanner;

//  정수 2개를 입력받아주세요. 
//
//  연산자 1개를 입력받아주세요. (연산자는 + , -만 사용합니다.)
//
//  전체 계산 결과를 출력해주세요. 
//
//  10 20 +        100 19 -
//
//  10 + 20 = 30   100 - 19 = 81 

public class ScannerQuestion3 {

	public static void main(String[] args) {
	    
		Scanner sc = new Scanner(System.in);
		int num1, num2;  // 사용자에게 입력받을 정수 
		String op; // 연산자 
		// 문자열은 일반 변수(원시타입)가 아니고 
		// 연산자는 일반 변수만 계산할 수 있다!
		// 연산자로는 객체를 계산할 수 가 없다.
		int res = 0;  // 결과 
		
		
	    
		System.out.println("정수2개와 연산자를 입력받아 결과를 출력하는 프로그램입니다.");
	    System.out.print("정수 1 입력 >> ");
	    num1 = sc.nextInt();
	    
	    System.out.print("정수 2 입력 >> ");
	    num2 = sc.nextInt();
	    
	    // 버퍼 비우기 
	    sc.nextLine();
	    
//	    System.out.print("로그 01");  // 코드 흐름 파악 로그 
	    System.out.print("연산자 입력 (+ or -) >> ");
	    op = sc.nextLine();  // 버퍼에 이미 전달할 값이 남아있어서 사용자가 입력했구나 !
	                         // 라고 착각을 하게 되버린다. 
	    
	 // op = sc.next(); 공백을 제외한 모든 String을 입력받는 함수 
	 // 여기서 공백이란 띄어쓰기처럼 비는 공간을 의미한다. 
	 // 데이터 확인 로그 
//	    System.out.println("op = ["+op+"} ");
	    
	    
		
		
		// 정수 2개를 입력받고 
		// 연산자 1개를 입력받음
		
		// 정수 + 연산자 + 정수 조합하기 !
		
		// 연산자가 + 였다면 
		// 정수 + 정수 
	    if(!(op.equals("+") || op.equals("-"))) { // + -가 아닌 연산자를 입력했다면 
	    	//  + 이거나 - 여야 하는데 , 둘다 아니라면 : !(op=="+" || op=="-")
	    	//  + 도 아니고 - 도 아니면 : 
	    	// 유효성 검사 
	    	res = 0;
	    }
	    
	    else if (op.equals("+")) {
	    	res = num1 + num2;
	    }
	    
	    else {
	    	res = num1 - num2;
	    }
		
		// 연산자가 - 였다면 
		// 정수 - 정수
		
		// 전체 계산 결과를 출력 
	    System.out.println(num1 +" "+ op +""+ num2 +" = "+ res);
		
		

	}

}
