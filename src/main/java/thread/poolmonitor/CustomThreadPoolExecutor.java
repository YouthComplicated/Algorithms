package thread.poolmonitor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.*;

/**
 *
 *
 * 自定义executor
 *
 *
 * 申请线程池
 * 应用名称 + 线程池名称
 *
 * 应用+线程列表
 *
 * 动态调整参数(7大参数)  set()
 *
 * 机器性能一览
 *
 * cpu 内存  线程数
 *
 * mysql 表结构设计[业务具体的线程]
 *
 * 获取线程池(应用+线程池名称)-- 唯一
 *
 *----管理平台----
 *
 * 核心数
 * 最大值
 * 队列类型
 * 队列长度
 * 是否告警
 * 容量告警
 * 活跃度告警
 *
 *
 * 其它指标展示：
 *
 * 线程池活跃度 = activeCount/maximumPoolSize。
 *
 *
 * 业务开发申请了一个线程池同时用于执行两种任务，一个是发消息任务、一个是发短信任务，这两类任务实际执行的频率和时长对于用户来说没有一个直观的感受，
 * 很可能这两类任务不适合共享一个线程池，但是由于用户无法感知，因此也无从优化。动态化线程池内部实现了任务级别的埋点，
 * 且允许为不同的业务任务指定具有业务含义的名称，线程池内部基于这个名称做Transaction打点，基于这个功能，用户可以看到线程池内部任务级别的执行情况，
 * 且区分业务，任务监控示意图如下图所示：
 *
 * 细粒度控制
 *
 * 秒级告警
 *
 *
 * @author: nj
 * @date: 2020-04-06 14:38
 * @version: 0.0.1
 */

public class CustomThreadPoolExecutor extends ThreadPoolExecutor{


    private static final Logger LOGGER = LoggerFactory.getLogger(CustomThreadPoolExecutor.class);


    /**
     * 保存任务开始执行的时间，当任务结束时，用任务结束时间减去开始时间计算任务执行时间
     */
//    private ConcurrentHashMap<String, Long> startTimes;


    /**
     * 使用ThreadLocal统计相应线程的时间
     */
    ThreadLocal<Long> times = new ThreadLocal<>();


    /**
     * 线程池名称，一般以业务名称命名，方便区分
     */
    private String poolName;

    /**
     *
     * 调用父类的构造方法，并初始化HashMap和线程池名称
     *
     * @param corePoolSize
     *            线程池核心线程数
     * @param maximumPoolSize
     *            线程池最大线程数
     * @param keepAliveTime
     *            线程的最大空闲时间
     * @param unit
     *            空闲时间的单位
     * @param workQueue
     *            保存被提交任务的队列
     * @param poolName
     *            线程池名称
     */
    public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue,
                         String poolName) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, new CustomThreadFactory(poolName));
//        this.startTimes = new ConcurrentHashMap<>();
        this.poolName = poolName;
    }

    /**
     * 线程池延迟关闭时（等待线程池里的任务都执行完毕），统计线程池情况
     */
    @Override
    public void shutdown() {
        // 统计已执行任务、正在执行任务、未执行任务数量
        LOGGER.info(String.format(this.poolName + " Going to shutdown. Executed tasks: %d, Running tasks: %d, Pending tasks: %d",
        this.getCompletedTaskCount(), this.getActiveCount(), this.getQueue().size()));
        super.shutdown();
    }

    /**
     * 线程池立即关闭时，统计线程池情况
     */
    @Override
    public List<Runnable> shutdownNow() {
        // 统计已执行任务、正在执行任务、未执行任务数量
        LOGGER.info(
                String.format(this.poolName + " Going to immediately shutdown. Executed tasks: %d, Running tasks: %d, Pending tasks: %d",
                        this.getCompletedTaskCount(), this.getActiveCount(), this.getQueue().size()));

        return super.shutdownNow();
    }

    /**
     * 任务执行之前，记录任务开始时间
     */
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
//        startTimes.put(String.valueOf(r.hashCode()), System.currentTimeMillis());
        times.set(System.currentTimeMillis());
    }



    /**
     * 任务执行之后，计算任务结束时间
     */
    @Override
    protected void afterExecute(Runnable r, Throwable t) {
//        Long startTime = startTimes.remove(String.valueOf(r.hashCode()));
//        long diff = System.currentTimeMillis() - startTime;
        long diff1 = System.currentTimeMillis() - times.get();
        /**
         * 统计任务耗时、初始线程数、核心线程数、正在执行的任务数量、已完成任务数量、任务总数、队列里缓存的任务数量、池中存在的最大线程数、最大允许的线程数、
         * 线程空闲时间、线程池是否关闭、线程池是否终止
         */
        LOGGER.info(String.format(this.poolName
                        + "-pool-monitor: Duration: %d ms, PoolSize: %d, CorePoolSize: %d, Active: %d, Completed: %d, Task: %d, Queue: %d, LargestPoolSize: %d, MaximumPoolSize: %d,  KeepAliveTime: %d, isShutdown: %s, isTerminated: %s",
                diff1, this.getPoolSize(), this.getCorePoolSize(), this.getActiveCount(), this.getCompletedTaskCount(), this.getTaskCount(),
                this.getQueue().size(), this.getLargestPoolSize(), this.getMaximumPoolSize(), this.getKeepAliveTime(TimeUnit.MILLISECONDS),
                this.isShutdown(), this.isTerminated()));
    }



    /**
     * 创建固定线程池，代码源于Executors.newFixedThreadPool方法，这里增加了poolName
     *
     * @param nThreads
     *            线程数量
     * @param poolName
     *            线程池名称
     * @return ExecutorService对象
     */
    public static ExecutorService newFixedThreadPool(int nThreads, String poolName) {
        return new CustomThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), poolName);
    }

    /**
     * 创建缓存型线程池，代码源于Executors.newCachedThreadPool方法，这里增加了poolName
     *
     * @param poolName
     *            线程池名称
     * @return ExecutorService对象
     */
    public static ExecutorService newCachedThreadPool(String poolName) {
        return new CustomThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<>(), poolName);
    }








}