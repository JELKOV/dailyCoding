package class03;

import java.util.Scanner;

public class Test03 { // 강사님 코드
	public static void main(String[] args) {
		String[] datas = new String[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("학생부 프로그램");

		// 초기 데이터
		// datas[0]="티모";
		// datas[1]="아리";
		// datas[2]="모르가나";
		int cnt = 0;

		while (true) {
			System.out.println("=== 메 뉴 ===");
			System.out.println("1. 학생추가");
			System.out.println("2. 학생부 전체출력");
			System.out.println("3. 이름으로 검색");
			System.out.println("4. 번호로 검색");
			System.out.println("5. 이름변경");
			System.out.println("0. 프로그램 종료");
			System.out.println("===============");
			System.out.print("메뉴 입력 >> ");
			int menu = sc.nextInt();

			if (menu == 0) {
				System.out.println("프로그램이 종료됩니다.");
				break;
			} else if (menu == 1) {
				cnt = addStudent(datas, cnt, sc);
			} else if (menu == 2) {
				printAllStudents(datas, cnt);
			} else if (menu == 3) {
				searchByName(datas, cnt, sc);
			} else if (menu == 4) {
				searchByNumber(datas, cnt, sc);
			} else if (menu == 5) {
				changeName(datas, cnt, sc);
			} else {
				System.out.println("제대로 입력해주세요~~");
			}
		}
	}

	public static int addStudent(String[] datas, int cnt, Scanner sc) {
		if (cnt >= datas.length) {
			System.out.println("더이상 데이터를 저장할 수 없습니다!");
			return cnt;
		}

		String name;
		while (true) {
			System.out.print("저장하고 싶은 학생의 이름을 입력해주세요. >> ");
			name = sc.next();

			System.out.print("정말 " + name + "(으)로 하시겠습니까? (Y/N) >> ");
			String answer = sc.next();

			if (answer.equals("Y")) {
				boolean flag = false;
				for (int i = 0; i < cnt; i++) {
					if (name.equals(datas[i])) {
						flag = true;
						System.out.println(name + "은(는) 이미 존재하는 이름입니다...");
					}
				}

				if (!flag) {
					break;
				}
			}
		}

		datas[cnt] = name;
		cnt++;
		System.out.println(name + "이(가) 저장되었습니다!");
		return cnt;
	}

    public static void printAllStudents(String[] datas, int cnt) {
        if (cnt <= 0) {
            System.out.println("보여줄 학생 데이터가 없습니다.");
            return;
        }

        System.out.println("=== 학생 목록 ===");
        for (int i = 0; i < cnt; i++) {
            System.out.println((i + 1) + "번 학생 : " + datas[i]);
        }
        System.out.println("===============");
    }

    public static void searchByName(String[] datas, int cnt, Scanner sc) {
        System.out.print("검색어 입력 >> ");
        String searchContent = sc.next();

        boolean flag = false;
        System.out.println("===============");
        for (int i = 0; i < cnt; i++) {
            if (datas[i].contains(searchContent)) {
                System.out.println(datas[i]);
                flag = true;
            }
        }

        if (!flag) {
            System.out.println("검색결과가 없습니다...");
        }
        System.out.println("===============");
    }
    
    public static void searchByNumber(String[] datas, int cnt, Scanner sc) {
        if (cnt <= 0) {
            System.out.println("검색할 학생 데이터가 없습니다!");
            return;
        }

        int num;
        while (true) {
            System.out.print("검색할 학생의 번호 입력 >> ");
            num = sc.nextInt();
            if (1 <= num && num <= cnt) {
                break;
            }
            System.out.println("올바른 번호를 입력해주세요!~~");
        }

        System.out.println(num + "번 학생의 이름은 " + datas[num - 1] + " 입니다.");
    }
    
    public static void changeName(String[] datas, int cnt, Scanner sc) {
        if (cnt <= 0) {
            System.out.println("변경할 학생 데이터가 없습니다!");
            return;
        }

        int num;
        while (true) {
            System.out.print("변경할 학생의 번호 입력 >> ");
            num = sc.nextInt();
            if (1 <= num && num <= cnt) {
                break;
            }
            System.out.println("올바른 번호를 입력해주세요!~~");
        }

        System.out.println(num + "번 학생의 이름은 " + datas[num - 1] + " 입니다.");

        String name;
        while (true) {
            System.out.print("변경할 이름을 입력해주세요. >> ");
            name = sc.next();

            System.out.print("정말 " + name + "(으)로 하시겠습니까? (Y/N) >> ");
            String answer = sc.next();

            if (answer.equals("Y")) {
                boolean flag = false;
                for (int i = 0; i < cnt; i++) {
                    if (name.equals(datas[i])) {
                        flag = true;
                        System.out.println(name + "은(는) 이미 존재하는 이름입니다...");
                    }
                }

                if (!flag) {
                    break;
                }
            }
        }

        datas[num - 1] = name;
    }
}


//public class check123 {
//	// 학생이 추가되는 함수
//	// 학생 추가되는 함수 
//	// 학생부 전체 출력 되는 함수 
//	// 이름으로 검색
//	// 이름 변경
//
//   public static void main(String[] args) {
//      String[] datas = new String[5];
//      Scanner sc=new Scanner(System.in);
//      System.out.println("학생부 프로그램");
//
////      datas[0]="티모";
////      datas[1]="아리";
////      datas[2]="모르가나";
//      int cnt=3; 
//
//      while(true) {
//         System.out.println("=== 메 뉴 ===");
//         System.out.println("1. 학생추가");
//         System.out.println("2. 학생부 전체출력");
//         System.out.println("3. 이름으로 검색");
//         System.out.println("4. 번호로 검색");
//         System.out.println("5. 이름변경");
//         System.out.println("0. 프로그램 종료");
//         System.out.println("===============");
//         System.out.print("메뉴 입력 >> ");
//         int menu=sc.nextInt();
//
//         if(menu==0) {
//            System.out.println("프로그램이 종료됩니다.");
//            break;
//         }
//         else if(menu==1) { // 학생추가
//
//            if(cnt >= datas.length) {
//               System.out.println("더이상 데이터를 저장할수없습니다!");
//               continue;
//            }
//
//
//            String name;
//            while(true) {
//               System.out.print("저장하고싶은 학생의 이름을 입력해주세요. >> ");
//               name=sc.next();
//
//               System.out.print("정말 "+name+"(으)로 하시겠습니까? (Y/N) >> ");
//               String answer=sc.next();
//
//               if(answer.equals("Y")) {
//
//                  boolean flag=false;
//
//                  for(int i=0;i<cnt;i++) {
//                     if(name.equals(datas[i])) {
//                        flag=true;
//                        System.out.println(name+"은(는) 이미 존재하는 이름입니다...");
//                     }
//                  }
//
//
//                  if(!flag) {
//                     break;
//                  }
//
//               }
//            }
//
//
//
//
//            datas[cnt]=name;
//            cnt++;
//
//            System.out.println(name+"이(가) 저장되었습니다!");
//
//         }
//         else if(menu==2) { // 학생부 전체출력
//
//            if(cnt<=0) { 
//               System.out.println("보여줄 학생 데이터가 없습니다.");
//               continue;
//            }
//
//
//            System.out.println("=== 학생 목록 ===");
//            for(int i=0;i<cnt;i++) { 
//               System.out.println((i+1)+"번 학생 : "+datas[i]);
//            }
//            System.out.println("===============");
//         }
//         else if(menu==3) { // 이름으로 검색
//
//            // 검색어를 입력 >> 
//            // 이 검색어가 맞습니까? xxx : 사용자가 하는 입력이 데이터에 변화를주지않기때문
//            System.out.print("검색어 입력 >> ");
//            String searchContent=sc.next(); // searchKeyword
//
//            boolean flag=false; // 검색결과가 없는 상태로 시작
//            
//            // 학생부를 하나하나 확인하면서
//            System.out.println("===============");
//            for(int i=0;i<cnt;i++) {
//               // 학생의 이름안에 검색어가 있니? ==> 티모 == 모 xxxxx 티모안에 모가 있니? o
//               if(datas[i].contains(searchContent)) { // 티모안에 모가 있니?
//                  System.out.println(datas[i]);
//                  flag=true; // 검색결과를 찾은 상태
//               }
//               // 있다면, 출력
//               // 없다면, 출력 x
//            }
//            
//            if(!flag) { // 검색결과가 없다면
//               System.out.println("검색결과가 없습니다...");
//            }
//            // 검색결과가 없다면, 없다고 알려주기
//            // 1. 검색결과가 없다는 출력은 한번만! 수행하기때문에 반복문 바깥에있어야함
//            // 2. 검색결과가 없다는 사실은 검색을 다~~~ 해봐야알수있음
//            // ===>> flag 로직 대표적인 케이스 !!!
//            
//            System.out.println("===============");
//
//
//         }
//         else if(menu==4) { // 번호로 검색 => PK로 검색 == selectOne(getOne)
//            // Primary Key : "데이터를 '식별'"할 수 있게 해주는 값
//            // ex) 주민번호, 학번, ...
//            // 사용자가 지정하는 것이 아니라, 프로그램에서 부여하는 값
//            // 현재 학생부 프로그램에서는 '번호' == PK
//
//            // 경계값 검사
//            if(cnt<=0) { // 학생이 한명도 저장되어있지않다면
//               System.out.println("검색할 학생 데이터가 없습니다!");
//               continue; // 프로그램 처음으로 돌아가기
//            }
//
//
//            int num;
//            while(true) {
//               System.out.print("검색할 학생의 번호 입력 >> ");
//               num=sc.nextInt();
//               // 사용자가 검색하고싶은 번호를 입력 : 유효성 검사
//               if(1<=num && num<=cnt) { // 경계값 검사
//                  break;
//               }
//               System.out.println("올바른 번호를 입력해주세요!~~");
//               // 제대로 입력하라고 안내문구 출력
//            }
//
//
//            System.out.println(num+"번 학생의 이름은 "+datas[num-1]+" 입니다.");
//            // 사용자가 입력한 번호에 해당하는 학생의 이름은
//            // datas[num-1] 입니다.
//
//
//
//
//         }
//         else if(menu==5) { // 이름변경
//
//            // UPDATE : UPDATE 처리할 대상 데이터가 특정되어있어야함!
//            // ex) 프로필 사진 변경, 닉네임 변경, ...
//
//            // 이름을 변경할 학생의 번호 입력 >>
//            // PK로 데이터를 특정한 후에 UPDATE를 진행해야함
//
//
//
//            if(cnt<=0) {
//               System.out.println("변경할 학생 데이터가 없습니다!");
//               continue;
//            }
//
//            int num;
//            while(true) {
//               System.out.print("변경할 학생의 번호 입력 >> ");
//               num=sc.nextInt();
//               if(1<=num && num<=cnt) {
//                  break;
//               }
//               System.out.println("올바른 번호를 입력해주세요!~~");
//            }
//            // PK로 대상을 특정짓는다는 부분이 selectOne와 닮을수밖에 없다!!!!!
//
//
//            // 사용자가 A를 변경하고싶어한다.
//            System.out.println(num+"번 학생의 이름은 "+datas[num-1]+" 입니다.");
//
//
//            // B로 이름을 변경
//            // 정말 변경할지 확인
//            String name;
//            while(true) {
//               System.out.print("변경할 이름을 입력해주세요. >> ");
//               name=sc.next();
//
//               System.out.print("정말 "+name+"(으)로 하시겠습니까? (Y/N) >> ");
//               String answer=sc.next();
//
//               if(answer.equals("Y")) {
//
//                  boolean flag=false;
//
//                  for(int i=0;i<cnt;i++) {
//                     if(name.equals(datas[i])) {
//                        flag=true;
//                        /*
//                        if(num-1 == i) { // 내 이전 이름이면
//                           이전 이름이라 안됨
//                        }
//                        else {
//                           이미 사용중인 이름입니다...
//                        }
//                         */
//                        System.out.println(name+"은(는) 이미 존재하는 이름입니다...");
//                     }
//                  }
//
//
//                  if(!flag) {
//                     break;
//                  }
//
//               }
//            }
//            // 새로운 데이터를 입력한다는 점에서 CREATE와 닮았다!~~
//
//
//            // A 자리에 B 데이터 저장
//            datas[num-1]=name;
//         }
//         else { // 유효성 검사
//            System.out.println("제대로 입력해주세요~~");
//         }
//      }
//
//
//   }
//
//}
