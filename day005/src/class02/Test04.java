package class02;
//특정 멤버변수의 값을 반드시 넣도록 강제 하고 싶을때 ??? 
//"강제": 지정하는 것 !! 실수를 줄여준다 !!!
// 멤버 변수의 값을 '강제'하고싶을때는 
// == 생성자를 선언(정의)하면 된다.

class Pokemon {
	String name;
	int level;
	int exp;
	Pokemon(String name){//input 강제할 항목
		this.name=name;
		//외부에서 받아온 name값을
		//멤버변수 name에 저장 !! 
		//멤버변수를 나타내기 위해 this를 쓴다 !! 
		//만약, 사용자가 하나라도 직접 생성자를 정의하면, 더이상 기본 생성자는 제공하지 않는다.
		this.level=5;
		this.exp=0; // 모든 멤버변수 초기화를 직접 작성하는것을 권장
	}

	void hello() {
		System.out.println(this.name);
		System.out.println("lv"+this.level);
		System.out.println("exp"+this.exp);
	}
	// 클래스 내부에서 만드는 함수는 public static이 없는 이유 ??
	// 오직 포켓몬만 헬로우할수 있기 때문에 !! public X
	// 객체만 만들수 있으니깐 static 못쓴다 !!
}

public class Test04 {
	public static void main(String[] args) {
		int num = 10;
		Pokemon pika = new Pokemon("피카츄");
//		pika.name = "피카츄"; // 멤버접근 연산자로 피카츄 파이리를 넣어야한
		Pokemon fire = new Pokemon("파이리");
//		fire.name = "파이리";

		pika.hello();
		fire.hello();
	}

}