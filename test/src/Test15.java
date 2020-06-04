/**
 * @author zsy
 * @version 1.0
 * @date 2020/4/16 0016 下午 3:46
 */

import java.util.List;

/**
 * 输入一个链表，输出该链表中倒数第k 个结点．
 * 为了符合大多数人的习惯，本题从1 开始计数，即
 * 链表的尾结点是倒数第1 个结点．例如一个链表有6 个结点，从头结点开始它们的值依次
 * 是1 、2、3、4、5 、6。这个个链表的倒数第3 个结点是值为4 的结点
 */
public class Test15 {
    public static class ListNode{
        int value;
        ListNode next;
    }
    //给定两个指针，一个从第一个节点开始跑，另一个从k-1开始移动，当k-1那个值移到最后一个节点(其next为null)，则表示此时的第一个指针
    //所在的位置即是倒数第k个节点
    public static int getNode(ListNode head,int k){
        if(k<=0){
            throw new RuntimeException("111");
        }
        if(k==0){
            return head.value;
        }
        ListNode node = head;
        for (int i = 1; i < k; i++) {
            node = node.next;
            if(node == null){
                throw new RuntimeException("k过大");
            }
        }
        while(node.next!=null){
            node = node.next;
            head = head.next;
        }
        return head.value;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.value = 1;

        head.next = new ListNode();
        head.next.value = 2;

        head.next.next = new ListNode();
        head.next.next.value = 3;

        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;

        head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        System.out.println(getNode(head, 1)); // 倒数第一个
        System.out.println(getNode(head, 5)); // 中间的一个
        System.out.println(getNode(head, 9)); // 倒数最后一个就是顺数第一个

    }
}
