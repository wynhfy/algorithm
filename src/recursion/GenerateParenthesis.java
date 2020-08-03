package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 检查序列是否有效的一种思路是我们遍历这个序列，并使用一个变量 balance 表示左括号的数量减去右括号的数量。
 * 如果在遍历过程中 balance 的值小于零，或者结束时 balance 的值不为零，那么该序列就是无效的，否则它是有效的。
 */

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParenthesis {

  private List<String> list;

  public List<String> generateParenthesis(int n) {
    list=new ArrayList<>();
    String s="";
    generate(0,0,n,s);
    return list;
  }

  private void generate(int left, int right, int n, String s) {
    //terminator
    if(left==n && right==n){
      list.add(s);
      System.out.println(s);
      return;
    }
    //process current logic
    /**
     * 左括号随时都可以加只要别超过n
     * 右括号小于左括号的数量的时候还有小于n的时候才能添加
     */
    if(left<n){  //还能添加左括号
      generate(left+1,right,n,s+"(");
    }
    if(right<n && right<left){
      generate(left,right+1,n,s+")");
    }
    //drill down
  }


  public static void main(String[] args) {
    System.out.println(new GenerateParenthesis().generateParenthesis(3));
  }
}
