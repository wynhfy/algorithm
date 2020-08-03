package linkedList;

/**
 * 206. 反转链表
 */
public class ReverseList {

  /**
   * 使用递归的方法进行
   * f(1)=f(2)+处理
   * f(2)=f(3)+处理
   */
  public ListNode reverseList(ListNode head){
    if(head == null || head.next==null) return head;
    ListNode newHead=reverseList(head.next);  //newHead是新的头结点，即原链表的最后一个结点
    head.next.next=head;   //让当前结点的next指向自己
    head.next=null;        //让当前结点的next指为null
    return newHead;
  }


  public ListNode reverseList1(ListNode head) {
    if(head==null || head.next==null) return head;
    ListNode pre=null;
    ListNode next=null;
    while(head!=null){
      next=head.next;
      head.next=pre;
      pre=head;
      head=next;
    }
    return pre;
  }
}
