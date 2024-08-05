package view;

import java.util.Random;

public class test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] Shuffle = new int[10];
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			int number = random.nextInt(10)+1;
			System.out.println("로그numi"+number);
			//두번째 반복문에서 다른 값이 나올때까지 반복
			//안에서 숫자를 계속에서 변경해주고 J=-1를해서 초기화해서 돌린다
			for (int j = 0; j < i; j++) {
				if (Shuffle[j] == number) {
					System.out.println("J로그"+j);
					number = random.nextInt(10) + 1;
					System.out.println("로그numJ"+number);
					j = -1;
				}
			}

			Shuffle[i] = number; // 중복이 없으면 배열에 숫자 저장
			//5,3,4,4
		}

		// 결과 출력
		System.out.print("배열에 저장된 랜덤하고 중복되지 않는 숫자들: ");
		for (int num : Shuffle) {
			System.out.print(num + " ");
		}
	}

}

