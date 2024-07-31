package class04;

// 🧷 문제 2
//
// 1 ~ 10까지의 정수를 역순으로 출력해주세요.
//
// ex) 10 9 8 7 6 5 4 .... 1


public class PracticeTest02 {

	public static void main(String[] args) {
		
		System.out.println("1 ~ 10까지의 정수를 역순으로 출력하는 프로그램 입니다.");
		// 어떤 프로그램인지 설명해줍니다. 
		
		System.out.println("역순 출력");
	 // 아무말도 없이 그냥 숫자만 나오면 밋밋하니까 
     // 역순으로 출력될것을 알려주는 코드를 작성했습니다.
	    
		for(int i = 1; i < 11; i++) {
	   // 범위가 정해져 있으니 for문을 사용해주었습니다. 
			System.out.print(11-i);
			// 역순으로 출력해야 하는데 
			// i가 1부터 시작하니까 출력되는 부분에 11을 넣어서 
			// 처음 시작값이 10으로 출력되게 합니다.
			// 그렇게 for문을 돌려보면 
			// 역순으로 잘 출력되는 모습을 보실 수 있습니다. 
		}
	

	}

}
