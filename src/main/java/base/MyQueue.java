package base;

import java.util.Scanner;

/**
 * 模拟环形队列， 基于数组实现
 *
 *
 * @author: nj
 * @date: 2020-03-25 10:04
 * @version: 0.0.1
 */
public class MyQueue {


    private int maxSize;
    /**
     * front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
     */
    private int front;
    /**
     * rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
     *
     * todo 为什么要做这样一个约定
     *
     */
    private int rear;
    private int[] data;


    /**
     * 初始化
     * @param maxSize
     */
    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        data = new int[maxSize];
    }

    /**
     * 获取元素实际个数
     * @return
     */
    public int getSize(){
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * add
     * @param i
     */
    public void add(int i){
        if(isFull()){
            throw new RuntimeException("队列已满！");
        }
        data[rear] = i;
        //rear 往后移动
        rear = (rear + 1) % maxSize;
    }

    /**
     * get
     * @return
     */
    public int get(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        int val = data[front];
        front = (front + 1) % maxSize;
        return val;
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        return data[front];
    }

    /**
     * 队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 队列是否已满
     * @return
     */
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }


    public void print(){
        for (int i = front; i < front + getSize() ; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, data[i % maxSize]);
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(4);
//        for(int i = 0; i < 3; i++){
//            queue.add(i);
//        }
//        queue.print();


        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        boolean loop = true;
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            // 接收一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.print();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    try{
                        queue.add(value);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 'g':
                    // 取出数据a
                    try {
                        int res = queue.get();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    // 查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }



    }

}