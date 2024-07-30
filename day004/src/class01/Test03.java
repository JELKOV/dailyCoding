package class01;
//함수 2유형 input o output x

public class Test03 {
	
	//정수를 1개 외북에서 받아오면
	//x100을 해서 화면에 출력해주는 함수
	public static void test(int num) {
		num*=100;
		System.out.println(num);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=2; 
		test(num); //함수를 호출할때 인자를 전달하는 방식
		// 해당변수의 "값"만을 전달/  메모리 전달 x
		// == call by value(값에 의한 호출)
		System.out.println("num="+num);

		

	}

}
