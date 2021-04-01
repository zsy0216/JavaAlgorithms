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
     * @param no 根据编号 no 删除链表中对应的节点
     */
    public void delete(int no) {
        HeroNode temp = head;
        while (temp.next != null) {
            if (temp.next.no == no) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
        System.out.printf("没有找到编号是 %d 的节点，不能修改\n", no);
    }

    /**
     * 获取单链表有效节点个数
     *
     * @return 有效节点数
     */
    public int getLength() {
        HeroNode temp = head;
        int length = 0;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 查找单链表中的倒数第 k 个结点
     *
     * @param k 倒数第 k 个
     * @return 找得到返回节点对象，找不到返回 null
     */
    public HeroNode getLastIndexNode(int k) {
        HeroNode temp = head;
        int size = getLength();
        // 空链表返回空
        if (temp.next == null || k > size || k <= 0) {
            return null;
        }
        // 比如 size = 3; k = 2; i =1 找第二个(下标是1)
        temp = temp.next;
        for (int i = 0; i < size - k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 单链表的反转
     * 1. 创建一个新的头节点用于保存反转后的链表
     * 2. 遍历原来的链表，依次取出元素放置新头节点的后面
     */
    public void reverse() {
        if (head.next == null || head.next.next == null) {
            return;
        }

        // 反转后链表头节点
        HeroNode revereHead = new HeroNode(0, "", "");

        // 遍历用辅助节点
        HeroNode temp = head.next;

        // 取出节点的下一个节点，保存遍历指针
        HeroNode next = null;
        while (temp != null) {
            // 标记下一个元素，此时temp节点就是取出的节点
            next = temp.next;

            // 将反转链表节点放到取出的节点后面
            temp.next = revereHead.next;

            // 将取出的节点（包含反转链表的节点）放到反转链表第一个位置
            revereHead.next = temp;

            // 辅助节点后移
            temp = next;
        }

        head.next = revereHead.next;
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
