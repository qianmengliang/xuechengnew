/**
 * @author zsy
 * @version 1.0
 * @date 2020/4/20 0020 下午 2:43
 */

import java.util.HashMap;

/**
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 *
 */
public class Test16
{
  public static class ListNode{
    int value;
    ListNode next;
}
  public static ListNode reverseList(ListNode head){
      //插入一个逻辑头结点，用来存放翻转之后的头结点
      ListNode root = new ListNode();
      root.next = null;
      ListNode next;
      while(head != null){
          next = head.next;
          head.next = root.next;
          root.next = head;
          head = next;
      }
      return root.next;
  }

    /**
     * 输出链表的元素值
     *
     * @param head 链表的头结点
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
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

        printList(head);
        head = reverseList(head);
        printList(head);

    }
}
