package 剑指offer;

/**
 * 剑指 Offer 18. 删除链表的节点
 */
public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if(head == null) return null;
        ListNode pre=new ListNode(0);
        ListNode newHead=pre;
        pre.next=head;
        ListNode cur=head;
        while(cur!=null){
            if(cur.val==val){
                break;
            }
            cur=cur.next;
            pre=pre.next;
        }
        pre.next=pre.next.next;
        return newHead.next;
    }
}

