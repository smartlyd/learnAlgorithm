package com.lee.learn;

/**
 * @author: Lee
 * @version: v1.0
 * @package: com.lee.learn
 * @description: TODO
 * @date: 2021/10/3
 * @time: 7:52 下午
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("==========");
        Chapter1 c = new Chapter1();
        int[] di = new int[4];
        di[0] = 1;
        di[1] = 2;
        di[2] = 3;
        di[3] = 4;
       int[] resu =  c.plusOne(di);
        for (int a:resu
             ) {
            System.out.println(a);
        }
        Chapter1.ListNode l1 = new Chapter1.ListNode(1);
        l1.next = new Chapter1.ListNode(2);
        l1.next.next = new Chapter1.ListNode(4);
        Chapter1.ListNode l2 = new Chapter1.ListNode(1);
        l2.next = new Chapter1.ListNode(3);
        l2.next.next = new Chapter1.ListNode(4);
        Chapter1.ListNode listNode = c.mergeTwoLists(l1, l2);
        int a = 0;
    }
}
