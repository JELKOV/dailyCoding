package class03;

import java.util.Scanner;

import java.util.ArrayList;

class Student{
	private int num;
	private String name;
	private int score;

	Student(int num, String name, int score){
		this.num =num;
		this.name=name;
		this.score=score;
	}

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

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", score=" + score + "]";
	}

}

public class Test04 {

	//	public static Student hasStudent(ArrayList<Student> datas,int num) {
	//		for(Student data:datas) {
	//			if(num == data.getNum()) {
	//				return data;
	//			}
	//		}
	//		for(int i=0;i<datas.size();i++) {
	//			if(num == datas.get(i).getNum()) {
	//				return datas.get(i);
	//			}
	//		}
	//		return null;
	//	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		ArrayList<Student> datas = new ArrayList<Student>();
		//[샘플데이터 생성]
		int PK=1001;
		datas.add(new Student(PK++,"홍길동",50));
		datas.add(new Student(PK++,"아무무",30));
		datas.add(new Student(PK++,"티모",40));
		//[전체출력]
		//[학생입력]
		while(true) {
			System.out.println("====메뉴===");		
			System.out.println("1.학생추가");		
			System.out.println("2.전체룰력");
			System.out.println("3.번호검색");
			System.out.println("4.이름검색");
			System.out.println("5.평균출력");
			System.out.println("6.점수변경");
			System.out.println("7.학생삭제");
			System.out.println("0.프로그램종료");
			System.out.println("==========");

			System.out.println("메뉴입력");
			int action= sc.nextInt();
			if(action==0) {
				break;

			}
			else if(action==1) {// 학생추가
				System.out.println("이름입력");
				String name=sc.next();

				System.out.println("성적입력");
				int score =sc.nextInt();

				datas.add(new Student(PK++,name,score));
				System.out.println("학생데이터 추가완료!");

			}
			else if(action==2) {// 전체출력
				if(datas.isEmpty()) {
					System.out.println("출력할데이터가 없습니다.");
					continue;
				}
				for(Student data:datas) {
					System.out.println(data);
				}
			}
			else if(action==3) {// 번호검색
				if(datas.isEmpty()) {
					System.out.println("출력할데이터가 없습니다.");
					continue;
				}

				while(true) {
					System.out.println("번호를 입력해주세요");
					int num = sc.nextInt();
					//유효성 검사
					if(num<1001) {
						System.out.println("1001번 이상 입력해주세요");
						continue;
					}
					boolean found = false;
					for(int i=0; i<datas.size(); i++) {
						if(datas.get(i).getNum()==num) {// getNum을 사용해서 번호를 검색한다.
							System.out.println(datas.get(i));
							found = true;
						}
					}
					if(found) {
						break;
					}
					if(!found) {
						System.out.println("해당번호의 학생은 없습니다.");
					}
				}


			}
			else if(action==4) {// 이름검색
				if(datas.isEmpty()) {
					System.out.println("출력할데이터가 없습니다.");
					continue;
				}
				System.out.println("이름을 입력해주세요");
				String name = sc.next();
				while(true) {
					boolean found = false;
					ArrayList<Student> temp = new ArrayList<Student>();
					for(int i=0; i<datas.size(); i++) {
						if(datas.get(i).getName().contains(name)) {
							System.out.println(datas.get(i));
							temp.add(datas.get(i));
						}
					}
					if(temp.size()==1) {
						found = true;
					}
					else if(temp.size()!=1) {
						System.out.println("중복검색되었습니다.다시한번 써주세요");
						name=sc.next();
						for(Student s:temp) {
							if(s.getName().contains(name)) {
								System.out.println(s);
								found=true;
							}
						}
					}
					if(found) {
						break;
					}
					if(!found) {
						System.out.println("해당이름의 학생은 없습니다.");
					}
				}
			}
			else if(action==5) {// 평균출력
				if(datas.isEmpty()) {
					System.out.println("출력할데이터가 없습니다.");
					continue;
				}
				int sum = 0;
				for(int i=0; i<datas.size(); i++) {
					sum+= datas.get(i).getScore();
				}
				double avg =sum*1.0/datas.size();  // 형변환에 주의하자 !! 
				System.out.println(avg);

			}
			else if(action==6) {// 점수변경
				if(datas.isEmpty()) {
					System.out.println("출력할데이터가 없습니다.");
					continue;
				}
				//1. 누구의 점수인지 특정 해야 한다.
				while(true) {
					System.out.println("변경할 번호를 입력해주세요");
					int num = sc.nextInt();
					//유효성 검사
					if(num<1001) {
						System.out.println("1001번 이상 입력해주세요");
						continue;
					}
					boolean found = false;
					for(int i=0; i<datas.size(); i++) {
						if(datas.get(i).getNum()==num) {// getNum을 사용해서 번호를 검색한다.
							System.out.println(datas.get(i));
							System.out.println("변경할 점수를 입력해주세요");
							int score = sc.nextInt();
							//2. 점수 변경을 입력해야한다.
							datas.get(i).setScore(score);
							//3. 변경이 완료했다는 메세지를 출력해야한다.
							System.out.println("점수변경이 완료되었습니다.");
							found = true;
						}
					}
					if(found) {
						break;
					}
					if(!found) {
						System.out.println("해당번호의 학생은 없습니다.");
					}
				}

			}
			else if(action==7) {// 데이터삭제
				if(datas.isEmpty()) {
					System.out.println("출력할데이터가 없습니다.");
					continue;
				}
				while(true) {
					//1. 몇번의 학생을 삭제해야할지 특정 해야 한다.
					System.out.println("삭제할 번호를 입력해주세요");
					int num = sc.nextInt();
					//유효성 검사
					if(num<1001) {
						System.out.println("1001번 이상 입력해주세요");
						continue;
					}
					boolean found = false;
					for(int i=0; i<datas.size(); i++) {
						if(datas.get(i).getNum()==num) {// getNum을 사용해서 번호를 검색한다.
							System.out.println(datas.get(i));
							datas.remove(i);
							System.out.println("전체데이터 출력>>"+ datas);
							System.out.println("삭제 완료되었습니다.");
							found = true;
						}
					}
					if(found) {
						break;
					}
					if(!found) {
						System.out.println("해당번호의 학생은 없습니다.");
					}
				}
			}
			else {
				System.out.println("잘못된 입력입니다!!");
			}
		}

	}

}
