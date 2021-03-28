package com.zsy.datastructure.queue;

import java.util.Scanner;

/**
 * @author zhangshuaiyin
 */
public class CircleArrayQueueTest {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(3);

        // 接收输入字符
        char key;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("****************");
            System.out.println("s(show): 显示队列");
            System.out.println("a(add): 添加数据");
            System.out.println("g(get): 取出数据");
            System.out.println("h(head): 头部数据");
            System.out.println("按其他任意键退出...");
            System.out.println("****************");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.show();
                    break;
                case 'a':
                    System.out.println("请输入要添加队列的数字：");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case 'g':
                    try {
                        System.out.println("取出的数据：" + queue.remove());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    queue.head();
                    break;
                default:
                    scanner.close();
                    loop = false;
                    System.out.println("程序退出~~");
                    break;
            }
        }
    }
}
