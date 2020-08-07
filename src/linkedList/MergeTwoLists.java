package linkedList;

/**
 * 21. 合并两个有序链表
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode cur=null;
        if(l1.val<=l2.val){
            cur=l1;
            cur.next=mergeTwoLists(l1.next,l2);
        }else if(l1.val>l2.val){
            cur=l2;
            cur.next=mergeTwoLists(l1,l2.next);
        }
        return cur;
    }

}
