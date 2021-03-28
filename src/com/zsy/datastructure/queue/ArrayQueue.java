package com.zsy.datastructure.queue;

/**
 * 使用数组模拟队列
 *
 * @author zhangshuaiyin
 */
public class ArrayQueue {

    /**
     * 队列最大空间
     */
    private int maxSize;
    /**
     * front: 指向队列头的前一个位置，用于标识队列头
     * rear：指向队列尾部
     */
    private int front;
    private int rear;
    private int[] array;

    public ArrayQueue(int arrayMaxSize) {
        maxSize = arrayMaxSize;
        array = new int[maxSize];
        front = -1;
        rear = -1;
    }

    /**
     * @return 判断队列是否为空
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * @return 判断队列是否已满
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 向队列添加元素
     *
     * @param item 元素
     */
    public void add(int item) {
        if (isFull()) {
            System.out.println("队列已满，不能添加元素~~");
            return;
        }
        // rear 后移，新增一个存储空间
        rear++;
        array[rear] = item;
    }

    /**
     * 出队
     *
     * @return 头部数据
     */
    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空不能取出数据!!");
        }
        return array[++front];
    }

    /**
     * 打印队列中的元素
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, array[i]);
        }
    }

    /**
     * 打印队列头部元素
     */
    public void head() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }
        System.out.println("head: " + array[front + 1]);
    }
}
