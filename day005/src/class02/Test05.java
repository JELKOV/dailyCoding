package class02;

class Students{
	//학생클라스
	//학생은 이름 성적이 있습니다.
	//학생은 반드시 이름을 가져야 합니다.
	//학생을 생성할때, 성적이 0~100점 사이로 랜덤저장됩니다.
	//학생이 hello()인사를 하면, 이름과 성적을 화면에 출력합니다.
	String name;
	int score;
	Students(String name){
		this.name = name;
		this.score = (int) (Math.random() * 100) + 1;
	}
	void hello() {
		System.out.println(this.name);
		System.out.println(this.score);
	}
}

public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Students ahn = new Students("안제호");
		ahn.hello();

	}

}
