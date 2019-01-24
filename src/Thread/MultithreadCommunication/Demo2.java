package Thread.MultithreadCommunication;

/**
 * wait与notify 线程通信
 */
public class Demo2 {
	
	private volatile int signal;
	
	public void set (int value) {
		this.signal = value;
	}
	
	public int get () {
		return signal;
	}

	public static void main(String[] args) {
		Demo2 d = new Demo2();
		new Thread(()->{
			synchronized (d) {
				System.out.println("修改状态的线程执行...");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				d.set(1);
				System.out.println("状态值修改成功。。。");
				d.notify();
			}
		}).start();

		new Thread(()->{
			synchronized (d) {
				// 等待signal为1开始执行，否则不能执行
				while(d.get() != 1) {
					/**
					 * 当线程调用wait()方法后会进入等待队列（进入这个状态会释放所占有的所有资源，与阻塞状态不同），
					 * 进入这个状态后，是不能自动唤醒的，必须依靠其他线程调用notify()或notifyAll()方法才能被唤醒
					 */
					try {
						d.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// 当信号为1 的时候，执行代码
				System.out.println("模拟代码的执行...");
			}
		}).start();
	}

}
