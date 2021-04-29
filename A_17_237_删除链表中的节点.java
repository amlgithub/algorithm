package day_0330;

import static day_0330.ListNode_创建和打印.createLinkedList;
import static day_0330.ListNode_创建和打印.printLinkedList;

/**
 * @author aml
 * @date 2021/4/7 20:38
 */
public class A_17_237_删除链表中的节点 {
    /**
     * 这类删除只给了节点，而不是节点的值，因此考虑改变节点值，
     * 来达到删除节点的效果
     * @param node
     */
    public static void deleteNode(ListNode node) {
        if (node == null){
            return;
        }
        if (node.next == null){
//            删除最后一个节点
            node = null;
            return;
        }
        node.val = node.next.val; // 将下个节点的值 复制给要删除的节点值，以此来达到删除效果
//        正常删除node.next的节点
        ListNode delNode = node.next;
        node.next = delNode.next;
        delNode = null;
        return;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,9};
        int n = arr.length;
        ListNode linkedList = createLinkedList(arr, n);
        printLinkedList(linkedList);
System.out.println();


        ListNode node = new ListNode(5);
        deleteNode(node);
        printLinkedList(linkedList);
    }
}
