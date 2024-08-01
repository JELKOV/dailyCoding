package hk;

public class Hk3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int a=1; a<=4; a++) { // 세로로 얼마나
			for(int i=a; i<4; i++) {// 가로로 얼마나
				System.out.print(" ");
			}
			for(int j=1; j<=(2*a-1); j++) {
				System.out.print("*");
			}
			System.out.println();//줄바꿈
		}

	}

}

