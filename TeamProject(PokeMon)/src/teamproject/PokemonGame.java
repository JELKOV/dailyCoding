package teamproject;

import java.util.Random;
import java.util.Scanner;

abstract class Pokemon {
	private String type; // 모든 포켓몬은 타입이 반드시 존재한다. ex) 전기, 물, ...
	private String name; // 모든 포켓몬은 이름이 반드시 존재한다. ex) 피카츄, 꼬부기, ...
	private int level; // 새로 잡은 포켓몬의 레벨은 1~5 랜덤한 값을 가진다.
	private int exp; // 새로 잡은 포켓몬의 경험치는 0이다.

	static Random rand = new Random();

	Pokemon(String type, String name) {
		this.type = type;
		this.name = name;
		this.level = rand.nextInt(5) + 1;
		this.exp = 0;
	}
	

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public int getExp() {
		return exp;
	}


	public void setExp(int exp) {
		this.exp = exp;
	}


	public void attack() {
		// 50%의 확률로 성공 -> 성공 시 50~500 사이의 경험치 획득

		// 50% 확률로 공격 설정
		int randomAtt = Pokemon.rand.nextInt(2); // 0 or 1

		if (randomAtt == 0) { // 공격 성공
			System.out.println("공격에 성공하였습니다.");
			
			int minExp = 50;
			int maxExp = 500;

			// 50~500 사이의 랜덤 경험치 획득
			int randomExp = Pokemon.rand.nextInt(maxExp - minExp + 1) + minExp; // 50 ~500 사이
			int newExp = getExp() + randomExp; // 총 경험치 합

			if (newExp >= 100) {
				// 레벨업 처리
				int levelCount = newExp / 100; // 레벨업 카운트
				int remainExp = newExp % 100; // 남은 경험치
				setExp(remainExp);
				this.levelUp(levelCount); // 레벨업 메서드 실행
				System.out.println(levelCount + " 만큼 레벨업하였습니다.");
			} else {
				// 경험치 추가
				this.exp = newExp; // 100이 안될경우 그냥 경험치 저장
				System.out.println(getExp() + " 경험치가 올랐습니다.");
			}
		} else {
			// 공격 실패
			System.out.println("공격에 실패하였습니다.");
		}
	}

	abstract public void hello();  //추상메서드가 한개라도 존재하면 그 클래스는 추상 클래스여야 한다 !!
//	{
//		// 피카츄는 삐까삐까, 꼬부기는 꼬북꼬북 등의 울음소리를 출력한다.
//		System.out.println("힝~");
//	}

	public void levelUp(int i) {
		// 경험치가 100을 채울때마다 레벨은 +1
		this.level = this.level + i;
	}

	@Override
	public String toString() {
//		[피카츄 전기타입 Lv5 exp10]
		return "["+ this.name +" "+ this.type +"타입 Lv."+ this.level+" exp."+ this.exp + "]";
	}

}

class Myu extends Pokemon {
	Myu() {
		super("에스퍼", "뮤");
	}

	@Override
	public void hello() {
		System.out.println("뮤뮤뮤");
	}
}

class Jyujyu extends Pokemon {
	Jyujyu() {
		super("물", "쥬쥬");
	}

	@Override
	public void hello() {
		System.out.println("쮸쮸쮸");
	}
}

class Dudu extends Pokemon {
	Dudu() {
		super("노멀", "두두");
	}

	@Override
	public void hello() {
		System.out.println("뚜뚜뚜");
	}
}


public class PokemonGame {

	public static boolean isEmpty(int cnt) {
		if (cnt <= 0) {
			System.out.println("소유한 포켓몬이 없습니다!");
			return true;
		}
		return false;
	}

	public static boolean isFull(int cnt, Pokemon[] datas) {
		if (cnt >= datas.length) {
			System.out.println("더이상 포켓몬을 소유할 수 없습니다!");
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		//변수
		int menu; //메뉴값입력
		int cnt=0; //저장되어있는 포켓몬 수
		Pokemon[] myPokeList = new Pokemon[6]; //내포켓몬 저장할 배열

		while (true) {
			System.out.println("===================\n"
		               + " ★☆★포켓몬 게임★☆★\n"
		               + "   (),,,()\n"
		               + " ϞϞ(๑◕ܫ◕๑)\n"
		               + "   ( Ｕ Ｕ)\n"
		               + "    Ｕ Ｕ\n"
		               + "===================\n"
		               + "0. 게임종료\n"
		               + "1. 전투시작\n"
		               + "2. 전체 상태 출력\n"
		               + "3. 울음소리 듣기\n"
		               + "4. 포켓몬 잡기\n"
		               + "===================");
			System.out.println();
			while (true) {
				System.out.print("메뉴를 입력해주세요 : ");
				menu = sc.nextInt();
				if (menu >= 0 && menu <= 4) {
					break;
				}
				else{
					System.out.println("잘못된 입력입니다.");
					System.out.print("다시 입력하세요 >>");
					continue;
				}
			}
			if (menu == 0) {
				System.out.println("게임을 종료합니다.");
				break;
			}
			else if (menu == 1) {//전투
				if(isEmpty(cnt)) {
					continue;
				}
				
				while (true) {
					System.out.println("====================");
					System.out.println("함께할 포켓몬을 골라주세요!");
					System.out.println("====================");

					for (int i = 0; i < cnt; i++) { // 현재 보유한 포켓몬 리스트 출력
						System.out.println((i + 1) + ". " + myPokeList[i].getName());
					}

					System.out.println("====================");

					System.out.print("어떤 포켓몬을 선택하시겠습니까? 이름 옆 번호를 입력해주세요! : ");
					int choice = sc.nextInt(); // 선택할 포켓몬 번호 입력

					if (choice > 0 && choice <= cnt) { // 유효성 검사
						Pokemon selectedPoke = myPokeList[choice - 1]; // (입력값 -1) 선택한 포켓몬 객체
						System.out.println("선택한 포켓몬: " + selectedPoke.getName());

						System.out.println("이 포켓몬으로 공격하시겠습니까? (1: 공격 / 2: 포켓몬 선택 / 0: 종료)");
						System.out.print("숫자 입력 : ");
						int attPoke = sc.nextInt(); // 공격 여부 입력 받고

						if (attPoke == 1) {
							selectedPoke.attack(); // 공격 = 1
						}
						else if (attPoke == 2) {
							System.out.println("포켓몬을 다시 선택합니다."); // 포켓몬 재선택 = 2
						}
						else if (attPoke == 0) {
							System.out.println("전투를 종료합니다.");
							break; // 1, 2 외의 답 = 게임종료 플래그
						}
						else {
							System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
						}
					}
					else {
						System.out.println("잘못된 입력입니다. 다시 선택해주세요."); // 유효성 검사
					}

					System.out.println("====================");
					System.out.println("공격을 계속하시길 원하시면 '1'을 눌러주세요!");
					System.out.println("숫자로 입력해주세요! 그 외의 답은 전투를 종료시킵니다!");
					int again = sc.nextInt(); // 게임 계속 여부 입력
					if (again != 1) { // 1 아닐때 반복 종료.
						break; // 게임 종료 플래그 설정
					}
				}// 여기까지가 'while'반복문 걸리는 곳.
				System.out.println("전투를 종료합니다."); // 게임 종료 메시지
			}
			else if (menu == 2) {//가지고 있는 전체 포켓몬 정보
				if(isEmpty(cnt)) {
					continue;
				}
				
				for(int i=0;i<cnt;i++) {
					System.out.println(myPokeList[i]);
				}
			} 
			else if (menu == 3) {//선택한 포켓몬 울음소리 출력
				if(isEmpty(cnt)) {
					continue;
				}
				//울음소리 출력
				System.out.println("포켓몬 이름을 입력하세요");
				String findName = sc.next();
				boolean found = false;
				for (int i = 0; i < cnt; i++) {
					if(findName.equals(myPokeList[i].getName())) {
						myPokeList[i].hello();// 중복출력 제거 
						found= true;
						break;
					}

				}
				if(!found) {
					System.out.println("해당 포켓몬이 없어서 울지못해요");
				}

			} 
			else if (menu == 4) {
				if(isFull(cnt, myPokeList)) {
					continue;
				}
				
				int subMenu;//메뉴 입력값
				Pokemon[] catchPoke = new Pokemon[5];
				//메뉴로 제공할 포켓몬 5마리 리스트 만들기
				//확률지정 myuProb + jyujyuProb + duduProb 총합 100이 되어야함
				int myuProb = 2; //뮤 출현 확률
				int jyujyuProb = 49; //쥬쥬 출현 확률
				int duduProb = 49; //두두 출현 확률
				int prob = 89; //잡기성공확률 지정 (0(완전불가)~100(무조건성공))

				//확률 검증 (확률지정에 오류가 있다면 프로그램이 실행되지 않음)
				if(!(myuProb + jyujyuProb + duduProb == 100)) {
					//확률 총합이 100이 아니게 설정해놓았을 때 실행되는 코드 (개발자 확인용)
					System.out.println("-===[오류발생]===-");
					System.out.println("포켓몬 확률 지정에 오류가 있어 프로그램을 실행할 수 없습니다.");
					System.out.println((myuProb + jyujyuProb + duduProb)+" != 100");
					continue;
				}
				for(int i=0;i<catchPoke.length;i++) {//배열 길이만큼 반복하여 저장
					int randNum = rand.nextInt(100);
					//확률에 따라 두두 쥬쥬 뮤를 저장함
					if(myuProb+jyujyuProb < randNum && randNum < 100) {//두두
						catchPoke[i] = new Dudu();
					}
					else if(myuProb < randNum && randNum <= myuProb+jyujyuProb) {//쥬쥬
						catchPoke[i] = new Jyujyu();
					}
					else if(0 <= randNum && randNum <= myuProb) {//뮤
						catchPoke[i] = new Myu();
					}
				}//for(int i=0;i<catchPoke.length;i++)
				while(true) {//올바른 값을 입력받을 때까지 입력값을 반복하는 반복문
					System.out.println("☆*: .｡. _ .｡.:*☆");
					for(int i=0; i<catchPoke.length; i++) {
						System.out.println((i+1)+". "+catchPoke[i].getName()+", "+catchPoke[i].getType()+" 타입");
					}
					System.out.println("☆*: ˙\"˙ - ˙\"˙:*☆");
					System.out.println("0. 메뉴로 돌아가기");
					System.out.print("번호 선택 >> ");
					subMenu = sc.nextInt();//메뉴 입력값 받기

					if(subMenu == 0) {// 메뉴로 돌아가기
						break;
					}
					else if (1<= subMenu && subMenu <= catchPoke.length){ //출현한 포켓몬 수의 범위
						int randNum = rand.nextInt(100);
						if(randNum < prob) {//잡는데 성공함!!
							myPokeList[cnt++] = catchPoke[subMenu-1];
							System.out.println(catchPoke[subMenu-1]+" 을 잡았습니다!");
							break;
						}
						else {//잡는데 실패함
							System.out.println(catchPoke[subMenu-1]+" 을 놓쳤습니다...");
							break;
						}
					}
					else { //메뉴 외의 입력값
						System.out.println("올바른 입력값을 입력해주세요.");
					}
				}//while
				//포켓몬 잡기 종료
			}
		}
	}
}


