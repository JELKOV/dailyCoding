package class03;

import java.util.Scanner;

// 정수를 3개 입력받아주세요.
// a=10 b=8 c=5
// a=5 b=8 c=10
// a,b,c가 오름차순이 되도록 데이터를 변경해주세요.
//   >>> 정수를 2개 입력받아주세요

public class ScannerThree {

	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 1 입력 >> ");
		int a = sc.nextInt();
		
		System.out.print("정수 2 입력 >> ");
		int b = sc.nextInt();
		
		System.out.print("정수 3 입력 >> ");
		int c = sc.nextInt();
		
		// a가 가장 작아야 하니까 
		// a가 b보다 작아?  아니라면  a <-> b
	
		
		if (a>b) {
			int tmp = a;
			a= b;
			b = tmp;
		}
		
		// a가 c보다 작아?  아니라면  a <-> c
		
		if (a>c) {
			int tmp = a;
			a= c;
			c = tmp;
		}
		
//		b가 c보다 작아? 아니라면 b <-> c
		
		

		if (b>c) {
			int tmp = b;
			b= c;
			c = tmp;
		}
		
		
		
		
		
		
		
		
		
	}

}
