package updowngame;

import java.util.Scanner;

public class together {

	public static void main(String[] args) {

		// 무한루프로 게임을 맞출 때 까지 게임이 진행된다
		// up
		// 변수에 담긴 정답 값과 비교하여 작으면
		// up이라는 값이 출력된다
		// >> 유효성 검사 - 선택한 값보다 작은수가 나오면 오류
		// down
		// 변수에 담긴 정답 값과 비교하여 크면
		// down이라는 값이 출력된다.
		// >> 유효성 검사 - 선택한 값보다 큰 수가 나오면 오류
		// 성공
		// 값이 동일하면 성공 출력

		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------------");
		System.out.println("업다운 게임에 오신것을 환영합니다 ");
		System.out.println("----------------------------");
		System.out.println("게임을 시작합니다~!");
		System.out.println("----------------------------");

		// 변수 선언
		String userName;
		int userNumber;
		int computerNumber = (int) (Math.random() * 100) + 1;
		String recordName;
		int recordCount;
		int count = 0; // 최초 카운트 설정
		String check = null; // 유효성 검사를 위한 변수
		int[] datas = new int[100];

		// 사용자에게 숫자를 입력받기
		// 랜덤으로 받아온 정수와 입력한 정수를 비교하여 up 혹은 down
		// 랜덤 정수 > 입력한 정수 : UP
		// 랜점 정수 < 입력한 정수 : DOWN
		// 정수 비교시 유효성 검사 필요 ★

		System.out.println(computerNumber + "*********");
		while (true) { // 무한루프로 게임을 맞출 때 까지 게임이 진행된다.

			System.out.println("숫자를 입력해주세요 >> ");
			userNumber = sc.nextInt();
			int currentNumber = 0;

			for (int i = 0; i < 100; i++) {// 랜덤 정수 > 입력한 정수 : UP, 랜덤 정수 < 입력한 정수 : DOWN

				// 중복 검사
				boolean isDuplicate = false;
				for (int a = 0; a < count; a++) {
					if (datas[a] == userNumber) {
						isDuplicate = true;
						break;
					}
				}
				if (isDuplicate) {
					System.out.println("동일한 값을 입력하셨습니다.");
					System.out.println("----------------------------");
					continue;
				}

				datas[count] = userNumber;
				count++;

				if (userNumber == computerNumber) {// 랜덤한 정수 == 입력받은 정수
					count++;
					System.out.println("축하합니다 일치합니다");
					System.out.println(count + "회 만에 성공하셨습니다.");
					break;
				}

				if (userNumber < computerNumber) { // 랜덤한 정수가 입력받은 정수보다 더 크다면
					System.out.println(userNumber + " UP! ");
					System.out.println("----------------------------");
					count++;
					currentNumber = userNumber;
					check = "UP"; // 유효성검사를 위한 변수
				}

				if (userNumber > computerNumber) {// 랜덤한 정수가 입력받은 정수보다 더 작다면
					System.out.println(userNumber + " DOWN! ");
					System.out.println("----------------------------");
					count++;
					currentNumber = userNumber;
					check = "DOWN"; // 유효성검사를 위한 변수
				}

				while (true) { // 다시 반복을 했을 때 기존 입력한 값이랑 비교하여 검증

					System.out.print("숫자를 입력해주세요 >>>");
					userNumber = sc.nextInt();

					// 중복 검사
					isDuplicate = false;
					for (int a = 0; a < count; a++) {
						if (datas[a] == userNumber) {
							isDuplicate = true;
							break;
						}
					}
					if (isDuplicate) {
						System.out.println("이전에 입력한 값을 다시 입력하셨습니다.");
						System.out.println("----------------------------");
						continue;
					}

					datas[count] = userNumber;
					count++;

					if (userNumber == computerNumber) { // 입력값과 랜덤값이 같다면
						break; // 즉시 탈출
					}

					if (check.equals("UP")) {// 만약 기존 입력 결과가 UP 일때,
						if (userNumber > currentNumber) { // 새로운 값 > 기존 입력값이라면
							break; // 즉시 탈출
						} else if (userNumber < currentNumber) { // 새로운 값 <= 기존값보다 작거나 같다면
							System.out.println(currentNumber + "보다 더 큰 숫자를 입력하세요");
							System.out.println("----------------------------");
						}
//                  else {
//                     System.out.println("동일한 값을 입력하셨습니다.");
//                  }
					}

					if (check.equals("DOWN")) { // 만약 기존 입력 결과가 DOWN 이라면

						if (userNumber < currentNumber) { // 새로운 값 < 기존 입력값이면
							break; // 즉시탈출
						} else if (userNumber > currentNumber) { // 새로운 값이 기존값보다 크거나 같다면
							System.out.println(currentNumber + "보다 더 작은 숫자를 입력하세요");
							System.out.println("----------------------------");

						}
//                     else {
//                        System.out.println("동일한 값을 입력하셨습니다.");
//                     }
					}

				} // while문의 끝 (UP DOWN 검증용)

			} // for문 끝

		} // while문 끝

	}
}