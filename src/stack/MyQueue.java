package stack;

import java.util.Stack;

class MyQueue {

  private Stack<Integer> in;
  private Stack<Integer> out;

  /** Initialize your data structure here. */
  public MyQueue() {
    in=new Stack<>();
    out=new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    in.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    turnToOut();
    return out.pop();
  }

  /** Get the front element. */
  public int peek() {
    turnToOut();
    return out.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return in.isEmpty()&&out.isEmpty();
  }

  private void turnToOut(){
    if(out.isEmpty()){
      while(!in.isEmpty()){
        out.push(in.pop());
      }
    }
  }

}
