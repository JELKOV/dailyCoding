package day007;

class Animal {
	String type; // 타입이 없는동물이 없기 때문에 강제성이 보이다.
	String name;

	Animal(String type) { // 타입이 여러개이면 인자가 많은것을 재사용하게 됨
		this(type, "무명");
	}

	Animal(String type, String name) {
		this.type = type;
		this.name = name;
	}

	void hello() {
		System.out.println(this.type + " " + this.name);
	}
}

class Cat extends Animal { // 시험 왜 에러가 낫을까 ?? -> 기본생성자가 없기때문에
	Cat() {
		this("나비");
	}

	Cat(String name) { // 기본생성자 ->> 인자가 많은 생성자
		super("고양이", name);
//		this.type="고양이";
//		this.name=name;
	}
	

	@Override
	void hello() {
		// TODO Auto-generated method stub
		System.out.println("야옹");
	}
	
}

class Dog extends Animal { // 시험 왜 에러가 낫을까 ?? -> 기본생성자가 없기때문에
	Dog() {
		this("똥개");
	}

	Dog(String name) { // 기본생성자 ->> 인자가 많은 생성자
		super("강아지", name);
	}

	@Override
	void hello() {
		// TODO Auto-generated method stub
		System.out.println("멍멍");
	}
	
}

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat 길고양이 = new Cat();
		Cat c = new Cat("구동이");
		길고양이.hello();
		c.hello();
		Dog d = new Dog("은비");
		d.hello();
		Animal a = new Cat("동동이");
		//동물이저장될수 있는 객체 a 고양이를 저장해 주세요
		//a가 뭐냐 하면 ?? 강아지 객체이다 !! 
		a.hello();//=>> 동적 바인딩이다 !! 

	}

}
