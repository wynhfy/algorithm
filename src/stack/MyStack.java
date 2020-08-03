package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 */
class MyStack {

  private Queue<Integer> queue;

  /** Initialize your data structure here. */
  public MyStack() {
    /**LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。 */
    queue=new LinkedList();
  }

  /** Push element x onto stack. */
  public void push(int x) {
    queue.offer(x);
    int size=queue.size();
    while(size>1){
      queue.offer(queue.poll());
      size--;
    }
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    return queue.poll();
  }

  /** Get the top element. */
  public int top() {
    return queue.peek();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return  queue.isEmpty();
  }
}