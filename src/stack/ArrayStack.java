package stack;

import java.util.Stack;

/**
 * 括号匹配检测
 */
public class ArrayStack {

  private String[] items;
  private int count; //个数
  private int n; //栈的个数

  public ArrayStack(int n){
    this.items=new String[n];
    this.n=n;
    this.count=0;
  }

  public boolean push(String item){
    if(count==n) return false;
    items[count]=item;
    count++;
    return true;
  }

  public String pop(){
    if(count==0) return null;
    String item=items[count-1];
    count--;
    return item;
  }


  public static boolean isValid(String s) {
    Stack<Character> stack=new Stack<>();
    for(Character c:s.toCharArray()){
      if(c.equals('(')||c.equals('[')||c.equals('{')){
        stack.push(c);
      }else{
        if(stack.isEmpty()){
          return false;
        }
        char pop = stack.pop();
        boolean flag1= c==')' && pop!='(';
        boolean flag2= c==']' && pop!='[';
        boolean flag3= c=='}' && pop!='{';
        if(flag1||flag2||flag3){
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(isValid("()[]{}"));

  }

}
