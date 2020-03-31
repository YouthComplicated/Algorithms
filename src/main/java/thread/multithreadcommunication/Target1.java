package thread.multithreadcommunication;

public class Target1 implements Runnable {
	
	private WaitTest1 demo;
	
	public Target1(WaitTest1 demo) {
		this.demo = demo;
	}

	@Override
	public void run() {
		demo.set();
	}

}
