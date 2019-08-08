
package thread.base;

/**
 * 守护线程和普通线程的区别
 */
public class ThreadDemo04 {

	public static void main(String[] args) {
		Thread thread = new Thread(()-> {
				while (true) {
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle jdk.exception
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
				// TODO: handle jdk.exception
			}
			System.out.println("我是主线程....i:"+i);
		}
	}

}
