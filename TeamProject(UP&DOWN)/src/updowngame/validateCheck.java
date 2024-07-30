package updowngame;

import java.util.Random;
import java.util.Scanner;

public class validateCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 1~100 사이의 정수가 랜덤으로 정답 설정됩니다.
		Random random = new Random(); // Random으로 설정
		// 다음 선택시 선택값 그리고 up&down값에 따라 유효성검사가 바뀐다.
		int computerNumber = random.nextInt(100) + 1;// computer 넘버 설정 1~100까지
		System.out.println("컴퓨터 숫자>>" + computerNumber);
		int userNumber;
		int min = 1;
		int max = 100; // 5
		int userCount = 0; // 카운트 초기값을 어떻게 설정할 것인가
		int recordCount = 6;
		String recordName = " "; // 명예의 전당 이름
		while (true) {// 처음 1~100까지 고르는 유효성 검사
			System.out.println(min + "부터" + max + "사이의 정수를 입력하세요>> ");
			userNumber = sc.nextInt(); // 선택하는 숫자
			if (userNumber < min || userNumber > max) {
				System.out.println("올바른 범위를 입력하세요 ");
			} else if (userNumber < computerNumber) {
				System.out.println("Up!");
				min = userNumber + 1; // 선택한 값보다 큰 값만 선택 가능
				userCount++;
				System.out.println(userCount);
			} else if (userNumber > computerNumber) {
				System.out.println("Down!");
				max = userNumber - 1; // 선택한 값보다 작은 값만 선택 가능
				userCount++;
				System.out.println(userCount);
			} else {
				System.out.println("숫자를 맞췃습니다.");
				userCount++;
				min = 1; // 초기화
				max = 100; // 초기화
				System.out.println(userCount);
				break;
			}
		}
		if (userCount < recordCount) {
			System.out.println("새로운 명예의전당에 등극하였습니다. ");
			System.out.println("이름을 입력해주세요 >>");
			recordName = sc.next();// 새로운 이름 입력
//				recordName = sc.nextLine();
			recordCount = userCount;
			userCount = 0; // 유저 카운트 초기화
			System.out.println("명예의전당>>" + recordName);
		}

	}

}
