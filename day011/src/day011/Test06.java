package day011;

import java.util.Random;

interface CharacAction {
   boolean attack();
}
class Charac implements CharacAction {
   String name;
   int level;
   Weapon weapon;
   Charac(String name){
      this(name,null); // null 없다 == 맨손
   }
   Charac(String name,Weapon weapon){
      this.name=name;
      this.level=10;
      this.weapon=weapon;
   }
   @Override
   public boolean attack() {
      // 캐릭터가 무기를 가졌다면, 무기로 공격
      // 캐릭터에게 무기가 없다면 맨손으로 공격합니다...
      // 무기를 이용한 공격이 성공한다면, 레벨이 +1 증가합니다.
      
      if(this.weapon != null) {
         
         if(this.weapon.attack()) {
            this.level++;
            return true;
         }
         System.out.println("무기공격 실패...");
      }
      else {
         System.out.println("맨손으로 공격...");
      }
      
      
      return false;
   }
}
abstract class Weapon implements CharacAction { // 포켓몬스터 : 추상클래스
   String name;
   Weapon(String name){
      this.name=name;
   }
   abstract public boolean attack(); // : 추상메서드
}
class Fork extends Weapon {

   Fork() {
      super("포크");
   }

   @Override
   public boolean attack() {
      if(new Random().nextBoolean()) {
         System.out.println("포크던지기~~");
         return true;
      }
      System.out.println("포크가 빗나갔습니다...");
      return false;
   }
   
}
class Gun extends Weapon { // 피카츄,파이리,...

   Gun() {
      super("총");
   }

   @Override
   public boolean attack() {
      System.out.println("빵야!");
      return true; // 백프로 성공하는 공격
   }
   
}
public class Test06 {
   public static void main(String[] args) {
      
   }

}
