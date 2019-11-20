package datastructure;

/**
 * @author : dingwenqiang
 * @date : 2019/10/10 00:27
 * @description : 基于数组实现循环队列
 */
public class MyQueue {

    private int[] array;
    private int front;
    private int rear;

    public MyQueue(int capacity) {
        this.array = new int[capacity];
    }

    public void enQueue(int element) throws Exception {
        System.out.println("before 入队列" + element);
        if ((rear + 1) % array.length == front) {
            throw new Exception("队列已满！");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    public int deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("队列已空！");
        }
        int deQueueElement = array[front];
        front = (front + 1) % array.length;
        return deQueueElement;
    }

    public void output(){
        System.out.print("输出队列：");
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue(10);
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.enQueue(4);
        myQueue.enQueue(5);
        myQueue.enQueue(6);
        myQueue.enQueue(7);
        myQueue.enQueue(8);
        myQueue.enQueue(9);
        System.out.println("出队列：" + myQueue.deQueue());
        myQueue.output();
    }

}
