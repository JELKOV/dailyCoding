package class01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {

		String filePath="C:\\AHN-WorkSpace\\day020\\src\\class01\\";
		// 실습경로
		String fileName="result.txt";
		// 확장자를 반드시 함께 작성
		
		Scanner sc=new Scanner(System.in);
		System.out.print("사용자 이름 입력 >> ");
		String name=sc.next();
		int cnt=3;
		
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(filePath+fileName);
			
			BufferedWriter writer=new BufferedWriter(fileWriter);
			
			writer.write(name+"님이 "+cnt+"번만에 정답을 맞추셨습니다! :D");
			writer.close();
		} catch (IOException e) {
			System.out.println("파일 입출력 에러가 발생했습니다!");
		}		
		
	}
}
