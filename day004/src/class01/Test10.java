package class01;

//4. test04라는 함수가 있습니다.
//이 함수는 외부로부터 정수를 1개 받아와서
//해당 정수의 약수들을 화면에 출력해줍니다.
//test04를 작성해주세요.
public class Test10 {
	public static void test04(int a) {
		for (int i = 1; i <= a; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test04(20);

	}

}
