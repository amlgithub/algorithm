package day_0330;

import static day_0330.ListNode_创建和打印.createLinkedList;
import static day_0330.ListNode_创建和打印.printLinkedList;

/**
 * 25 147 148
 * @author aml
 * @date 2021/4/7 20:03
 */
public class A_16_24_两两交换链表中的节点 {
    /**
     * 设置虚拟节点指向头结点，
     * 另设置三个节点，node1，node2，next
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head; // 虚拟节点指向头结点

        ListNode p = dummyHead; // 将虚拟节点使用P来引用
        while (p.next != null && p.next.next != null){
            ListNode node1 = p.next;
            ListNode node2 = node1.next; // node1和node2是要交换的两个节点
            ListNode next = node2.next; // 还需要保存node2的下一个节点，避免链条断裂
//            交换
            node2.next = node1;
            node1.next = next;
            p.next = node2;

//            进行下一对的节点交换，很nice
            p = node1;
        }
//        返回虚拟节点的下一个节点
        ListNode resNode = dummyHead.next;
        dummyHead = null;
        return resNode;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int n = arr.length;
        ListNode linkedList = createLinkedList(arr, n);
        printLinkedList(linkedList);
        System.out.println();

        ListNode node = swapPairs(linkedList);
        printLinkedList(node);

    }
}
