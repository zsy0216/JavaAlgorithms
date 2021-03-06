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
    static HeroNode hero4 = new HeroNode(4, "公孙胜", "入云龙");
    static HeroNode hero5 = new HeroNode(5, "关胜", "大刀");
    static HeroNode hero6 = new HeroNode(6, "林冲", "豹子头");
    static HeroNode hero7 = new HeroNode(7, "秦明", "霹雳火");
    static HeroNode hero8 = new HeroNode(8, "花荣", "小李广");

    static SingleLinkedList linkedList = new SingleLinkedList();
    static SingleLinkedList linkedList2 = new SingleLinkedList();

    public static void main(String[] args) {
        testAdd(linkedList);

        System.out.println("-----------------按编号大小插入节点后链表1信息：---------------------");
        linkedList = new SingleLinkedList();
        testAddByOrder(linkedList);
        System.out.println("-----------------按编号大小插入节点后链表2信息：---------------------");
        testAddByOrder2(linkedList2);

        System.out.println("-----------------合并有序链表1 和 链表2：---------------------");
        testMergeWithOrder(linkedList2);

        /*System.out.println("-----------------逆序打印链表信息(不改变链表结构)：---------------------");
        testReverseList();

        testGetLength();
        testGetLastIndexNode(2);*/

      /*  System.out.println("-----------------反转后链表信息：---------------------");
        testReverse();*/

        /*System.out.println("-----------------根据编号修改节点信息后链表信息：---------------------");
        HeroNode newNode = new HeroNode(2, "Lu JunYi", "Yu QiLin");
        testUpdate(newNode);
        testGetLength();

        System.out.println("-----------------根据编号删除节点信息后链表信息：---------------------");
        testDelete(1);
        testGetLength();
        System.out.println("-----------------根据编号删除节点信息后链表信息：---------------------");
        testDelete(4);
        testGetLength();
        System.out.println("-----------------根据编号删除节点信息后链表信息：---------------------");
        testDelete(2);
        testGetLength();*/
    }

    /**
     * @param no 删除编号为 no 的节点
     */
    private static void testDelete(int no) {
        linkedList.delete(no);
        linkedList.list();
    }

    private static void testGetLength() {
        System.out.println("单链表有效节点个数：" + linkedList.getLength());
    }

    private static void testGetLastIndexNode(int k) {
        System.out.println("倒数第" + k + "个节点为：" + linkedList.getLastIndexNode(k));
    }

    private static void testReverse() {
        linkedList.reverse();
        linkedList.list();
    }

    public static void testReverseList() {
        linkedList.reverseList();
    }


    private static void testMergeWithOrder(SingleLinkedList linkedList2) {
        linkedList.mergeWithOrder(linkedList2);
        linkedList.list();
    }

    /**
     * @param newNode 更新新节点
     */
    private static void testUpdate(HeroNode newNode) {
        linkedList.update(newNode);
        linkedList.list();
    }

    /**
     * 测试按编号大小添加元素
     *
     * @param linkedList 单链表
     */
    private static void testAddByOrder(SingleLinkedList linkedList) {
        linkedList.addByOrder(hero7);
        linkedList.addByOrder(hero5);
        linkedList.addByOrder(hero3);
        linkedList.addByOrder(hero1);
        linkedList.list();
    }

    /**
     * 测试按编号大小添加元素
     *
     * @param linkedList 单链表
     */
    private static void testAddByOrder2(SingleLinkedList linkedList) {
        linkedList.addByOrder(hero8);
        linkedList.addByOrder(hero6);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero2);
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
