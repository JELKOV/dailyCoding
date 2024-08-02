package class02;

import java.util.HashMap;
import java.util.Map;

public class Test01 {
	public static void main(String[] args) {
		//key - value
		//key : 다른데이터와 중복되어서는 안된다.
		//value(데이터): 실제데이터
//		Map<키값의 자료형, 데이터 값의 자료형>
//		Map<Integer, String> map = new Map<Integer, String>();
		//맵은 추상클래스 이기 떄문에 new 쓰면 안된다.
		//포켓 몬스터/ new 피카츄
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1001, "홍길동");
		map.put(1002, "아무무");
		System.out.println(map.containsKey(1001));// 1001번 키가 있니 
		System.out.println(map.containsValue("홍길동"));// 홍길동 있니
		System.out.println(map.get(1003)); //1003 키좀 불러줘
//		map.clear();
//		System.out.println(map.isEmpty());// 비어 있니
		System.out.println(map.size()); // 한쌍이 하나다 !! 
		System.out.println(map);
	}

}
