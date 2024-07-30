package class01;
//4. 함수input o output o
public class Test06 {
	public static int plus(int a, int b) {
		//외부에서 정수를 2개받와서
		//정수 2개의 합을 반환하는 함수
		System.out.println("plus() 함수 호출됨");// 로그 역활
		return a+b;
	}
	//외부에서 정수를 1개 받아와서
	//해당 정수가 짝수인지 홀수인지를 반환하는 함수
	
	public static boolean isEven(int num) {
		if(num%2==0) {
			return true;
		}
		return false; // return 하면 반북
		// return num%2==0 ? true : false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result= plus(4,5);
		System.out.println(result);
		
		if (isEven(21)) {
			System.out.println("짝수");
		}
		else {
			System.out.println("홀수");
		}
	}

}
