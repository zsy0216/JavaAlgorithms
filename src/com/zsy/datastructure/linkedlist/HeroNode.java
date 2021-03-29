package com.zsy.datastructure.linkedlist;

/**
 * 以水浒英雄信息作为链表的节点
 *
 * @author zhangshuaiyin
 */
public class HeroNode {

    int no;
    String name;
    String nickName;
    HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';

    }
}
