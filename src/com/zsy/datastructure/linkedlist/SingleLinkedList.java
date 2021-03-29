package com.zsy.datastructure.linkedlist;

/**
 * 单链表存储水浒英雄节点信息
 *
 * @author zhangshuaiyin
 */
public class SingleLinkedList {

    /**
     * head 节点，指向链表第一个节点，定位链表地址
     */
    private final HeroNode head = new HeroNode(0, "", "");

    /**
     * @param node 添加节点：从链表最后
     */
    public void add(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 按照编号由小到大的顺序插入节点，编号不可重复
     *
     * @param node 插入节点
     */
    public void addByOrder(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            if (temp.next.no == node.no) {
                System.out.printf("编号 %d 已存在，插入失败\n", node.no);
                return;
            } else if (temp.next.no > node.no) {
                // 此时说明新节点应该插入 temp 的下一个位置
                break;
            }
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }

    /**
     * 根据新节点信息修改链表中相同编号的节点
     *
     * @param node 新节点
     */
    public void update(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.no == node.no) {
                temp.name = node.name;
                temp.nickName = node.nickName;
                return;
            }
        }
        System.out.printf("没有找到编号是 %d 的节点，不能修改\n", node.no);
    }

    /**
     * 打印链表信息
     */
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
