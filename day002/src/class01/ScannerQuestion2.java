package class01;

import java.util.Scanner;

 //  정수를 3개 입력받아서 
 //  int 3개가 필요함 

 //  총합과 평균을 출력 
 //  int 변수, double 변수

public class ScannerQuestion2 {

	public static void main(String[] args) {
		
		// 정수를 3개 입력받아서 
		// int 3개가 필요함 
		
		// 총합과 평균을 출력 
		// int 변수, double 변수 
		
		// 결론 int 4개와 double 1개가 필요함 
		
		int num1, num2, num3; // 사용자에게 입력받을 값을 저장하는 공간 
		int sum; // 총합 
		double avg; // 평균 
		
        // 사용자에게 정수 3개 입력받는 코드 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 3개를 입력받아 총합과 평균을 구하는 프로그램입니다. ");
		System.out.print("정수 1 입력 >> ");
		num1 = sc.nextInt();
		
		System.out.print("정수 2 입력 >> ");
		num2 = sc.nextInt();
		
		System.out.print("정수 3 입력 >> ");
		num3 = sc.nextInt();
		
		// 입력받은 정수들을 총합 데이터에 저장하는 코드 
		
		sum = num1 + num2 + num3;
		
		// 총합데이터 / 3해서 평균을 도출하는 코드 
		avg = sum / 3.0;
		
		System.out.println("총합 "+sum);
		System.out.println("평균 "+avg);
	}

}
