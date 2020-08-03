package linkedList;

import java.util.HashSet;

/**
 * 141. 环形链表
 */
public class HasCycle {
  /**
   * 快慢指针实现
   */
  public boolean hasCycle(ListNode head) {
    if(head==null || head.next==null) return false;
    ListNode fast=head;
    ListNode slow=head;
    /**
     * fast!=null 是偶数个的时候,fast=null时就是快指针已经指向最后的null了
     * fast.next!=null 是奇数个的时候，fast.next=null时就是快指针已经指向最后一个结点了
     */
    while(fast!=null && fast.next!=null){
      fast=fast.next.next;
      slow=slow.next;
      if(fast==slow) return true;
    }
    return false;
  }
  


  /**
   * 通过hashset，增加空间实现
   */
//  public boolean hasCycle(ListNode head){
//    if(head==null || head.next==null) return false; //没有结点或者只有一个结点的时候
//    HashSet<ListNode> hashSet = new HashSet<>();
//    while (head!=null){ //遍历链表
//      if(hashSet.contains(head)) return true;
//      hashSet.add(head);
//      head=head.next;
//    }
//    return false;
//  }

  public ListNode detectCycle(ListNode head){
    if(head==null || head.next==null) return null;
    ListNode fast=head;
    ListNode slow=head;
    while(fast!=null && fast.next!=null){
      fast=fast.next.next;
      slow=slow.next;
      if(fast==slow) break;
    }
    if(fast==null || fast.next==null) return null;
    fast=head;
    while(fast!=slow){
      fast=fast.next;
      slow=slow.next;
    }
    return slow;
  }


}
