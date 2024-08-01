package class01;

import java.util.Random;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] name = new String[4];
		name[0]="이재형";
		name[1]="조충현";
		name[2]="허나윤";
		name[3]="이준열";
		
		Random rand = new Random();
		int randNum=rand.nextInt(4);
		//0~3 ->1~4
		System.out.println(name[randNum]);

	}

}
