package class04;

import java.util.Scanner;

//
//   🧷 문제 5
//
//   1 ~ 100사이의 정수만 1번 입력합니다. 입력한 정수의 약수들을 모두 출력해주세요. 
public class practiceTest05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 정수를 입력받아야 하기에 Scanner를 생성합니다. 
		
	    System.out.println("1 ~ 100사이의 정수를 한번 입력하여 입력한 정수의 약수들을 모두 출력하는 프로그램 입니다.");
		// 어떤 프로그램인지 설명하였습니다. 
	    
	  while(true) {
		  System.out.print("1 ~ 100사이의 정수를 입력하시오 >> ");
		    int num = sc.nextInt();
		    if(1 <= num && num <= 100) {
		    	break;
		    }
	  }     // break가 종료조건 없이 작성된 경우
	        // 그 기능은 태생이 반복을 안하는 코드다!
	
		    // 1 ~ 100사이의 정수를 출력합니다.
		    
		  // 입력한 정수들의 약수들을 모두 구하시오 
		    
		    
		    // 1 ~ 100이라는 범위가 나와있어서 for문을 사용하였고 
//		   for(int i = 1; i <= num; i++) {
//			  if(num % i == 0) { // 서로 나누어 떨어지면 약수이니까 
//				  System.out.println(i); // 나누어 떨어지는것만 출력하고 
//			  }
//			  else {
//				  continue; // 다른 숫자들은 건너뛰기 
//				  
//			  }
//		   }
		   
	     
		    
		   
		    
		  

	    
	    

	}

}
