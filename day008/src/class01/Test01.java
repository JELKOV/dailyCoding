package class01;

import java.util.Random;

//도구 클래스
class Tool {
	String name;

	Tool(String name) {
		this.name = name;
	}

	void action() {
		System.out.println("액션");
	}
}

class Fishing extends Tool {
	Fishing() {
		super("낚시대");
	}

	@Override
	void action() {
		System.out.println("생선낚시");
	}

}

class Dragonfly extends Tool {
	Dragonfly() {
		super("잠자리채");
	}

	@Override
	void action() {
		System.out.println("곤충채집");
	}

}

//주민클래스
class Citizens {
	// 클래스(타입, 자료형) : 주민, 고양이 ,개구리
	String type;// 타입 무조건 있어야 한다.
	String name;// 생성할때 반드시 이름을 지정하면서 만들어야함
	static String[] emotions = { "행복해", "무난해", "슬퍼", "화가나" };
	static Random rand = new Random(); // 매번 hello를 돌릴떄마다 new로 생성해줄 필요가 없다.

	Citizens(String type, String name) {
		this.type = type;
		this.name = name;
	}

	// hello() // 행복함/ 무난함/ 슬픔/ 화남 하나의 감정을 랜덤하게 출력한다.
	void hello() {
//		System.out.println("emotions");
		int ranIndex = Citizens.rand.nextInt(Citizens.emotions.length);
		System.out.print("오늘정말" + Citizens.emotions[ranIndex]);
	}

	void action(Tool tool) {
		// action(String 도구)
		// 반복문을 돌려서 바꾼다.
		// 객체와 객체 상호작용에 대해서 공부해보자 !!
		// 아이폰 애플워치 두개의 객체가 같은 메서드를 수행하는 경우
		// 이름을 맞춰 놓는게 중요하다.
//        String[] tools = {"잠자리채", "낚시대", "삽"};
//        String[] actions = {"곤충채집", "생선 낚시", "땅파기"};
//        boolean toolFound = false;
//
//        for (int i = 0; i < tools.length; i++) {
//            if (tools[i].equals(tool)) {
//                System.out.println(tools[i] + " 가지고 " + actions[i] + "합니다");
//                toolFound = true;
//                break;
//            }
//        }
//        if (!toolFound) {
//            System.out.println("해당 장비가 없습니다");
//        }
//    }
		tool.action(); // ㄷㅈㅂㅇㄷ

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.type+"주민"+this.name;
	}
	
}

//고양이 클래스
class Cat extends Citizens {
	Cat(String name) {
		super("고양이", name);
	}

	@Override
	void hello() {
		// TODO Auto-generated method stub
		super.hello();
		System.out.println("야옹");
	}

}

//개구리 클래스
class Frog extends Citizens {
	Frog(String name) {
		super("개구리", name);
	}

	@Override
	void hello() {
		// TODO Auto-generated method stub
		super.hello();
		System.out.println("개굴");
	}

}

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 주민[]datas = new 주민[3];
		Citizens[] datas = new Citizens[3];
		datas[0] = new Cat("1호");
		datas[1] = new Frog("레이니");
		datas[2] = new Frog("아이다");
		
		for(int i=0; i<datas.length; i++) {
			datas[i].hello();
		}
//		for(배열의 타입 변수명: 배열의 이름) {
//			
//		}
		for(Citizens citizens:datas) {
			citizens.hello();
		}
		for(Citizens citizens:datas) {
			Tool tool=new Fishing();
			citizens.action(tool);
		}
		for(Citizens citizens:datas) {
			System.out.println(citizens);
		}

	}
}

//new 고양이(히죽);
//new 고양이(1호);

//클래스(타입, 자료형) : 주민, 고양이 ,개구리

//객체(변수, 값, 실행 메서드 실행주체) : 히죽, 1호 ,레이니, 아이다 ....