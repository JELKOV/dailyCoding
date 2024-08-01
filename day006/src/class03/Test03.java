package class03;

import java.util.Scanner;

class Student {
	int num;
	String name;
	int score;
	char grade;

	Student(int num, String name) {
		this(num, name, 0);
	}

	Student(int num, String name, int score) {
		this.num = num;
		this.name = name;
		this.score = score;
		this.grade = 'C';
		if (this.score >= 80) {
			this.grade = 'A';
		} else if (this.score >= 60) {
			this.grade = 'B';
		}
	}

	void printInfo() {
		System.out.println(this.num + "번 " + this.name + " " + this.score + "점 " + this.grade + "등급");
	}
	void reTest (int score) {
		if(this.score< score) {
			this.score=score;
		}
	}
	void setGrade() {
		if (this.score >= 80) {
			this.grade = 'A';
		} else if (this.score >= 60) {
			this.grade = 'B';
		}
	}
}

public class Test03 {
//함수
	public static boolean isEmpty(int cnt) {
		if (cnt <= 0) {
			System.out.println("데이터가 없습니다!");
			return true;
		}
		return false;
	}

	public static boolean isFull(int cnt, Student[] datas) {
		if (cnt >= datas.length) {
			System.out.println("저장가능한 공간이 없습니다!");
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int PK = 1001; // 시스템에서 부여하는 PK값
		int cnt = 0; // 현재 배열에 저장된 데이터의 개수
		Student[] datas = new Student[3];
		datas[0] = new Student(PK++, "티모", 50);
		cnt++;

		while (true) {

			System.out.println("===== 메 뉴 =====");
			System.out.println("1. 학생추가");
			System.out.println("2. 전체목록출력");
			System.out.println("3. 번호검색");
			System.out.println("4. 이름검색");
			System.out.println("5. 1등출력");
			System.out.println("6. 등급검색");
			System.out.println("7. 재시험");
			System.out.println("0. 프로그램 종료");
			System.out.println("===============");
			System.out.print("메뉴 입력 >> ");
			int menu = sc.nextInt();

			if (menu == 0) {
				break;
			} else if (menu == 1) { // 학생추가

				if (isFull(cnt, datas)) {
					continue;
				}

				String name;
				int score;
				while (true) {
					System.out.print("이름 입력 >> ");
					name = sc.next();
					System.out.print("정말로? (Y/N) >> ");
					String ans = sc.next();
					if (ans.equals("Y")) {
						break;
					}
				}
				while (true) {
					System.out.print("성적 입력 >> ");
					score = sc.nextInt();
					if (0 <= score && score <= 100) {
						break;
					}
				}
				datas[cnt++] = new Student(PK++, name, score);
			} else if (menu == 2) { // 전체목록출력

				if (isEmpty(cnt)) {
					continue;
				}

				System.out.println("===============");
				for (int i = 0; i < cnt; i++) {
					// datas == 배열 == 학생부
					// datas[i] == 배열의 요소 == 학생
					// datas[i].num == 학생.번호 == 학생의 번호
					datas[i].printInfo();
				}
				System.out.println("===============");

			} else if (menu == 3) {
				// pk
				// 데이터 존재유무
				if (isEmpty(cnt)) {
					continue;
				}
				// 1. 번호 범위 유효성검사
				int pk;
				while (true) {
					System.out.print("번호를 입력하세요 >> ");
					pk = sc.nextInt();
					if (1001 <= pk && pk < 2000) {
						System.out.print("1001 이상 2000미만 번호를 입력하세요 >> ");
						break;
					}
				}
				// 2. 번호 검색
				// 3. 출력

				boolean flag = false; // 검색결과가 없는 상태로 시작

				System.out.println("===============");
				for (int i = 0; i < cnt; i++) {
					if (pk == datas[i].num) {
						flag = true;
						datas[i].printInfo();
					}
				}
				if (!flag) {
					System.out.println("해당번호에 학생이 없습니다.");
				}
				System.out.println("===============");

			} else if (menu == 4) {
				if (isEmpty(cnt)) {
					continue;
				}
				// 이름 검색
				System.out.print("이름입력 >> ");
				String searchName = sc.next(); // searchKeyword

				boolean flag = false; // 검색결과가 없는 상태로 시작

				System.out.println("===============");
				for (int i = 0; i < cnt; i++) {
					// 1. 이름 존재여부 유효성 검사
					if (datas[i].name.contains(searchName)) { // 이름 검색
						// 2. 출력
						flag = true; // 검색결과를 찾은 상태
						datas[i].printInfo();
					}
				}

				if (!flag) { // 검색결과가 없다면
					System.out.println("검색결과가 없습니다.");
				}

				System.out.println("===============");

			} else if (menu == 5) {
				// 언제 함수vs 메서드를 사용해야하는가 ?
				// 1등의 점수
				//: 함수
				
				// 해당 점수인 학생을 모두 출력
				// : 1명은 메서드
				// : N명은 함수
				if (isEmpty(cnt)) {
					continue;
				}
				int highScore = datas[0].score;
//				int rankCnt =0;
//				int [] highranking = new int [3];
				for (int i = 0; i < cnt; i++) {//최고 점수를 구한다.
					if (highScore <= datas[i].score) {
						highScore = datas[i].score;
//						highranking[rankCnt]
//						rankCnt++;
					}
				}
				System.out.println("===============");
				for(int i=0; i<cnt; i++) {// 최고점수의 값과 같은 학생을 보여준다.
					if(highScore == datas[i].score) {
						datas[i].printInfo();
					}
				}
				System.out.println("===============");
			} else if (menu == 6) {
				// 등급검색
				System.out.print("등급입력 >> ");
				char grade = sc.next().charAt(0);
//				System.out.println("등급은" + grade);
				while (true) {
					if (grade != 'A' && grade != 'B' && grade != 'C') {
						System.out.println("올바른 입력이 아닙니다");
						break;
					} else {
						System.out.println("===============");
						for (int i = 0; i < cnt; i++) {
							if (datas[i].grade == grade) {
								datas[i].printInfo();
							} else {
								System.out.println("해당등급이 없습니다");
							}
						}
						System.out.println("===============");
						break;
					}
				}

			} else if (menu == 7) {
				// 재시험
				// 재시험을 보는건 학생 1명이다 ->> 메서드
				// 60-> 60~100 랜던하게 점수를 획득: 경계값 검사
				//
				// 이름을 입력하세요
				System.out.print("이름입력 >> ");
				String searchName = sc.next(); // searchKeyword

				boolean flag = false; // 검색결과가 없는 상태로 시작

				System.out.println("===============");
				for (int i = 0; i < cnt; i++) {
					// 1. 이름 존재여부 유효성 검사
					if (datas[i].name.contains(searchName)) { // 이름 검색
						// 2. 출력
						flag = true; // 검색결과를 찾은 상태
						System.out.println("이전점수");
						datas[i].printInfo();
						System.out.println("===============");
						// 점수를 입력하세요
						System.out.print("성적입력 >> ");
						int newScore = sc.nextInt(); // searchKeyword
						datas[i].reTest(newScore);
						datas[i].setGrade();
					}
					System.out.println("현재점수");
					datas[i].printInfo();
					System.out.println("===============");
				}

				if (!flag) { // 검색결과가 없다면
					System.out.println("검색결과가 없습니다.");
				}

				System.out.println("===============");

			} else {
				System.out.println("잘못된 입력입니다!");
			}
		}

	}
}
//함수 주어가 없다 / 절자지형 /문제를 해결하는것이 중요
//메서드 주어가 있다. 객체. 메서드() 객체지향 객체가 해당기능을 수행하는것