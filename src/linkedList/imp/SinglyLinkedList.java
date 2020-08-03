package linkedList.imp;

import tree.Node;

/**
 * 707
 * 单链表的实现
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 */
public class SinglyLinkedList {

  private SinglyListNode head;
  private int size;

  public SinglyLinkedList(){
    head=new SinglyListNode();
    size=0;
  }

  public int get(int index){
    if(index<0 || index>=size) return -1;
    SinglyListNode cur=head;
    for(int i=0;i<index;i++){
      cur=cur.next;
    }
    return cur.val;
  }

  public void addAtHead(int val){
    if(size==0) head.val=val;
    else{
      SinglyListNode node=new SinglyListNode(val);
      node.next=head;
      head=node;
    }
    size++;
  }

  public void addAtTail(int val){
    if(size==0) head.val=val;
    else{
      SinglyListNode node=new SinglyListNode(val);
      SinglyListNode cur=head;
      while(cur.next!=null){
        cur=cur.next;
      }
      cur.next=node;
    }
    size++;
  }

  public void addAtIndex(int index,int val){
    if(index>size) return;
    else if(index<=0) addAtHead(val);
    else if(index==size) addAtTail(val);
    else{
        SinglyListNode cur=head;
        for(int i=0;i<index-1;i++){
          cur=cur.next;
        }
        SinglyListNode node=new SinglyListNode(val);
        node.next=cur.next;
        cur.next=node;
        size++;
    }
  }

  /**
   * 删除的时候要考虑到index为0的时候
   * @param index
   */
  public void deleteAtIndex(int index){
    if(index<0||index>=size) return;
    SinglyListNode cur=head;
    if(index==0){
      head=cur.next;
    }else{
      for(int i=0;i<index-1;i++){
        cur=cur.next;
      }
      cur.next=cur.next.next;
    }
    size--;
  }

  public static void main(String[] args) {
    SinglyLinkedList list=new SinglyLinkedList();
    list.addAtHead(1);
    list.deleteAtIndex(0);
  }

}
