package com.zsy.datastructure.linkedlist;

/**
 * 单链表测试
 *
 * @author zhangshuaiyin
 */
public class SingleLinkedListTest {
    static HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
    static HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
    static HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
    static HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

    static SingleLinkedList linkedList = new SingleLinkedList();

    public static void main(String[] args) {
        testAdd(linkedList);

        System.out.println("-----------------按编号大小插入节点：---------------------");
        linkedList = new SingleLinkedList();
        testAddByOrder(linkedList);

        System.out.println("-----------------根据编号修改节点信息：---------------------");
        HeroNode newNode = new HeroNode(2, "Lu JunYi", "Yu QiLin");
        testUpdate(newNode);

        System.out.println("-----------------根据编号删除节点信息：---------------------");
        testDelete(1);
        System.out.println("-----------------根据编号删除节点信息：---------------------");
        testDelete(4);
        System.out.println("-----------------根据编号删除节点信息：---------------------");
        testDelete(2);
    }

    private static void testDelete(int no) {
        linkedList.delete(no);
        linkedList.list();
    }

    private static void testUpdate(HeroNode newNode) {
        linkedList.update(newNode);
        linkedList.list();
    }

    private static void testAddByOrder(SingleLinkedList linkedList) {
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero3);
        linkedList.addByOrder(hero1);
        linkedList.list();
    }

    /**
     * add() 方法按照添加顺序排列
     *
     * @param linkedList 单链表
     */
    public static void testAdd(SingleLinkedList linkedList) {
        linkedList.add(hero1);
        linkedList.add(hero4);
        linkedList.add(hero2);
        linkedList.add(hero3);
        linkedList.list();
    }
}
