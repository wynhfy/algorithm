package linkedList;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class GetIntersectionNode {

  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int i=0,j=0;
    ListNode cur=headA;
    while(cur!=null){
      i++;
      cur=cur.next;
    }
    cur=headB;
    while(cur!=null){
      j++;
      cur=cur.next;
    }
    System.out.println(i+"  "+j);
    ListNode nodeA=headA;
    ListNode nodeB=headB;
    if(i>j){
      int k=i-j;
      while(k>0){
        nodeA=nodeA.next;
        k--;
      }
    }else{
      int k=j-i;
      while(k>0){
        nodeB=nodeB.next;
        k--;
      }
    }
    while(nodeA!=null && nodeB!=null){
      if(nodeA==nodeB) break;
      nodeA=nodeA.next;
      nodeB=nodeB.next;
    }
    return nodeA;
  }

  public static void main(String[] args) {
    //4 1 8 4 5
    ListNode headA=new ListNode(4);
    headA.next=new ListNode(1);
    headA.next.next=new ListNode(8);
    headA.next.next.next=new ListNode(4);
    headA.next.next.next.next=new ListNode(5);
    //5 6 1 8 4 5
    ListNode headB=new ListNode(5);
    headB.next=new ListNode(6);
    headB.next.next=new ListNode(1);
    headB.next.next.next=new ListNode(8);
    headB.next.next.next.next=new ListNode(4);
    headB.next.next.next.next.next=new ListNode(5);
    getIntersectionNode(headA,headB);
  }

}
