package linkedList;

/**
 * 61 旋转链表  给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class RotateRight {

  /**
   *
   * @param head
   * @param k
   * @return
   */
  public ListNode rotateRight(ListNode head, int k) {
    if(k==0 || head==null || head.next==null) return head;
    ListNode cur=head;
    int len=0;
    //先求出链表的长度
    while(cur!=null){
      cur=cur.next;
      len++;
    }
    //将超过链表长度的先转换
    k=k%len;
    if(k==0) return head;
    //右移动k个节点，则头节点其实就是倒数第k个节点
    ListNode pre=new ListNode(0);
    pre.next=head;
    ListNode fast=pre;
    ListNode slow=pre;
    while(k>0){
      fast=fast.next;
      k--;
    }
    //fast==null时，slow指向的是倒数第k个节点
    //fast.next==null时，slow指向的是倒数第k个节点的前一个节点
    while (fast.next!=null){
      fast=fast.next;
      slow=slow.next;
    }
    ListNode newHead=slow.next;
    slow.next=null;
    fast.next=head;
    return newHead;
  }

  public static void main(String[] args) {
    System.out.println(0%0);
  }

}
