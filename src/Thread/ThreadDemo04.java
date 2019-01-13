
package Thread;


public class ThreadDemo04 {

	public static void main(String[] args) {
		Thread thread = new Thread(()-> {
				while (true) {
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.out.println("我是子线程....");
				}
			}
		);
		thread.setDaemon(true);
		thread.start();
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("我是主线程....i:"+i);
		}
	}

}
