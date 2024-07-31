package class04;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		
    Scanner sc = new Scanner(System.in);
		
	//	- 10번 정수를 입력받을건데 0 이하의 입력되면 그냥 바로 종료 -> for 
		
	for(int i = 0; i < 10; i++) {
		int num = sc.nextInt();
		if (num < 0) {  // 0이하가 입력된다면 
			break;
		}
		
	}

	}

}
