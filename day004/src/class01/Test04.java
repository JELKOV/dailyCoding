package class01;

public class Test04 {
	//정수 2개를 외부에서 받아와서 
	public static void avg(int num1, int num2) { 
	//메서드 시그니처 부분 함수의 3요소가 중요하기 때문에 !!
	//정수들의 평균값을 소수점까지 출력하는 함수를 구현해주세요 ~!!!
		double avg = (num1+num2)/2.0;
		System.out.println("avg="+avg);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		avg(3,4);
	}

}
