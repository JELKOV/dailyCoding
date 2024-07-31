package class04;

public class Test02 {

	public static void main(String[] args) {
		
   // 연습문제 1) 

   // 1 ~ 10 사이의 정수중에서 짝수만 출력해주세요. 
		
//	 for(int i = 1; i <= 10; i++) {
//		 if(i % 2 == 0) { // 짝수라면 
//			 System.out.println(i);
//		 }
//	 }
//	 

//  연습문제 2)
//
//  1 ~ 10 사이의 정수를 모두 출력할겁니다. 
//
//  홀수라면 출력하지 말아주세요. 
 
	 for(int i = 1; i <= 10; i++) {
		 if(i % 2 == 1) {  // 홀수라면 
			 
			 continue;   // 아래의 기능을 생략해줘 ~ 
			             // 자신과 가장 가까운 반복문의 처음으로 "즉시" 이동 
			             // " 반복문을 계속할건데 멈추고 싶진 않아 " 
			             // 근데 ~~ 한 경우라면 그때만 안하고 싶어 
		 }
		System.out.println(i);
	 }

	}

}
