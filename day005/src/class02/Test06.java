package class02;

class Stu {
	// 학생클라스
	// 학생은 이름 성적, 등급이 있습니다.
	// 학생은 반드시 이름을 가져야 합니다.
	// 학생을 생성할때, 성적이 0~100점 사이로 랜덤저장됩니다.
	// 성적이 0~59 C 60~79 B 80~100 A등급입니다.
	// 학생이 hello()인사를 하면, 이름과 성적,등급이 화면에 출력합니다.
	// 학생이 test() 시험을 보면, 성적이 현재성적점수 +10점이 됩니다.
	String name;
	int score;
	char grade;

	Stu(String name) {
		this.name = name;
		this.score = (int) (Math.random() * 100) + 1;
//		if (this.score <= 59) {
//			this.grade = 'c';
//		} else if (this.score <= 79) {
//			this.grade = 'b';
//		} else {
//			this.grade = 'a';
//		}
		setGrade();
	}

	void hello() {
		System.out.println(this.name);
		System.out.println(this.score);
		System.out.println(this.grade);
	}

	void test() {
		this.score += 10;
		if(this.score>100) {
			this.score=100;
		}
		setGrade();
		System.out.println(this.score);
		System.out.println(this.grade);
	}
	void setGrade() {
		if (this.score <= 59) {
			this.grade = 'c';
		} else if (this.score <= 79) {
			this.grade = 'b';
		} else {
			this.grade = 'a';
		}
	}
}

public class Test06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stu ahn = new Stu("안제호");
//		System.out.println(ahn.score);

		ahn.hello();
		ahn.test();

	}

}
