package class02;

import java.util.Scanner;
//Scanner는 java.util 안에 있다.
//Ctrl + Shift +O
//자동 import 지원

public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);// 대문자 스캐너는 클라스 추신 
		System.out.print("문자열입력>>");
		String str=sc.nextLine();

		System.out.print("정수입력>>");
		int i = sc.nextInt();

		System.out.print("실수입력>>");
		double d = sc.nextDouble();

		System.out.println("str=" +str);
		System.out.println("i="+i);
		System.out.println("d="+d);
		sc.close();
	}
}
