package class03;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// R :학생부를 전체출력 /학생이름으로 검색 >>selectAll
		// R :1번학생 이름출력 >>selectONe, getOne
		Scanner sc = new Scanner(System.in);
		String[] datas = new String[5];
//		datas[0]="티모";
		int cnt = 0;

		System.out.println("학생부 프로그램");
		while (true) {
			System.out.println("====메뉴===");
			System.out.println("1.학생추가");
			System.out.println("2.학생부 전체출력");
			System.out.println("3.이름으로 검색");
			System.out.println("4.번호로 검색");
			System.out.println("5.이름변경");
			System.out.println("0.프로그램 종료");
			System.out.println("============");
			System.out.println("메뉴입력>>");
			int menu = sc.nextInt();
			if (menu == 0) {
				System.out.println("0.프로그램 종료");
				break;
			} else if (menu == 1) {// 이름입력

				if (cnt >= datas.length) {// 유효성 검사는 사용자가 입력할때마다 하는게좋다.
					System.out.println("더이상 데이터를 저장할수 없습니다");
					continue;
				}
				// 정말 ____으로 하시겠습니까 ?
				String name;
				while (true) {// 이름확인
					System.out.println("저장하고싶은 학생의 이름을 저장해주세요");
					name = sc.next();
					System.out.println("정말" + name + "로 하시겠습니까?(Y/N)>>");
					String answer = sc.next();
					if (answer.equals("Y")) {
						// 사용자가 이름 입력하고 사용자가 의도한 이름이라면, 저장!!
						boolean flag = false;// 기본적으로 학생부에 없겠지!!
						// 학생부데이터들을 한하나 확인하면서 데이터 일치여부를 판단
						for (int i = 0; i < cnt; i++) {
							if (name.equals(datas[i])) {
								flag = true;
								System.out.println(name + "은(는) 이미존재하고 있는 이름입니다.");
							}
						}
						if (!flag) {
							break;
						}
					}
				}
				// 이름을 추구할때 이미저장되어있다면 다시 이름을 입력받도록 1. 플래그 알고리즘 2 이미 완성되어 있는 코드에서 새로운 로직을 추가할때
				datas[cnt] = name;// 저장
				cnt++;
				System.out.println(name + "저장되었습니다");
			} else if (menu == 2) {
				System.out.println("====학생목록====");
				if (cnt <= 0) {// 보여줄데이터가 없다면 == 저장된데이터가 없다.// 유효성 검사는 더 꼼곰하게 들어가야 한다
					System.out.println("보여줄 학생 데이터가 없습니다.");
					continue;
				}
				for (int i = 0; i < cnt; i++) { // 저장된수만큼 해야 되기때문에 카운트가 왔다
					System.out.println((i + 1) + "번 학생: " + datas[i] + "입니다");
				}
			} else if (menu == 3) {
				// 유효성검사 없는이름 !!
				for (int i = 0; i < cnt; i++) {
					System.out.println("====이름으로 검색하고 싶은 학생의 이름을 써주세요====");
					String searchKeyword = sc.next();
					// 학생의 이름안에 검색어가 있니 ??
					if (datas[i].contains(searchKeyword)) {
						System.out.println(datas[i]);
					}
					// 검색 결과가 없다면, 없다고 알려주기
					// 검색결과가 없다는 출력은 한번ㅁ
					while (!datas[i].equals(searchKeyword)) {// 검색된 이름이 없다면 무한루프
						// 검색어를 입력
						// 이 검색어가 맞습니까 ? XX 데이터의 변화가 없기 때문이다
						// 학생부를 하나하나 확인하면서 학생의 이름안에 검색어가 있니? 티모안에 모가 있니 ?
						// 있다면, 출력
						// 없다면, 출력X
						System.out.println("====없는 이름입니다 다시 입력해주세요====");
						searchKeyword = sc.next();
						continue;
					}
					if (datas[i].equals(searchKeyword)) {// 검색된 이름이 있다면
						System.out.println(searchKeyword + " 검색된 이름입니다");
					}
				}

			} else if (menu == 4) {// 번호로 검색 => PK로 검색 == selectOne(getOne)
				// Primary Key: 데이터를 식별 할수 있게 해주는 값 PK
				// ex) 주민번호, 학번, ... 내가가진 어떠한 값이 다른 사람이랑 겹치지 않는것 !!
				// 사용자가 지정하는 것이 아니라 시스템 프로그램에서 보여주는 값이어야 한다.
				// 현재 학생부 프로그램에서는 '번호' == PK
				// 사용자가 검색하고 싶은 번호를 입력 한다.
				System.out.println("====번호를 써서 검색해주세요====");
				int num;
				while (true) {
					// 경계값 검사
					// 조건식에 들어가 있는 변수들이 경계에 닿아있는 숫자들이어도 해당조건식이 유효한지 확인하는것 !
					num = sc.nextInt(); // 번호는 있는데 이름이 없는경우
					if (num <= 0 || num > cnt) {// 삭제되거나할경우 문제가 될것같다
						System.out.println("해당번호가 없습니다. 다시입력해주세요");// 유효성 검사 없는 번호
						continue;
					} else {
						System.out.println(num + "번 학생: " + datas[num - 1] + "입니다");
						break;
					}
				}
			} else if (menu == 5) {// 이름변경
				// update 처리할 대상데이터가 특별하게 저장되어 있어야 한다 .
				// pk로 데이터를 특정한 후에 update를 진행해야 함 !!
				String name;
				for (int i = 0; i < cnt; i++) {
					while (true) {// 해당이름이 없는경우 무한루프를 통해 찾아본다.
						System.out.println("====기존 이름을 작성해주세요====");
						name = sc.next();
						if (!(name.equals(datas[i]))) {
							System.out.println(name + "은(는) 존재하지 않는 이름입니다.");
							continue;
						}

						else if (name.equals(datas[i])) {// 해당 이름이 있는 경우 수정한후에 빠져나간다.
							while (true) {// 해당이름이 같은경우 찾아본다 !
								System.out.println("====새로운 이름을 작성해주세요====");
								String reName = sc.next();
								if (name.equals(reName)) {
									System.out.println("====기존이름입니다 새로운 변경할 이름을 적어주세요====");
									continue;
								} else if (!(name.equals(reName))) {
									datas[i] = reName;
									break;
								}
							}
							break;
						}
					}
				}
//		         else if(menu==5) { // 이름변경
//                     
//		             // UPDATE : UPDATE 처리할 대상 데이터가 특정되어있어야함!
//		             // ex) 프로필 사진 변경, 닉네임 변경, ...
//		             
//		             // 이름을 변경할 학생의 번호 입력 >>
//		             // PK로 데이터를 특정한 후에 UPDATE를 진행해야함
//		             
//		             
//		             
//		             if(cnt<=0) {
//		                System.out.println("변경할 학생 데이터가 없습니다!");
//		                continue;
//		             }
//		             
//		             int num;
//		             while(true) {
//		                System.out.print("변경할 학생의 번호 입력 >> ");
//		                num=sc.nextInt();
//		                if(1<=num && num<=cnt) {
//		                   break;
//		                }
//		                System.out.println("올바른 번호를 입력해주세요!~~");
//		             }
//		             // PK로 대상을 특정짓는다는 부분이 selectOne와 닮을수밖에 없다!!!!!
//		             
//		             
//		             // 사용자가 A를 변경하고싶어한다.
//		             System.out.println(num+"번 학생의 이름은 "+datas[num-1]+" 입니다.");
//		             
//		             
//		             // B로 이름을 변경
//		             // 정말 변경할지 확인
//		             String name;
//		             while(true) {
//		                System.out.print("변경할 이름을 입력해주세요. >> ");
//		                name=sc.next();
//
//		                System.out.print("정말 "+name+"(으)로 하시겠습니까? (Y/N) >> ");
//		                String answer=sc.next();
//
//		                if(answer.equals("Y")) {
//
//		                   boolean flag=false;
//
//		                   for(int i=0;i<cnt;i++) {
//		                      if(name.equals(datas[i])) {
//		                         flag=true;
//		                         System.out.println(name+"은(는) 이미 존재하는 이름입니다...");
//		                      }
//		                   }
//
//
//		                   if(!flag) {
//		                      break;
//		                   }
//
//		                }
//		             }
//		             // 새로운 데이터를 입력한다는 점에서 CREATE와 닮았다!~~
//		             
//		             
//		             // A 자리에 B 데이터 저장
//		             datas[num-1]=name;
//		          }
//		          else { // 유효성 검사
//		             System.out.println("제대로 입력해주세요~~");
//		          }
//		       }

			} else {
				// 유효성검사
			}
		}
	}
}
