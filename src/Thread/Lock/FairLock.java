package Thread.Lock;

import java.util.ArrayList;
import java.util.List;

/**
 * 公平锁设计
 */
public class FairLock {

	private boolean isLocked = false;
	/**
	 * 当前被锁住的线程
	 */
	private Thread lockingThread = null;
	/**
	 * 按照时间的先后顺序进行入队
	 */
	private List<QueueObject> waitingThreads = new ArrayList<>();

	public void lock() throws InterruptedException {
		QueueObject queueObject = new QueueObject();
		//todo 是否会压入相同的线程多次 ???
		synchronized (this) {
			waitingThreads.add(queueObject);
		}

		try {
			queueObject.doWait();
		} catch (InterruptedException e) {
			//todo 什么时候出现这种情况 ???
			synchronized (this) {
				waitingThreads.remove(queueObject);
			}
			throw e;
		}
	}

	public synchronized void unlock() {
		if (this.lockingThread != Thread.currentThread()) {
			throw new IllegalMonitorStateException("Calling thread has not locked this lock");
		}
		isLocked = false;
		lockingThread = null;
		if (waitingThreads.size() > 0) {
			waitingThreads.get(0).doNotify();
		}
	}
}