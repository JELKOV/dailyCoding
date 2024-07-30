package class01;
//3. 함수 유형 input x output o
// output은 무엇을 반환하는지 형태만 쓰면된다
public class Test05 {
	public static int test() {
		int a=3, b=5;
		int sum =a+b;
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("총합은"+test()+"입니다.");
		
		int result=test();
		System.out.println("총합은"+result+"입니다.");

	}

}
