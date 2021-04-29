package day_0330;

/**
 * 92  83 86 328 2 445
 * @author aml
 * @date 2021/4/7 15:51
 */
public class A_14_206_反转链表 {

    /**
     * o(n) o(1)
     * 使用三个指针pre cur next
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }


    /**
     * 链表的创建
     * @param arr  数组
     * @param n    数组长度
     * @return
     */
    public static ListNode createLinkedList(int[] arr, int n){
        if (n == 0){
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode curNode = head;
        for (int i = 1; i < n; i++ ){
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        return head;
    }

    /**
     * 链表打印
     * @param head 链表头指针
     */
    public static void printLinkedList(ListNode head){
        ListNode curNode = head;
        while (curNode != null){
            System.out.print(curNode.val + "->");
            curNode = curNode.next;
        }
        System.out.print("NULL");
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = 5;
        ListNode head = createLinkedList(arr,n);
        printLinkedList(head);

        System.out.println();


        ListNode listNode = reverseList(head);
        System.out.println("---------------------");
        printLinkedList(listNode);
    }
}


