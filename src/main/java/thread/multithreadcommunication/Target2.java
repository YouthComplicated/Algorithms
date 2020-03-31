package thread.multithreadcommunication;

public class Target2 implements Runnable {
	
	private WaitTest1 demo;

	public Target2(WaitTest1 demo) {
		this.demo = demo;
	}

	@Override
	public void run() {
		demo.get();
	}

}
