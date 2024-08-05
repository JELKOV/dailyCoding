package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test02 extends Throwable {

    public static void main(String[] args) {
        int[] datas = {10, 0, -1, 2, 3};

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("첫번째 정수 입력>>");
            int num = sc.nextInt();
            System.out.print("두번째 정수 입력>>");
            int num2 = sc.nextInt();

            System.out.println(datas[num] / datas[num2]);
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("인덱스 값이 맞지 않아서 0으로 대체합니다");
            int num = 0;
            Scanner sc = new Scanner(System.in);
            System.out.print("두번째 정수 입력>>");
            int num2 = sc.nextInt();
            try {
                System.out.println(datas[num] / datas[num2]);
            } catch (ArithmeticException ee) {
                System.out.println("0으로는 나누기를 할 수 없습니다!");
            }
        } 
        catch (ArithmeticException e) {
            System.out.println("0으로는 나누기를 할 수 없습니다!");
        }
        catch (InputMismatchException e) {
            System.out.println("정수가 아닌 값을 입력했습니다. 다시 입력해주세요.");
            Scanner sc = new Scanner(System.in);
            System.out.print("첫번째 정수 입력>>");
            int num = sc.nextInt();
            System.out.print("두번째 정수 입력>>");
            int num2 = sc.nextInt();
            try {
                System.out.println(datas[num] / datas[num2]);
            } catch (ArithmeticException ee) {
                System.out.println("0으로는 나누기를 할 수 없습니다!");
            } catch (ArrayIndexOutOfBoundsException ee) {
                System.out.println("인덱스 값이 맞지 않아서 0으로 대체합니다");
                int defaultNum = 0;
                System.out.println(datas[defaultNum] / datas[num2]);
            }
        }
    }
}

