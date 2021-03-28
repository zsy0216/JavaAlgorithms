package com.zsy.datastructure.linkedlist;

/**
 * @author zhangshuaiyin
 */
public class SingleLinkedList {

    private final HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void list() {
        if (head.next == null) {
            throw new RuntimeException("当前链表为空");
        }
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
