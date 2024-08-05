package exception;

import java.util.Scanner;

// [예외 처리]
// 프로그램을 이용하다가 예외가 발생하게되면
// 프로그램이 즉시 종료(비정상 종료)되기때문에
// 예외를 개발자가 미리 처리해야한다!
//  결론) 예외 처리하는 이유가 뭔가요?
//       프로그램이 비정상적으로 종료되는 것을 예방하기 위함!
public class Test01 {
	public static void main(String[] args) {
		
		int[] datas=new int[3];
		try {
			System.out.println("로그 01");
			// 예외가 발생할 확률이 존재하는 코드를 작성
			System.out.println(datas[0]);
			// 만약 예외가 발생하다면, 즉시 catch문으로 이동함
			
			int a=10;
			int b=1;
			int c=a/b;
			
			Scanner sc=new Scanner(System.in);
			System.out.print("정수 입력 >> ");
			int num=sc.nextInt();
			
			System.out.println("로그 02");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("예외가 발생했을때 수행할 코드를 작성");
			e.printStackTrace(); // 예외 발생된 원인을 보여줘~~
		}
		catch(ArithmeticException e) {
			System.out.println("0으로는 나누기를 할 수 없습니다!");
		}
		catch(Exception e) {
			System.out.println("알수없는 예외발생함");
		}
		finally {
			System.out.println("예외 발생여부와 무관하게 항상 수행되는 코드를 작성");
		}
		System.out.println("로그 03");


		/*
		Scanner sc=new Scanner(System.in);
		System.out.print("정수 입력 >> ");
		int num=sc.nextInt();
		System.out.println("num= "+num);
		// InputMismatchException
		 */

	}
}
