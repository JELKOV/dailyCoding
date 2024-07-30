package class01;

import java.util.Random;

//3. test03이라는 함수가 있습니다.
//함수를 실행하게되면, 1~100사이의 정수중 랜덤으로 1개의 값을 생성합니다.
//그리고 생성한 정수값을 반환합니다.
//test03을 작성해주세요
public class Test09 {
	public static int test03() {
		System.out.println("test03() 함수 호출됨");// 로그 역활
		Random random = new Random();
		int computerNumber = random.nextInt(100) + 1;// computer 넘버 설정 1~100까지
		return computerNumber;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int random = test03();
		System.out.println(random);// 로그 역활
	}

}
