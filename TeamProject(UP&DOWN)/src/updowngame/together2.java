package updowngame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class together2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1~100 사이의 정수가 랜덤으로 정답 설정됩니다.
		Random random = new Random(); // Random으로 설정
		// 다음 선택시 선택값 그리고 up&down값에 따라 유효성검사가 바뀐다.
		int computerNumber = random.nextInt(100) + 1;// computer 넘버 설정 1~100까지
		int userNumber;
		int min = 1;
		int max = 100;
		int userCount = 0; // 카운트 초기값을 어떻게 설정할 것인가
		int recordCount = 6;
		String recordName = "";
        int count = 0; // 동일한 값을 입력했는지 체크 하기 위한 카운트
        int[] enteredNumbers = new int[100];
        
        System.out.println("-------------------------------");
        System.out.println("업다운 게임에 오신것을 환영합니다 ");
        System.out.println("게임을 시작합니다~!");
        System.out.println("-------------------------------");
		
		while (true) { // 처음 1~100까지 고르는 유효성 검사
			System.out.println("컴퓨터 숫자 >> " + computerNumber);
			System.out.print(min + "부터 " + max + "사이의 정수를 입력하세요 >> ");
			userNumber = sc.nextInt(); // 선택하는 숫자
			System.out.println("-------------------------------");
			
			// 입력값을 다시 입력했는지 체크하기 위한 중복 검사 로
            if (isDuplicate(enteredNumbers, count, userNumber)) {
                System.out.println("이전에 입력한 값을 다시 입력하셨습니다.");
                System.out.println("----------------------------");
                continue; // 중복된 경우 다시 입력 받음
            }
            
            enteredNumbers[count++] = userNumber; // 입력된 숫자 저장

			if (userNumber < min || userNumber > max) {
				System.out.println("올바른 범위를 입력하세요 ");
				continue;
			}

			else if (userNumber < computerNumber) {
				System.out.println("Up!");
				min = userNumber + 1; // 선택한 값보다 큰 값만 선택 가능
				userCount++;
				System.out.println(userCount+"회 시도하였습니다~");
			}

			else if (userNumber > computerNumber) {
				System.out.println("Down!");
				max = userNumber - 1; // 선택한 값보다 작은 값만 선택 가능
				userCount++;
				System.out.println(userCount+"회 시도하였습니다~");

			}

			else {
				System.out.println("숫자를 맞췃습니다.");
				userCount++;

				if (userCount < recordCount) { // >> 기존 사람보다 기록이 빠르면 이름이 올라간다.
					recordCount = userCount; // 맞춘횟수가 갱신된다.
					sc.nextLine();
					System.out.print("축하합니다! " + recordCount + "회 만에 찾아 명예의전당에 올랐군요~!! 이름을 입력해주세요 >> ");
					String userName = sc.nextLine();
					recordName = userName; // 기존 명예의 전당
				}
				System.out.print("재시작 하고싶으면 Y를 눌러주세요(Y 외에는 게임이 종료됩니다) >> ");
				String again = sc.next();
				
				
				
				if (again.equals("Y")) { // Y를 선택하면 게임을 다시시작한다.
					System.out.println("게임을 재시작 하겠습니다.");
					System.out.println("");
					System.out.println("====== 명 예 의 전 당 ======"); // 명예의전당 표시
					System.out.println("시도횟수 = "+recordCount + " 회,    이름 " + recordName);
					System.out.println("=========================");
					computerNumber = random.nextInt(100) + 1; // 랜덤값과 최소, 최대값, 맞춘횟수 초기화
					max = 100;
					min = 1;
					userCount = 0;

					for(int i=0;i<count; i++) {
						System.out.println("지금까지 선택한숫자 입니다 >>"+ enteredNumbers[i]);
						enteredNumbers[i] = 0;
					}
//					Arrays.fill(enteredNumbers,0);
					count=0;
			       System.out.println("----------------------------");
			       System.out.println("업다운 게임에 오신것을 환영합니다 ");
			       System.out.println("게임을 시작합니다~!");
			       System.out.println("----------------------------");
					continue; // 게임을 재시작한다.
				} 
				
				else { // N을 선택하면 그 즉시 게임을 종료한다.
					System.out.println("게임을 종료합니다.");
					break;
					
				}
								
			}

		}
	}
	
	
	
	   public static boolean isDuplicate(int[] enteredNumbers, int count, int number) {
	        for (int i = 0; i < count; i++) {
	            if (enteredNumbers[i] == number) {
	                return true; // 중복된 경우 true 반환
	            }
	        }
	        return false; // 중복되지 않은 경우 false 반환
	    }
}

