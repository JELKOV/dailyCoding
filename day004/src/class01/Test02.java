package class01;
//1 함수 유형 input x output x 
public class Test02 {
	//함수 선언자리 // output 공석으로 두면 안된다 !! // 아예 없는것 !! 
	//static == 객체와 무관하게 << 객체를 배우면 나온다 !! 
	//1. 코드를 재사용할수가 있음 *==> 유지보수 용이
	// ->오류가 없는 코드를 재사용하는 것이기 때문에
	// -> 오류 검사 비용이 추가 x == 경제적
	// 시간이 추가 x == 효율적
	public static void hello() {
		//기능 구현
		System.out.println("안녕하세요 :D");	
		//콘솔이 돌아가지 않는다.
		//함수를 선언하는 행위: 함수 정의 
		//사용하는 행위는 다르다: 함수 호출
		
		//함수를 호출해야 수행
		//함수를 누르지 않으면 정의만 되어있는 상태 수행x
		// 2.main의 코드 가독성이 좋아진다
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hello();
		hello();
		hello();
		hello();
		hello();
		

	}

}
