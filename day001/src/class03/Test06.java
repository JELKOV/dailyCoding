package class03;

import java.util.Scanner;

public class Test06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.정수를 3개 입력받아주세요.
		// a=3 b=8 c= 5 abc가 오름차순이되도록
		
		//2.정수를 3개 입력받아주세요. 총합 평균 .xx 소수점까지
		//3.정수 2개를 입력받아서 연산자 1개를 입력 전체 계산 결과 (연산자 +-)
		Scanner sc=new Scanner(System.in);
		System.out.println("입력받은 세개의 값을 오름차순으로 정리하라");
		System.out.print("a입력->");
		int a= sc.nextInt();
		System.out.print("b입력->");
		int b= sc.nextInt();
		System.out.print("c입력->");
		int c= sc.nextInt();
//		a가 가장 작아야 하니까
//		a가 b보다 작아? 아니라면 a<->b
		if(a>b) {
			int temp=a;
			a=b;
			b=temp;
		}
		//a가 c보다 작아? 아니라면 a<->c
		if(a<c) {
			int temp=a;
			a=c;
			c=temp;
		}
		//b가 c보다 자가야 하니깐
		//b가 c보다 작아 ? 
		if(b>c) {
			int temp=b;
			b=c;
			c=temp;
		}
		System.out.println("a>"+a);
		System.out.println("b>"+b);
		System.out.println("c>"+c);
		
		
		if(a>b && a>c && b>c) {//b,c,a
			int temp = c;
			c=a;
			a=temp;
			temp= b;
			b=a;
			b=temp;
			System.out.println("a,b,c");
		}
		else if(a>b && a>c && b<c) {// c,b,a
			int temp = c;
			c=a;
			a=temp;
			System.out.println("a,b,c");
		}
		else if(a<b && a>c) {//c,a,b
			int temp = b;
			b=a;
			c=temp;
			System.out.println("a,b,c");
		}
		else if(a>b && a<c) {//b,a,c
			int temp = b;
			b=a;
			a=temp;
			System.out.println("a,b,c");
		}
		else if(a<b && a<c && c<b) {//a,c,b
			int temp = c;
			c=b;
			b=temp;
			System.out.println("a,b,c");
		}
		else if(a<b && a<c && b<c) {//a,b,c
			System.out.println("a,b,c");
		}
		sc.close();
	}

}
