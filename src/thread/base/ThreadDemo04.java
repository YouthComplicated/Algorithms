
package thread.base;

/**
 * 守护线程和普通线程的区别
 *
 * 守护线程与普通线程的唯一区别是：当JVM中所有的线程都是守护线程的时候，JVM就可以退出了；
 * 如果还有一个或以上的非守护线程则不会退出。（以上是针对正常退出，调用System.exit则必定会退出）
 *
 * 所以setDeamon(true)的唯一意义就是告诉JVM不需要等待它退出，让JVM喜欢什么退出就退出吧，不用管它。
 *
 *
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
