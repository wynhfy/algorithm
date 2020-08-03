package linkedList;

/**
 * 删除倒数第n个节点
 */
public class RemoveNthFromEnd {

  /**
   * 快结点先走n个结点，当快结点遍历完的时候(即快结点指向空的那个位置的时候)，慢结点正好指向倒数第n个结点
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode pre=new ListNode(0);
    pre.next=head;
    ListNode fast=pre;
    ListNode slow=pre;
    //快指针先走n+1个，这样慢指针才好删除(即正好指向要删除的前一个结点)
    for(int i=0;i<=n;i++){
      fast=fast.next;
    }
    while(fast!=null){
      slow=slow.next;
      fast=fast.next;
    }
    slow.next=slow.next.next;
    //不能返回head，若只有一个结点且删除一个结点的时候，返回head则是错的
    return pre.next;
  }

  public ListNode removeNthFromEnd2(ListNode head,int n){
    ListNode pre=new ListNode(0);
    pre.next=head;
    ListNode fast=pre;
    ListNode slow=pre;
    //快指针先走n个
    while(n>0){
      fast=fast.next;
      n--;
    }
    while(fast.next!=null){
      slow=slow.next;
      fast=fast.next;
    }
    slow.next=slow.next.next;
    return pre.next;
  }

}
