//package class02;
//class Car{
//	String name;
//	static int speed=0;
//	int maxSpeed;
//	
//	Car(){
//		this.maxSpeed = 120;
//		this.name ="무명";
//	}
//	Car(String name, int x){
//		this.maxSpeed =x;
//		this.name = name;
//	}
//	
//	void speedUp() {
//		Car.speed += 50;		
//	}
//	
//	void speedDown() {
//		Car.speed -= 100;	
//	}
//	
//	void speedUp(int x) {
//		Car.speed += x;		
//	}
//}
////요구사항
////1. 현재속도는 반드시 0으로 시작
////2. 최고속도를 지정해주지 않으면 기본값 120
////3. 차주이름은 등록하지 않으면 "무명"으로 저장됨
////4. speedUP()-> 속도 50증가
////5. speedDown() -> 속도 100 감소
////6. speedUP(값)-> 해당 값 만 큼 속도가 증가
//public class Test02 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		Car c10 = new Car();
//		System.out.println(c10.name);
//		c10.speedUp();
//		c10.speedUp(100);
//		c10.speedDown();
//		System.out.println(c10.speed);
//		Car c11 = new Car("내차", 200);
//		System.out.println(c11.name);
//
//	}
//
//}
