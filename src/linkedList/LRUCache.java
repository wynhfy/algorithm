package linkedList;

import java.util.HashMap;
import java.util.Map;


/**
 * get() hashmap contains
 *            no:  return -1
 *            yes: update to head
 * put() hashmap contains
 *            no: 1、drop tail  2、add head (both map and list)
 *            yes: update to head
 */
class LRUCache {

  /**
   * 节点存的是key和value两个属性
   */
  private static class DoublyLinkedNode{
    DoublyLinkedNode prev;
    DoublyLinkedNode next;
    int key;
    int val;
    public DoublyLinkedNode(int key,int val){
      this.key=key;
      this.val=val;
    }
  }

  DoublyLinkedNode head;
  DoublyLinkedNode tail;
  Map<Integer,DoublyLinkedNode> map;
  int size;

  public LRUCache(int capacity){
    head=new DoublyLinkedNode(0,0);
    tail=new DoublyLinkedNode(0,0);
    map=new HashMap<>();
    size=capacity;
    head.next=tail;
    tail.prev=head;
  }

  public int get(int key){
    if(map.containsKey(key)){  //存在，先将链表里的删除，然后再放到队头
      DoublyLinkedNode node = map.get(key);
      delete(node);
      add(key,node.val);
      return node.val;
    }else{
      return -1;
    }
  }

  /**
   * 已经存在的删除放到最前面
   * @param node
   */
  private void delete(DoublyLinkedNode node){
    DoublyLinkedNode prev=node.prev;
    DoublyLinkedNode next=node.next;
    prev.next=next;
    next.prev=prev;
    map.remove(node.key);
  }

  /**
   * 放到最前面
   * @param key
   */
  private void add(int key,int value){
    DoublyLinkedNode node=new DoublyLinkedNode(key,value);
    insertInHead(node);
    map.put(key,node);
    if(map.size()>size){
      delete(tail.prev);
    }
  }

  /**
   * 在头部插入
   * @param node
   */
  private void insertInHead(DoublyLinkedNode node){
    DoublyLinkedNode oldFirst=head.next;
    head.next=node;
    oldFirst.prev=node;
    node.prev=head;
    node.next=oldFirst;
  }

  public void put(int key,int value){
    if(map.containsKey(key)){
      DoublyLinkedNode node = map.get(key);
      delete(node);
      add(key,value);
    }else{
      add(key,value);
    }
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

    cache.put(2, 1);
    cache.put(2, 2);
    System.out.println(cache.get(2));       // 返回  1
    cache.put(1, 1);    // 该操作会使得关键字 2 作废
    //System.out.println(cache.get(2));       // 返回 -1 (未找到)
    cache.put(4, 1);    // 该操作会使得关键字 1 作废
    System.out.println(cache.get(2));       // 返回 -1 (未找到)

  }

}
