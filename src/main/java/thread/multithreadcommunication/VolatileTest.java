package thread.multithreadcommunication;


/**
 * 借助volatile修饰信号量[标志位]和自旋实现线程之前通信
 *
 *
 * 两个线程以上不能使用单个标志位+自选 实现多个线程的争抢
 *
 *
 */
public class VolatileTest {
	
	private volatile int signal;
	
	public void set (int value) {
		this.signal = value;
	}
	
	public int get () {
		return signal;
	}
	
	public static void main(String[] args) {

		VolatileTest d = new VolatileTest();

		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"修改线程...");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			d.set(1);
			System.out.println(Thread.currentThread().getName()+"状态修改成功...");
		},"A").start();
		
		
		new Thread(()->{
			//等待signal为1开始执行，否则不能执行
			while(d.get() != 1) {
				/**
				 * 不断的自旋浪费资源
				 */
				System.out.println(Thread.currentThread().getName()+"自旋-----");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"模拟代码的执行...");
		},"B").start();

		new Thread(()->{
			//等待signal为1开始执行，否则不能执行
			while(d.get() != 1) {
				/**
				 * 不断的自旋浪费资源
				 */
				System.out.println(Thread.currentThread().getName()+"自旋-----");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"模拟代码的执行...");
		},"C").start();


	}

}
