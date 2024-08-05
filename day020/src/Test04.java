public class Test04 {
    private int value;

    public Test04(int value) {
        this.value = value;
    }

    public int plus() {
        class Cal { // 지역클래스
            public int add() {
            	System.out.println("3"+value);
                return value++;
            }
        }
        System.out.println("1"+value);
        Cal cal = new Cal();
        int a = cal.add();
        System.out.println("2"+value);
        return a;
    }

    public static void main(String[] args) {
        Test04 ie = new Test04(10);
        int b = ie.plus();
        System.out.println(b);
    }
}