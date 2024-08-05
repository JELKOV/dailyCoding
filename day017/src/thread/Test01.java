package thread;
class Thread01 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			System.out.println(i+"첫번째 스레드 일하는중 ....");
		}
	}

}
// 강제 
// 인터페이스를 강제할때 쓰는이유는 추상메서드의 오버라이딩 강제 때문입니다.
class Thread02 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			System.out.println(i+"두번째 스레드 일하는중 ....");
		}
		
	}

}
public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread01 t1 = new Thread01();
		Thread t2 = new Thread(new Thread02());
		
		t1.start();
		t2.start();
		
		for(int i=1;i<=5;i++) {
			System.out.println(i+"초....");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
