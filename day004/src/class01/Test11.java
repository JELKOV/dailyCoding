package class01;

public class Test11 {
	public static void test(int[] datas) {
		datas[0] = 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// new연산자: 개발자 메모리 영역에 공간을 만들어주세요
		// new로 제작한 변수를 전달하는 함수 ->
		// call by reference(참조에 의한 호출) 인자가 있는걸로 호출했을때만
		int[] datas = new int[3];
		for (int i = 1; i <= 3; i++) {
			datas[i - 1] = i * 10;
		}
		System.out.print("[");
		for (int data : datas) {
			// forEach문 향상된 for문 배열과 함께 사용하는 for문
			// for(배열에 저장된 자료형 변수명:배열명
			// 배열의크기만큼 수행함
			// index [0]부터 변수가 해당 인덱스의 데이터를 대신함;
			// heap 메모리가 바뀌면 일반메모리도 영향을 받는다
			System.out.print(data + " ");
		}
		System.out.print("]");
		// 개발자 메모리 영역 (heap메모리)
		// 일반 영역
		test(datas);
		System.out.print("[");
		for (int data : datas) {
			// forEach문 향상된 for문 배열과 함께 사용하는 for문
			// for(배열에 저장된 자료형 변수명:배열명
			// 배열의크기만큼 수행함
			// index [0]부터 변수가 해당 인덱스의 데이터를 대신함;
			// heap 메모리가 바뀌면 일반메모리도 영향을 받는다
			System.out.print(data +" ");
		}
		System.out.print("]");

	}

}
