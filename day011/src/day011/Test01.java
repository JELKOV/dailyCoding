package day011;

class Student {
	//클래스 외부에서 멤버변수에 접근하는 것을 막아야 함!!!
	//JAVA 공개정책
	//접근제어자를 사용해서 공개범위를 변경
	private int num;
	private String name;
	private int score;
	//private == 클래스 외부에서 접근할수 없다 !! 
	//모든 멤버변수에 private을 반드시 추가해라 !! 
	//private은 자식 클래스도 접근 xxx!!
	//자식클래스한테는 오픈해줘 ~~ protected
	Student(int num,String name){
		this.num=num;
		this.name=name;
		this.score=50;
	}
//	void setNum(int num) {
//		this.num=num;
//	}
//	
//	int getNum() {
//		return this.num;
//	}
	
	@Override
	public String toString() {
		return this.num+"번 학생"+this.name+"은 "+this.score+"점 입니다.";
	}

	// 코드내에 어디서든지 호출될수 있어야 해서
	// 공개정책 public 이다 
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu1 = new Student(1001, "홍길동");
		//재시험등으로 점수가 바꿔야 할때  -> 반드시 메서드를 거쳐야 한다 !! 
		//멤버변수에 값을 넣을때에는 set멤버변수명() 
		//멤버변수의 값을 받아올때에는 get멤버변수명()
		
		//stu1.score=100;
		stu1.setScore(100); 
		
		//메인이라는 공간에서 홍길동의 점수를 바꿀수 있다.
		//모든 데이터값은 "함수,메서드"를 통해서 변경되어야 한다.
		//로그(기록)라는게 남는다.
		//연산자는 안남는다.!!
		
        //System.out.println(stu1);
		System.out.println(stu1.getScore());
		
		
	}

}
