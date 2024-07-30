package class01;

import java.util.Scanner;

//2. test02라는 함수가 있습니다.
//함수를 실행하게되면, 사용자로부터 정수를 5번 입력받을수 있게됩니다.
//그리고 입력한 정수들의 총합을 화면에 출력해줍니다.
//test02를 작성해주세요.
//1유형
public class Test08 {
	public static void test02() {
		System.out.println("정수를 5개 입력해주세요");
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			System.out.println((i+1)+"번째 정수를 입력");
			int number = sc.nextInt();
			sum += number;
		}
		System.out.println("총합은=" + sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test02();

	}

}
