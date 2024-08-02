package day009;
//메서드(주인이있는) vs 함수 (주인이 없는)
//오버라이딩은 동적바인딩이 아니다
//동적바인딩: 코드 변화 없이, 실행시에 어떤 객체가 할당되느냐에 따라 결과가 달라지는 현상 
class A {
	void test() {
		System.out.println("");
	}
}
public class Test01 {
	
	public static int test(int a, int b) {
		return a+b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=10;
		double d=3.14; //data 공간에서 사용하지만
		
		int [] datas = new int[5]; //heap 공간에서 사용하게 된다.
		A a = new A();
		A [] arr = new A[3];
		
		//내가 구현하는것이 무엇인지 ????
		

	}

}

