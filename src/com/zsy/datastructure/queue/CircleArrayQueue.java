package com.zsy.datastructure.queue;

/**
 * 数组实现循环队列
 *
 * @author zhangshuaiyin
 */
public class CircleArrayQueue {
    /**
     * 数组最大长度，因为rear预留位，队列长度会少一位
     */
    private int maxSize;
    /**
     * front: 指向队列头一个元素
     */
    private int front;
    /**
     * rear: 指向队列最后一个元素的下一个位置
     * rear指向的位置为保留位，不会被元素占用
     */
    private int rear;
    private int[] array;

    public CircleArrayQueue(int arrayMaxSize) {
        this.maxSize = arrayMaxSize;
        array = new int[maxSize];
        this.front = this.rear = 0;
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
        return (rear + 1) % maxSize == front;
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
        array[rear] = item;
        // rear 后移，当移动到最后一个位置时，从 0 重新计数
        rear = (rear + 1) % maxSize;
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
        // 取出数据为：array[front], 取出后 front 后移，当移动到最后一个位置时，从 0 重新计数
        int value = array[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 打印队列中的元素,从front开始到最后一个元素
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, array[i % maxSize]);
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
        System.out.println("head: " + array[front]);
    }

    /**
     * @return 获取队列数据个数
     */
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }
}
