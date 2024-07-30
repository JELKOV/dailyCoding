package class01;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDelTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        
        // 특정 인덱스의 요소 삭제
        arrayList.remove(3); // 세 번째 요소 (인덱스 2) 삭제

        // 특정 값의 요소 삭제 (첫 번째 등장하는 값)
        arrayList.remove(Integer.valueOf(4)); // 값 4 삭제

        System.out.println("ArrayList after removal: " + arrayList);
    }
}