package class01;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("정수를 1개 입력받아서 10의 약수인지 알려주는 프로그램입니다");
		System.out.print("정수입력>>");
		int num = sc.nextInt();
		if(num==0) {
			System.out.println("0으로는 나누기를 할수 없습니다.");
			return;//긴급종료
		}
		if(10%num ==0) {
			System.out.println("ok");
		}
		else {
			System.out.println("X");
		}
		sc.close();
	}

}
