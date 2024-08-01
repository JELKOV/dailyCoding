package class02;
class Stud{
	//학생클라스
	//학생은 학번, 이름, 성적, 등급이 있습니다.
	//학생은 반드시 이름을 가져야 합니다.
	//학생을 생성할때, 성적이 0~100점 사이로 랜덤저장됩니다.
	//학생의 번호는 1001번부터 차례대로 증가하며 부여됩니다.
	//성적이 0~59 C 60~79 B 80~100 A등급입니다.
	//학생이 hello()인사를 하면, 이름과 성적,등급이 화면에 출력합니다.
	//학생이 test() 시험을 보면, 성적이 현재성적점수 +10점이 됩니다.
	String name;
	int num;//pk 사용자가 지정 x/ 시스템에 값을부여 0 //  pk라서 외부에서 값을 부여받아야 한다.
	int score;
	char grade;

//	int getNextNumber() {
//		System.out.println(this.curNum);
//		this.curNum++;
//		return curNum;
//	}
	Stud(int num, String name){
//		getNextNumber();// 학생 생성할때 실행되는 함수 
		this.num = num; // 번호부여 
		this.name = name;
		this.score = (int) (Math.random() * 100) + 1;
		setGrade();
	}
	void hello() {
		System.out.println(this.name);
		System.out.println(this.score);
		System.out.println(this.grade);
		System.out.println(this.num);
	}
	void test(int score) {
		this.score += score + 10;
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

public class Test07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int NUM =1000;//
		
		Stud ahn = new Stud(NUM++, "안제호");
//		System.out.println(ahn.score);
		Stud kim= new Stud(NUM++,  "김민지");
		ahn.hello();
		kim.hello();

	}

}
