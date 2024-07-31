package class04;

import java.util.Scanner;

//   🧷 문제 3

//   정수를 2개 입력받아서 오름차순으로 출력해주세요.
//
//   ex) a = 3 , b = 5  3 4 5
//
//       a = 10, b = 8  8 9 10

public class PracticeTest03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 정수를 입력받기 위해서 Scanner를 생성합니다. 
		
		System.out.println("정수 2개를 입력받아서 오름차순으로 출력하는 프로그램을 작성하시오.");
		// 어떤 프로그램인지 설명해줍니다. 
	    
		while (true) {
	    // 오름차순은 어떤 순서로 어떻게 출력될지 알 수 없기때문에 while문을 사용합니다.
			System.out.print("첫번째 정수를 입력하시오 >> ");
			int a = sc.nextInt();
			System.out.print("두번째 정수를 입력하시오 >> ");
			int b = sc.nextInt();
			// 정수 2개를 입력받아야 하니까 정수를 2개 만들어줍니다
		    
			if(a > b) { // a가 b보다 클때 
				for(int i = b; i <= a; i++) {
					System.out.println(i);
					// b부터 a사이에 있는 숫자들 내림차순 
				}
			}
			
			else if(b > a) { // b가 a보다 클때 
				for(int i = a; i <= b; i++) {
					System.out.print(i);
					// a부터 b사이에 있는 숫자들 내림차순 
				}
			}
		    break;
		// if문안에 있는 두 개의 for문중 한개가 다 실행하였으면 무한루프 종료 
		
//		 int min; 
//		 
//		 if(a < b) {
//			 min = a;
//		 }
//		    
//		 else {
//			 min=b;
//		 }
//		    
//		  int max = a > b ? a : b; // 삼항연산자   
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		}
		

	}

}
