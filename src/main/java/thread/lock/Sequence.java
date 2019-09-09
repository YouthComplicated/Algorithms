package thread.lock;


public class Sequence {
	
	private int value;

	/**
	 * @return
	 */
	public  int getNext() {
		MyLock myLock = new MyLock();
		myLock.lock();
		int a = value ++;
		myLock.unlock();
		return a;
	}
	
	public static void main(String[] args) {
		
		Sequence s = new Sequence();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					System.out.println(Thread.currentThread().getName() + " " + s.getNext());
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					System.out.println(Thread.currentThread().getName() + " " + s.getNext());
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					System.out.println(Thread.currentThread().getName() + " " + s.getNext());
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
	}

}
