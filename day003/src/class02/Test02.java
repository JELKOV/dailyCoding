package class02;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); // 입력받을때
		int [] student = new int[3];
		for(int i=0; i<student.length; i++) {
			System.out.print((i+1)+"번 학생의 점수를 입력해주세요");
			student[i] = sc.nextInt();
		}
		System.out.print("점수를 알고 싶은 학생의 번호 입력");
		int num= sc.nextInt();
		
		System.out.println(num+"번 학생의 점수는"+student[num-1]+"점입니다.");
		
		for(int i=0; i<student.length; i++) {
			while(true) {
				System.out.print((i+1)+"학생의 점수를 입력해주세요");
				student[i]= sc.nextInt();
				if(0<=student[i] && student[i]<=100) {
					break;
				}
				System.out.print("점수를 제대로 입력해주세요");
			}
			int number;
			while(true) {
				System.out.print("점수를 알고싶은 학생의 번호입력");
				number= sc.nextInt();
				if(1<=num && num<=student.length) {
					break;
				}
				System.out.print("번호를 제대로 입력해주세요");
			}
		}
		

	}

}
