package stack;

import java.util.Stack;

/**
 * 最小值栈
 */
class MinStack {

  private Stack<Integer> data;
  private Stack<Integer> mindata;
  private int min;

  /** initialize your data structure here. */
  public MinStack() {
    data=new Stack<>();
    mindata=new Stack<>();
    min=Integer.MAX_VALUE;
  }

  public void push(int x) {
    data.push(x);
    min=Math.min(min,x);
    mindata.push(min);
  }

  public void pop() {
    data.pop();
    mindata.pop();
    min=mindata.isEmpty()?Integer.MAX_VALUE:mindata.peek(); //必须要有这句话，有可能后面出栈为空了
  }

  public int top() {
    return data.peek();
  }

  public int getMin() {
    return mindata.peek();
  }
}