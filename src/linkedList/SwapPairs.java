package linkedList;

/**
 * 24. 两两交换链表中的节点
 */
public class SwapPairs {

  /**
   * 使用递归的方法
   * 俩俩交换，那就等于f(1<->2)=f(3...)+处理1\2
   *                f(3<->4)=f(5...)+处理3\4
   *
   *  从链表的头节点 head 开始递归。
   * 每次递归都负责交换一对节点。由 firstNode 和 secondNode 表示要交换的两个节点。
   * 下一次递归则是传递的是下一对需要交换的节点。若链表中还有节点，则继续递归。
   * 交换了两个节点以后，返回 secondNode，因为它是交换后的新头。
   * 在所有节点交换完成以后，我们返回交换后的头，实际上是原始链表的第二个节点。
   *
   * 时间复杂度为O(n) 空间复杂度为O(n)
   */
    public ListNode swapPairs(ListNode head){
      if(head==null || head.next==null) return head;
      ListNode next=head.next;
      ListNode newHead=swapPairs(next.next);
      head.next=newHead;
      next.next=head;
      return next;
    }

  /**
   * 使用迭代的方法
   *
   * 把链表分为两个部分，奇数结点为一部分，偶数结点为一部分
   * firstNode是交换结点的前一个结点，secondNode是交换结点的后一个结点，preNode是记录firstNode的前驱结点
   */
  public ListNode swapPairs2(ListNode head){
    ListNode dummy=new ListNode(-1);
    dummy.next=head;
    ListNode preNode=dummy;
    while(head!=null && head.next!=null){
      //得到要交换的两个结点
      ListNode firstNode=head;
      ListNode secondNode=head.next;

      //swap
      firstNode.next=secondNode.next;
      secondNode.next=firstNode;
      preNode.next=secondNode;

      //迭代到下一个
      preNode=firstNode;
      head=firstNode.next;
    }
    return dummy.next;
  }

}
