package linkedList;

/**
 * 2. 两数相加
 */
public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head1=l1;
    ListNode head2=l2;
    ListNode head=new ListNode(0);
    ListNode cur=head;
    int carry=0;
    while(head1!=null || head2!=null){
      int num1=head1!=null?head1.val:0;
      int num2=head2!=null?head2.val:0;
      cur.next=new ListNode((num1+num2+carry)%10);
      carry=(num1+num2+carry)/10;
      cur=cur.next;
      if(head1!=null) head1=head1.next;
      if(head2!=null) head2=head2.next;
    }
    if(carry!=0){
      cur.next=new ListNode(1);
    }
    return head.next;
  }

  public static void main(String[] args) {
    ListNode l1=new ListNode(2);
    l1.next=new ListNode(4);
    l1.next.next=new ListNode(3);
    ListNode l2=new ListNode(5);
    l2.next=new ListNode(6);
    l2.next.next=new ListNode(4);
    ListNode head=new AddTwoNumbers().addTwoNumbers(l1,l2);
    while(head!=null){
      System.out.println(head.val);
      head=head.next;
    }
//    ListNode l1=new ListNode(5);
//    ListNode l2=new ListNode(5);
//    ListNode head=new AddTwoNumbers().addTwoNumbers(l1,l2);
//    while(head!=null){
//      System.out.println(head.val);
//      head=head.next;
//    }
  }

}
