package hk;

public class Hk2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int a = 0; a < 5; a++) { // 세로로 얼마나
			for (int i = 0; i < a; i++) {// 가로로 얼마나
				System.out.print(" ");
			}
			for (int j = 0; j < 5 - a; j++) {
				System.out.print("*");
			}
			System.out.println();// 줄바꿈
		}

	}

}
