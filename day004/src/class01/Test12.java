package class01;

import java.util.Random;
import java.util.Scanner;

//함수를 사용해서 프로그램 제작하기
//랜덤으로 정수를 하나 생성해서
// 사용자가 해당정수를 맞추는 프로그램
//정답을 맞추면 축하합니다.
//못맞추면 재시도 하게 할게요 
//못맞추면 재시도 -> 맞출때까지
public class Test12 {
	public static int makeRandNum() {
		Random rand = new Random();
		return rand.nextInt(10)+1; //1~10
	}
	public static void printInfo() {
		System.out.println("오답입니다");
		System.out.println("다시 시도해보세요");
	}
	public static void hello() {
		System.out.println("축하합니다");
	}
	public static boolean isRight(int ans) {
		System.out.print("정답입력 >>");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(num==ans) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//랜덤으로 정수 생성하기
		int ans=makeRandNum();
		//makeRandNum(); 메서드 시그니처 유추하기
		//input x output o 3유형
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			//정답을 맞추는 과정
			System.out.println("정답을 입력하세요.>>");
			int num = sc.nextInt();
			if(isRight(ans)) {
				break;
			}
			//못맞췄다고 말해주기
			printInfo();
		}
		//축하해주기
		hello();

	}

}
