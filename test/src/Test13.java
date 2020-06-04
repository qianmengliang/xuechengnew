/**
 * @author zsy
 * @version 1.0
 * @date 2020/4/16 0016 上午 11:13
 */
/**
 * 给定单向链表的头指针和一个结点指针，定义一个函数在0(1)时间删除该结点,
 *
 */
public class Test13 {
    public static class ListNode{
        int value;
        ListNode next;
    }

    public static ListNode delete(ListNode head,ListNode waitDeleteNode){
        if(head == null || waitDeleteNode==null){
            return head;
        }

        // 如果删除的是头结点，直接返回头结点的下一个结点
        if (head == waitDeleteNode) {
            return head.next;
        }

        //若waitDeleteNode是最后一个节点，讲其置为null值
        if(waitDeleteNode.next == null){
            ListNode tmp = head;
            while(tmp.next!=waitDeleteNode){
                tmp = tmp.next;
            }
            tmp.next = null;
        }else{
            //若waitDeleteNode不最后一个节点。讲这个节点的值替换为下一个节点的值，讲这个节点的next替换为下一个节点的next
            waitDeleteNode.value = waitDeleteNode.next.value;
            waitDeleteNode.next = waitDeleteNode.next.next;
        }

        return head;
    }

    private static void printList(ListNode head) {
        while(head.next!=null){
            System.out.print(head.value+"->");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();
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

        ListNode middle = head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        ListNode last = head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        head = delete(head, null); // 删除的结点为空
        printList(head);
        ListNode node = new ListNode();
        node.value = 12;

        head = delete(head, head); // 删除头结点
        printList(head);
        head = delete(head, last); // 删除尾结点
        printList(head);
        head = delete(head, middle); // 删除中间结点
        printList(head);

        head = delete(head, node); // 删除的结点不在链表中
        printList(head);

    }


}
