package jvm.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.List;

public class GcTest {

    public static void main(String[] args) {


        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();

        StringBuilder temp = new StringBuilder();
        MemoryMXBean memory = ManagementFactory.getMemoryMXBean();
        System.out.println(temp.append("JVM堆内初始内存: ").append(memory.getHeapMemoryUsage().getInit() / 1024 / 1024).append("MB").toString());
        temp.setLength(0);
        System.out.println(temp.append("JVM堆内最大内存: ").append(memory.getHeapMemoryUsage().getMax() / 1024 / 1024).append("MB").toString());
        temp.setLength(0);
        System.out.println(temp.append("JVM堆内已使用内存: ").append(memory.getHeapMemoryUsage().getUsed() / 1024 / 1024).append("MB").toString());
        temp.setLength(0);
        System.out.println(temp.append("JVM堆内已提交内存: ").append(memory.getHeapMemoryUsage().getCommitted() / 1024 / 1024).append("MB").toString());
        temp.setLength(0);
        System.out.println(temp.append("JVM堆外初始内存: ").append(memory.getNonHeapMemoryUsage().getInit() / 1024 / 1024).append("MB").toString());
        temp.setLength(0);
        System.out.println(temp.append("JVM堆外已使用内存: ").append(memory.getNonHeapMemoryUsage().getUsed() / 1024 / 1024).append("MB").toString());
        temp.setLength(0);
        System.out.println(temp.append("JVM堆外已提交内存: ").append(memory.getNonHeapMemoryUsage().getCommitted() / 1024 / 1024).append("MB").toString());
        temp.setLength(0);
        System.out.println(temp.append("可用核心数量: ").append(Runtime.getRuntime().availableProcessors()).toString());
        temp.setLength(0);

        for (GarbageCollectorMXBean bean : garbageCollectorMXBeans) {
            System.out.println(temp.append(bean.getName()).append(" collection count: ").append(bean.getCollectionCount()).toString());
            temp.setLength(0);
            System.out.println(temp.append(bean.getName()).append(" collection time: ").append(bean.getCollectionTime()).toString());
            temp.setLength(0);
        }

    }
}
