package class02;
class Car{
	String name;
	int speed;
	int maxSpeed;
	
	Car(){
		this("무명",120);
		System.out.println("car1");
	}
	Car(String name){
		this(name,120);
		System.out.println("car2");
	}
	Car(int maxSpeed){
		this("무명",maxSpeed);
		System.out.println("car3");
	}
	Car(String name, int maxSpeed){
		this.maxSpeed = maxSpeed;
		this.speed =0;
		this.name = name;
		System.out.println("car4");
	}
	
	void speedUp() {
		this.speed += 50;
		if(this.speed>this.maxSpeed) {
			this.speed=this.maxSpeed;
		}
	}
	
	void speedDown() {
		this.speed -= 100;
		if(this.speed<0) {
			this.speed=0;
		}
	}
	
	void speedUp(int x) {
		this.speed += x;
		if(this.speed>this.maxSpeed) {
			this.speed=this.maxSpeed;
		}
	}
}
//요구사항
//1. 현재속도는 반드시 0으로 시작
//2. 최고속도를 지정해주지 않으면 기본값 120
//3. 차주이름은 등록하지 않으면 "무명"으로 저장됨
//4. speedUP()-> 속도 50증가
//5. speedDown() -> 속도 100 감소
//6. speedUP(값)-> 해당 값 만 큼 속도가 증가
public class Test02teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car c10 = new Car();
		System.out.println(c10.name +" "+ c10.speed+" "+c10.maxSpeed);
		Car c12 = new Car("mycar");
		System.out.println(c12.name +" "+ c12.speed+" "+c12.maxSpeed);
		Car c13 = new Car(80);
		System.out.println(c13.name +" "+ c13.speed+" "+c13.maxSpeed);
		Car c14 = new Car("mycar", 80);
		System.out.println(c14.name +" "+ c14.speed+" "+c14.maxSpeed);
		System.out.println(c14.maxSpeed);
//		c10.speedUp();
//		c10.speedUp(100);
//		c10.speedDown();
//		System.out.println(c10.speed);
//		Car c11 = new Car("내차", 200);
//		System.out.println(c11.name);

	}

}
