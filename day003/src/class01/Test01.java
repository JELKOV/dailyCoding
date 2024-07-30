package class01;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 제어문을 중첩하는것은 완전 가능하다.
		// 이중 for문
		// 제어문> 반복문 >> for: 디버깅표 그리기
		// 반복문을 할때 달라지는 부분을 변수로 한다.
		// 구구단 반복문
		for(int n=2; n<=9; n++) {
		for(int i=1; i<=9; i++) {
			System.out.println(n +"x"+i+"="+(n*i));
		}
		//내가 원하는 코드 어디에 넣어야 할까??
		// 1. 뉘앙스 파악
		// 2. 반복문 깊이 마다 수행횟수 파악
		System.out.println("-------------------");
		}
	}

}
