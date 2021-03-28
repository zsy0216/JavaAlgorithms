package com.zsy.datastructure.linkedlist;

/**
 * @author zhangshuaiyin
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(hero1);
        linkedList.add(hero4);
        linkedList.add(hero2);
        linkedList.add(hero3);

        linkedList.list();
    }
}
