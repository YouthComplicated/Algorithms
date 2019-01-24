package Thread.MultithreadCommunication;


/**
 * 借助volatile修饰信号量[标志位]和自旋实现线程之前通信
 */
public class Demo {
	
	private volatile int signal;
	
	public void set (int value) {
		this.signal = value;
	}
	
	public int get () {
		return signal;
	}
	
	public static void main(String[] args) {
		Demo d = new Demo();
		new Thread(()->{
			System.out.println("修改线程...");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			d.set(1);
			System.out.println("状态修改成功...");
		}).start();
		
		
		new Thread(()->{
			//等待signal为1开始执行，否则不能执行
			while(d.get() != 1) {
				/**
				 * 不断的自旋浪费资源
				 */
				System.out.println("自旋-----");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("模拟代码的执行...");
		}).start();
	}

}
