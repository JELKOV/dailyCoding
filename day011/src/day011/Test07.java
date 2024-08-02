//package day011;
//
//import java.util.Random;
//
//interface CharacAction{
//	boolean attack();
//}
//class Charac implements CharacAction {
//	private String name;
//	private int level;
//	private Weapon weapon;
//	
//	Charac(String name){
//		this(name, null);
//	}
//	
//	
//	Charac(String name, Weapon weapon) {
//		this.name=name;
//		this.level=10;
//		this.weapon=weapon;
//	}
//	
//	@Override
//	public boolean attack() {
//		//캐릭터가 무기를 가졌다면, 무기로 공격
//		//캐릭터에게 무기가 없다면, 맨손으로 공격
//		if(this.weapon != null) {
//			
//			if(this.weapon.attack()) {
//				this.level++;
//				return true;
//			}
//			System.out.println("무기공격 실패");
//		}
//		else {
//			System.out.println("맨손으로 공격...");
//		}
////		if(무기를 가졌다면) {
////			무기로 공격;
////			if(성공했다면) {
////				레벨++
////			}
////		}
////		else {
////			맨손 공격;
////		}
//		return false;
//	}
//}
//
//abstract class Weapon implements CharacAction {
//	String name;
//	Weapon(String name){
//		this.name=name;
//	}
//
//	@Override
//	abstract public boolean attack();
//	
//}
//
//class Gun extends Weapon{
//
//	Gun() {
//		super("총"); //기본생성자
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public boolean attack() {
//		// TODO Auto-generated method stub
//		System.out.println("빵야!");
//		return true; // 100프로로 성공하는 공격
//	}
//	
//}
//
//class Fork extends Weapon{
//
//	Fork() {
//		super("포크");
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public boolean attack() {
//		// TODO Auto-generated method stub
//		if(new Random().nextBoolean()) {
//			System.out.println("포크던지기 ");
//			return true;
//		}
//		System.out.println("실패");
//		return false;
//	}
//	
//}
//
//public class Test07 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
