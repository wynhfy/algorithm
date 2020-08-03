package queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 *
 * 辅助队列中之前比自己小的都会在主队列中比自己更早出队(因为队列是先进先出的)，不会起到max的作用，没有价值
 */
public class MaxQueue {

  Queue<Integer> queue; //主队列
  Deque<Integer> deque; //辅助队列

  public MaxQueue() {
    queue=new LinkedList<>();
    deque=new LinkedList<>();
  }

  public int max_value() {
    if(queue.isEmpty()) return -1;
    return deque.peek();
  }

  public void push_back(int value) {
    //主队列正常加入
    queue.add(value);
    //辅助队列先清空再加入
    while(!deque.isEmpty() && deque.getLast() < value){
      deque.removeLast();
    }
    deque.add(value);
  }

  public int pop_front() {
    //主队列正常清除
    if(queue.isEmpty()) return -1;
    int result=queue.remove();
    //辅助队列比较一下再判断是否要清除
    if(result==deque.peek()){
      deque.remove();
    }
    return result;
  }

}
