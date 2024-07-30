package class03;

import java.util.Scanner;

public class Test07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2.정수를 3개 입력받아주세요. 총합 평균 .xx 소수점까지
		Scanner sc = new Scanner(System.in);
        System.out.println("첫번째정수");
		int num1 = sc.nextInt();
		System.out.println("두번째정수");
        int num2 = sc.nextInt();
        System.out.println("세번째정수");
        int num3 = sc.nextInt();
        
        int sum = num1 + num2 + num3;
        //입력 받은 정수들의 총합을 데이터 저장
        double avg=  (double) sum/3;
        //입력 받은 정수들의 평균을 실수의 데이터로 저장
        System.out.println("합->" +sum);
        System.out.println("평균->"+avg);
        sc.close();
	}
	
	//정수를 3개 입력받아서 총합과 평균을 출력
	//int 변수x 3
	//총합과 평균을 출력
	//int변수 double 변수
	//결론 int 4 double 1
	//int num1 num2 num3 int sum double age
	// 연산자가 총 2개가 있으면 순서대로 처리한다 !!
	// 산술연산자 대입연산자
	// 계산하는 중간에 double을 건다
	// double avg = sum/3.0 도 가능 

}
