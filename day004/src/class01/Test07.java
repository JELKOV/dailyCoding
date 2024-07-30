package class01;
//1. test01이라는 함수가 있습니다.
//이 함수는 정수를 2개 외부에서 입력받아서,
//정수 2개의 평균값을 실수로 반환하는 함수입니다.
//test01을 작성해주세요.

public class Test07 {
	public static double test01(int a, int b) {
		System.out.println("test01() 함수 호출됨");// 로그 역활
		double avg = (a+b)/2.0;
		System.out.println("평균은="+avg);
		return avg;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test01(3,4);

	}

}
