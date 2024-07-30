package class02;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); // 입력받을때
		int num;//
		int count=0; //짝수가 몇번 입력되었는지 확인하는 변수
		int [] odd = new int[5]; // 짝수 입력 배열
		double agv;//
		System.out.println("기존"+odd[0]);
		 while(true){//숫자의 값이 짝수일 경우에
		  System.out.print(" 정수를 입력하세요");
		  num = sc.nextInt();
		  if(num%2==0) {
			  count++;
			  odd[count]=num;
		   }
		  if(count==odd.length) {
			  break;
		   }
		 }
		     System.out.println("[");
		for(int i=0; i<odd.length; i++) {//배열 안에 넣기
			System.out.println(odd[i]+" ");
			}
             System.out.println("]");
         //합
         int sum=0;
         for(int i=0;i<odd.length;i++) {
             sum+=odd[i];
          }

         
         System.out.println("합"+ sum);
         
         
         //평균
         //단 평균은 소수점으로 출력
         double avg = sum* 1.0/odd.length;
         System.out.println("평균"+ avg);
	
	    // 그 짝수들 가운데가서 가장 작은 값
         int pivot=odd[0]; // 기준
         for(int i=1;i<odd.length;i++) {
        	 if(pivot > odd[i]) {
         }
          pivot=odd[i];
       }
         System.out.println("최소값은 "+pivot+"입니다.");
    }

		//짝수 배열 안에 있는 값은 반복문으로 합한다. 변수지정 빼놓기
		//짝수 배열 안에 있는 값을 반복문의 길이로 나눈다. double 사용해서 실수로 표현
		//그 짝수들 가운데서 가장 작은 값을 출력해라 
}
