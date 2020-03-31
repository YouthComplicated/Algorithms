package thread.multithreadcommunication;

/**
 * wait与notify 线程通信
 *
 * 多个线程notifyAll
 */
public class WaitTest {
	
	private volatile int signal;
	
	public void set (int value) {
		this.signal = value;
	}
	
	public int get () {
		return signal;
	}


	public static void main(String[] args) {


		/**
		 * 锁住同一个对象
		 */
		WaitTest d = new WaitTest();
		new Thread(()->{
			synchronized (d) {
				System.out.println(Thread.currentThread().getName()+"修改状态的线程执行...");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				d.set(1);
				System.out.println(Thread.currentThread().getName()+"状态值修改成功...");
				d.notify();
			}
		},"A").start();


		new Thread(()->{
			synchronized (d) {
				// 等待signal为1开始执行，否则不能执行
				try {
					d.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 当信号为1 的时候，执行代码
				System.out.println(Thread.currentThread().getName()+"模拟代码的执行...");
			}
		},"B").start();


		new Thread(()->{
			synchronized (d) {
				while(d.get() != 1) {
					System.out.println(Thread.currentThread().getName()+"自选...");
					try {
						d.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// 当信号为1 的时候，执行代码
				System.out.println(Thread.currentThread().getName()+"模拟代码的执行...");
				d.notify();
			}
		},"E").start();



		/**
		 * wait和notify 如果不被同步代码块包裹会出现java.lang.IllegalMonitorStateException
		 */
//		new Thread(()->{
//			// 等待signal为1开始执行，否则不能执行
//			while(d.get() != 1) {
//				System.out.println(Thread.currentThread().getName()+"自选...");
//				try {
//					d.wait();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//			//当信号为1的时候，执行代码
//			System.out.println(Thread.currentThread().getName()+"模拟代码的执行...");
//		},"C").start();


	}

}
