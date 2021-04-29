package day_0330;

/**
 * 61 143 234
 * @author aml
 * @date 2021/4/7 21:20
 */
public class A_18_19_删除链表的倒数第N个结点 {
    /**
     * 思路一、先整体遍历一遍，获取链表的长度，然后正向计算要删除的是第几个节点
     * 思路二、只遍历一遍，因为要删除的倒数第N个节点，维持一个窗口大小固定的n+1，即【p..q】为n+1,
     *          可以知道要删除的倒数N节点的前一个节点为P,
     *     双指针+窗口 方法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

//        设置两个指针，固定窗口大小为N+1
        ListNode p = dummyHead;
        ListNode q = dummyHead;
//        将q指向为null时，p指向的就是N的前一个节点
        for (int i=0; i<n+1; i++){
            q = q.next;
        }
        while (q != null){
            p = p.next;
            q = q.next;
        }
//        删除操作
        ListNode delNode= p.next;
        p.next = delNode.next;
        delNode = null;
//        返回
        ListNode resNode = dummyHead.next;
        dummyHead = null;

        return resNode;
    }
}
