package jvm.ReferenceTest;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class CheckGc {

    public static void main(String[] args) throws InterruptedException {

        //创建一个引用队列
        ReferenceQueue queue = new ReferenceQueue();

        // 创建弱引用，此时状态为Active，并且Reference.pending为空，当前Reference.queue = 上面创建的queue，并且next=null
        WeakReference reference = new WeakReference(new Object(), queue);
        System.out.println(reference);
        // 当GC执行后，由于是虚引用，所以回收该object对象，并且置于pending上，此时reference的状态为PENDING
//        System.gc();
        //Thread.sleep(3000);

        /* ReferenceHandler从pending中取下该元素，并且将该元素放入到queue中，此时Reference状态为ENQUEUED，Reference.queue = ReferenceENQUEUED */
        /* 当从queue里面取出该元素，则变为INACTIVE，Reference.queue = Reference.NULL */
        Reference reference1 = queue.remove();
        System.out.println(reference1);
    }


}
