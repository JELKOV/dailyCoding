package class04;

import java.util.Scanner;

//    🧷 문제 4
//
//    정수를 5번 입력합니다. 
//    모든 입력이 끝난 후, 입력한 정수중에서 가장 큰 값을 출력해주세요.
//
    public class PracticeTest04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 정수를 입력해야 되니 Scanner 생성 
		
	    System.out.println("정수를 5번 입력하여 입력한 정수중 가장 큰 값을 출력하는 프로그램 입니다.");
        // 어떤 프로그램인지 설명합니다. 
	   
	   
	 while(true) {
		 // 어떤 값이 가장 클지 모르니까 while문으로 작성합니다.
		 
		 System.out.print("첫번째 정수를 입력하세요 >> ");
		   int num1 = sc.nextInt();
		   
		   System.out.print("두번째 정수를 입력하세요 >> ");
		   int num2 = sc.nextInt();
		   
		   System.out.print("세번째 정수를 입력하세요 >> ");
		   int num3 = sc.nextInt();
		   
		   System.out.print("네번째 정수를 입력하세요 >> ");
		   int num4 = sc.nextInt();
		   
		   System.out.print("다섯번째 정수를 입력하세요 >> ");
		   int num5 = sc.nextInt();
		   // 사용자로 부터 정수를 총 5개 입력 받습니다. 
		   
//		if(num1이 제일 크다면 ) {
//			num1 출력 
//		}
//		else if(num2이 제일 크다면) {
//			num2 출력 
//		}
//		
//		else if(num3이 제일 크다면) {
//			num3 출력
//		}
//		
//		else if(num4이 제일 크다면) {
//			num4 출력
//		}
//		
//		else if(num5이 제일 크다면) {
//			num5 출력
//		}
//		  
		   int fight1 = 0;
		   int fight2 = 0;
		   int final1 = 0;
		  // 대결에서 이긴 숫자를 저장할 저장공간을 만들어줍니다. 

		  if(num1 > num2) { // num1이 num2보다 크다면 
			  fight1 = num1; // num1의 값을 fight1에 저장한다. 
		  }
		  else if (num1 < num2){ // num1이 num2보다 작다면 
			  fight1 = num2;// num2의 값을 fight1에 저장한다. 
		  }
		  
			 
		  if(num3 > num4) { // num3이 num4보다 크다면 
			  fight2 = num3;  // num3의 값을 fight2에 저장한다.
		  }
		  else if (num3 < num4){ // num4가 num3보다 크다면 
			  fight2 = num4; // num4의 값을 fight2에 저장한다.
		  }
		  
		  if(fight1 > fight2) { // fight1이 fight2보다 크다면 
			  final1 = fight1; // fight1의 값을 final1에 저장한다.
		  }
		  
		  else if(fight2 > fight1) { // fight2가 fight1보다 크다면 
			  final1 = fight2; // fight2의 값을 final1에 저장한다.
		  }
		  
		  if(final1 > num5) {   // final1이 num5보다 크다면 
			  System.out.println("정수들 중 가장 큰 값은 " + final1 + "입니다."); // final1을 출력한다. 
			  break;  // while문을 마무리한다. 
		  }
		  else if(num5 > final1) { // final1이 num5보다 크다면 
			  System.out.println("정수들 중 가장 큰 값은 " + num5 + "입니다."); // num5를 출력한다. 
			  break; // while문을 마무리한다. 
		  }
	   
		  // pivot 기준 
//		   System.out.println("정수 입력 >> ");
//		   int pivot = sc.nextInt();
//		   
//		   for(int i =0; i<4; i++) {
//			   System.out.println("정수입력 >> ");
//			   int num = sc.nextInt();
//		   }
//		   
//		   if(pivot < num) {
//			   pivot = num;
//		   }
//	   System.out.println("최대값은 " + pivot +"입니다.");
//	   
	}

}}
