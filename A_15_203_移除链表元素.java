package day_0330;

/**
 * 82 21
 * @author aml
 * @date 2021/4/7 19:21
 */
public class A_15_203_移除链表元素 {

    /**
     * 设置虚拟节点指向头结点，
     * 统一所有节点的删除操作
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0); // 新建一个虚拟节点，可以设置任意值
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null){
            if (cur.next.val == val){
//                删除操作
                ListNode delNode = cur.next; // 保存要删除的节点的 下一个节点，避免链断开
                cur.next = delNode.next;
                delNode = null; // 将要删除的节点至为空，为后序的垃圾回收
            }else {
                cur = cur.next;
            }
        }
        ListNode retNode = dummyHead.next; //真正的返回的节点
        dummyHead = null; //将最开始设置的虚拟节点至为空，便于垃圾回收
        return retNode;
    }


    /**
     * 链表删除，
     * 需要分情况处理，头结点删除  和  非头结点删除
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
//        头结点删除方法
        while (head != null && head.val == val){
            ListNode delNode = head;
            head = delNode.next;
            delNode = null;
        }
//        可能删除完头结点后，整个链表为空，因此需要再判断下
        if (head == null){
            return null;
        }

//       以下是 非头结点的删除方法
        ListNode cur = head;
        while (cur.next != null){
            if (cur.next.val == val){
//                删除cur.next元素
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
            }else {
//                往下遍历找val节点
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] head = {1,2,6,3,4,5,6};
        int val = 1;
        ListNode_创建和打印 a = new ListNode_创建和打印();
        ListNode node = ListNode_创建和打印.createLinkedList(head, 7);
        ListNode_创建和打印.printLinkedList(node);
        System.out.println();
        ListNode listNode = removeElements2(node, val);
        ListNode_创建和打印.printLinkedList(listNode);


    }
}
