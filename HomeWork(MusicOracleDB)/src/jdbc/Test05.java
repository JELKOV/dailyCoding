package jdbc;

import java.util.ArrayList;

public class Test05 {
	static int func(String str){ 
		System.out.print(str);
		return 10;
	}

	public static void main(String[] args){
		ArrayList<Integer> datas=new ArrayList<Integer>();;
		datas.add(-5);
		datas.add(-1);
		datas.add(0);
		datas.add(1);
		datas.add(5);
		System.out.println(datas);
		for(int i=-1;i<5;i++) {
			try {
				System.out.println(10/datas.get(i));
			} catch(Exception e) {
				if(i<0) {
					System.out.println("HELLO");
				}
				else {
					System.out.println("JAVA");
				}
			}
		}
	}

}