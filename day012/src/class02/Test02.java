package class02;

import java.util.ArrayList;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1 ~100 사이의 정수를 사용자가 입력합니다.
		// 짝수라면 배열리스트에 추가해주시고,
		//짝수가 아니라면 X2 하여 배열리스트에 추가해주세요
		//배열리스트의 요소개수가 3개가 되면 더이상 일력받지 않습니다.
		// 그동안 저장했던 요소들을 출력해주시고
		//총합을 출력해주세요

		// 한글코딩
		//1. 배열리스트를 만든다.
		ArrayList<Integer> al = new ArrayList<Integer>();
		//2. while 반복문을 통해서 1 ~100 사이의 정수를 입력 받는다.
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("숫자를 입력하세요");
			int num = sc.nextInt();
			
			//2. 유효성검사를 통해서 1~100 사이의 정수가 아니라면 다시 입력을 요청한다.
			if(num<1 || num>100) {
				System.out.println("1~100사이의 값을 입력해주세요");
				continue;
			}
			if(num%2==0) {//3. 짝수라면 배열리스트에 add를 써서 추가한다. %=0
				al.add(num);
			}
			else {
				al.add(num*2); //4. 짝수가 아니라면 X2를 하여 배열리스트에 추가한다.
			}	
			//5. 3개이상이 되면 입력이 되지 않게 한다.
			if(al.size()>=3) {
				System.out.println("배열리스트가 3개이상 입력이 되지 않습니다");
				break;
			}

		}
		System.out.println(al); // 6.저장요소 모두 출력
		int sum =0;
		for(int i=0; i<al.size(); i++) {
			sum+=al.get(i);
		}
		System.out.println(sum);



	}

}
