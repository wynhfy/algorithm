package stack;

import java.util.Stack;

/**
 * 两个栈实现队列
 */
class CQueue {

  private Stack<Integer> in;
  private Stack<Integer> out;

  public CQueue() {
    in=new Stack<>();
    out=new Stack<>();
  }

  public void appendTail(int value) {
    in.push(value);
  }

  public int deleteHead() {
    turnToOut();
    if(out.isEmpty()){
      return -1;
    }
    return out.pop();
  }

  private void turnToOut(){
    if(out.isEmpty()){
      while(!in.isEmpty()){
        out.push(in.pop());
      }
    }
  }

}
