package linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 */
public class isPalindrome {


  public boolean isPalindrome(ListNode head) {
    ListNode slow=head;
    ListNode fast=head;
    while(fast!=null && fast.next!=null){
      fast=fast.next.next;
      slow=slow.next;
    }
    ListNode rev=null;
    if(fast==null) rev=reverseList(slow);  //如果是偶数个节点，则反转从第二个中间结点开始
    else rev=reverseList(slow.next);       //如果是奇数个节点，则反转从中间结点的下一个节点开始
    ListNode cur=head;
    while(rev!=null){
      if(cur.val!=rev.val) return false;
      rev=rev.next;
      cur=cur.next;
    }
    return true;
  }

  public ListNode reverseList(ListNode head){
    if(head==null || head.next==null) return head;
    ListNode newHead=reverseList(head.next);
    head.next.next=head;
    head.next=null;
    return newHead;
  }



  /**
   * 使用额外的空间做
   */
  public boolean isPalindrome1(ListNode head) {
    List<Integer> list=new ArrayList<>();
    ListNode cur=head;
    while(cur!=null){
      list.add(cur.val);
      cur=cur.next;
    }
    int i=0,j=list.size()-1;
    while(i<j){
      if(!list.get(i).equals(list.get(j))){
        return false;
      }
      i++;
      j--;
    }
    return true;
  }



}
