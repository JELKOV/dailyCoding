package class01;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("홀짝을 출력하는 프로그램입니다");
		//프로그램에 대한 설명
		System.out.print("정수를 입력해주세요. >>"); // >> 이거는 왜 쓰는걸까 ?
		int num = sc.nextInt();
		if(num%2 == 1) {
			System.out.println("홀수입니다");
		}
		if(num%2 != 1) {
			System.out.println("짝수입니다");
		}
		//양자택일 일경우
		if(num%2==1) {
			System.out.println("홀수입니다");
		}
		else {
			System.out.println("짝수입니다");
		}
		sc.close();
	}

}
