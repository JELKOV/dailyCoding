package class02;

public class Test01 {
	public static void main(String[] args) {
		//[배열] 자료구조 배열리스트 연결리스트 큐 스택 집합 맵 ...
		// 언제 쓰느냐 ?? 언제 끄집어낼지?? 중요하다 !! 
		// 1. 크기: 개수를 분명하게 알고있는 데이터들을
		// 2. 관련성: 이 데이터들이 서로 관련이 있는 상태에서
		// 3. 자료형: 자료형이 같을때
		// 위 3가지를 모두 만족할때만 배열이 될수 있다.
		// ex) 학생의 국어, 영어, 수학 점수
		// ex) 학생 1의 평균, 학생 2의 평균, 학생 3의 평균,..., 학생 10의 평균점수 0
		// ex) 학생의 이름, 나이, 평균 정보 xxx 배열이 될수 없다. 자료형이 다르다.
//		int stu1 = 10;
//		int stu2 = 94;
//		int stu3 = 87;
		int[] student = new int[3];
		//각 메모리 공간을 index를 붙여서 관리!
		//메모리를 옆에 둘 필요성을 모름
		student[0] = 10;
		student[1] = 94;
		student[2] = 84;
		for(int i=1; i<=3; i++) {
			System.out.println("학생 "+i+"번의 점수는"+student[i-1]+"점입니다.");
		}
	}

}
