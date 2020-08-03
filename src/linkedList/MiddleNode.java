package linkedList;

/**
 * 876. 链表的中间结点
 *  快慢指针来完成
 */
public class MiddleNode {

//  public ListNode middleNode(ListNode head) {
//    ListNode fast=head;
//    ListNode slow=head;
//    /** fast.next!=null是来判断奇数个结点的时候，即指向最后一个的时候，慢指针刚好指向中间
//     *  fast.next.next!=null 是来判断偶数个结点的时候，即指向倒数第二个的时候，慢指针刚好指向中间的第一个
//     *  快指针走两步，慢指针走一步
//     */
//    while(fast.next!=null && fast.next.next!=null){
//      fast=fast.next.next;
//      slow=slow.next;
//    }
//    if(fast.next==null){ //奇数个的情况
//      return slow;
//    }
//    return slow.next;
//  }

  public ListNode middleNode(ListNode head){
    ListNode fast=head;
    ListNode slow=head;
    //fast=null时，是偶数个结点(有两个中间结点)，此时慢指针是指向第二个中间结点
    //fast.next=null时，是奇数个结点
    while(fast!=null && fast.next!=null){
      fast=fast.next.next;
      slow=slow.next;
    }
    return slow;
  }

}
class ListNode{
  int val;
  ListNode next;
  ListNode(int x) {val=x;}
}