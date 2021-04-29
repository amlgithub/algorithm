package day_0330;

/**
 * 链表的创建和打印
 * @author aml
 * @date 2021/4/7 16:54
 */
public class ListNode_创建和打印 {


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



}
