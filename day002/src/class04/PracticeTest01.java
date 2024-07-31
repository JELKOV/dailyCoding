package class04;

import java.util.Scanner;

//  🧷 문제 1
//
//  정수를 입력받습니다. 
//  입력된 정수가 짝수라면 총합에 더해주세요.
//  0 이하가 입력되면 멈춥니다. 
//
//  멈추고서 최종 총합을 출력해주세요.


public class PracticeTest01 {

	public static void main(String[] args) {
		
	   Scanner sc = new Scanner(System.in);
	   // 사용자로부터 정수를 입력받기 위해 Scanner를 생성합니다. 
	   
	   System.out.println("정수를 입력받아 최종 총합을 출력하는 프로그램입니다.");
	   // 어떤 프로그램인지 설명을 해줍니다. 
	      	
	   // 입력된 정수가 짝수라면 총합에 더해주세요.
	   // 0 이하가 입력되면 멈춥니다.
	   
	   // 총합에 더해 달라고 했는데 총합을 뜻하는 정수가 없기 때문에  
	   int sum = 0;
	   // 총합을 뜻하는 정수를 만들었습니다. 
	
	while (true) {
    // 반복 횟수나 범위가 나와있지 않기 때문에 while문을 사용합니다. 
		System.out.print("정수를 입력해주세요 >> ");
		   int num = sc.nextInt();
		// 정수를 생성하고 사용자로부터 정수를 입력 받습니다. 
		
		if (num <= 0) {  // 0 이하가 입력되면 
			break;   // 멈춥니다. 
		}
	    
		if (num % 2 == 0) { // 짝수라면     else는 들어가도 상관없는데 위의 break가 
		   sum += num;  // 총합에 더해주세요 .  무한루프의 탈출조건임을 더 확실하게 알게 하게 위해서 
		                                 // else를 쓰지 않습니다.
		}
		 
	}
	
	// 0이 입력되면 무한루프가 멈추며 최종 총합이 출력됩니다. 
	System.out.println("정수들의 최종 총합은 "+sum+"입니다.");
	
	

	}

}
