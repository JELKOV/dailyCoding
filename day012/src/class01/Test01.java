package class01;

import java.util.ArrayList;

//컬렉션 프레임 워크
//배열리스트
public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열[] 개수가 정해져 있다
		// 배열리스트는 갯수 무제한
		ArrayList<Integer> al = new ArrayList<Integer>();
//		al.add(3.14);
//		al.add("apple");
		al.add(10);
		al.add(20);
		al.add(30); // 요소 추가
		al.add(1,123); // 요서 어디에 추가 
//		al.clear();
		boolean ans = al.contains(124);  // 존재여부
		System.out.println(ans); // 
		System.out.println(al.get(1)); // 1번 인덱스 가져다줘
		ans= al.isEmpty(); // 비어 있니 ?
		System.out.println(ans);
		System.out.println("배열길이"+al.size()); // 배열의 길이
//		al.remove(1); // 제거해줘
		System.out.println(al.size());
		System.out.println(al);
		// 최상위 Object 클래스로 부터 재정의 되어 있다 !! 
		// toString() 오버라이딩

	}

}
