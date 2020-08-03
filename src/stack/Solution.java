package stack;

import java.util.*;

public class Solution {

  /**
   * 下一个更大的元素
   * @param nums1
   * @param nums2
   * @return
   */
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Map<Integer,Integer> map=new HashMap<>();
    Stack<Integer> stack=new Stack<>();
    for(int i=0;i<nums2.length;i++){
      if(stack.isEmpty()){
        stack.push(nums2[i]);
        continue;
      }
      if(nums2[i]>stack.peek()) {
        while(!stack.isEmpty()){
          if(stack.peek()<nums2[i]){
            map.put(stack.pop(),nums2[i]);
          }else{
            break;
          }
        }
      }
      stack.push(nums2[i]);
    }
    int[] list=new int[nums1.length];
    for(int i=0;i<nums1.length;i++){
      if(!map.containsKey(nums1[i])){
        list[i]=-1;
      }else{
        list[i]=map.get(nums1[i]);
      }
    }
    return list;
  }

  /**
   * 棒球比赛
   * @param ops
   * @return
   */
  public static int calPoints(String[] ops) {
    Stack<Integer> stack=new Stack<>();
    int num1;
    int num2;
    for(int i=0;i<ops.length;i++){
      switch (ops[i]){
        case "+" :
          num1=stack.pop();
          num2=stack.pop();
          stack.push(num2);
          stack.push(num1);
          stack.push(num1+num2);
          break;
        case "D" :
          num1=stack.peek();
          stack.push(num1*2);
          break;
        case "C" :
          stack.pop();
          break;
        default:
          stack.push(Integer.valueOf(ops[i]));
      }
    }
    int sum=0;
    while(!stack.isEmpty()){
      sum+=stack.pop();
    }
    return sum;
  }

  /**
   * 比较含退格的字符串
   * @param S
   * @param T
   * @return
   */
  public static boolean backspaceCompare(String S, String T) {
    Stack<Character> string1=new Stack<>();
    Stack<Character> string2=new Stack<>();
    for(char c:S.toCharArray()){
      if(c!='#'){
        string1.push(c);
      }else if(c=='#'&& !string1.isEmpty()){
        string1.pop();
      }
    }
    for(char c:T.toCharArray()){
      if(c!='#'){
        string2.push(c);
      }else if(c=='#'&& !string2.isEmpty()){
        string2.pop();
      }
    }
    while(!string1.isEmpty()&&!string2.isEmpty()){
      if(string1.pop()!=string2.pop()){
        return false;
      }
    }
    if(string1.isEmpty()&&string2.isEmpty()){
      return true;
    }
    return false;
  }

  /**
   * 删除最外层的括号
   * level代表最外层括号是否有
   * @param S
   * @return
   */
  public String removeOuterParentheses(String S) {
    int level=0;
    StringBuilder stringBuilder=new StringBuilder();
    for(char c:S.toCharArray()){
      if(c==')') --level;
      if(level>=1) stringBuilder.append(c);
      if(c=='(') ++level;
    }
    return stringBuilder.toString();
  }

  /**
   * 除去重复
   * @param S
   * @return
   */
  public static String removeDuplicates(String S) {
    Stack<Character> stack=new Stack<>();
    for(char c:S.toCharArray()){
      if(stack.isEmpty()){
        stack.push(c);
        continue;
      }
      if(c==stack.peek()){
        stack.pop();
      }else{
        stack.push(c);
      }
    }
    Stack<Character> result=new Stack<>();
    StringBuilder stringBuilder=new StringBuilder();
    while(!stack.isEmpty()){
      result.push(stack.pop());
    }
    while(!result.isEmpty()){
      stringBuilder.append(result.pop());
    }
    return stringBuilder.toString();
  }

  public List<String> buildArray(int[] target, int n) {
    Stack<Integer> stack=new Stack<>();
    List<String> list=new ArrayList<>();
    for(int i=target.length-1;i>=0;i--){
      stack.push(target[i]);
    }
    for(int i=1;i<=n;i++){
      if(stack.isEmpty()){
        break;
      }
      if(stack.peek()==i){
        list.add("Push");
        stack.pop();
      }else{
        list.add("Push");
        list.add("Pop");
      }
    }
    return list;
  }

  /**
   * 滑动窗口的最大值
   */
  public int[] maxSlidingWindow(int[] nums, int k) {
    int[] result=new int[nums.length-(k-1)]; //窗口的右边界
    if(nums.length==0||nums.length<k){
      return nums;
    }
    Deque<Integer> dq=new LinkedList<>(); //双端队列里存的是下标
    for(int i=0;i<nums.length;i++){
      //头部：判断是否需要移除，防止超过窗口的大小
      if(!dq.isEmpty() && dq.getFirst()<(i-k+1)){ //i-k+1代表的是此时窗口最左边的下标
        dq.removeFirst();
      }
      //移除尾部小于当前值的元素
      while(!dq.isEmpty() && nums[i]>=nums[dq.getLast()]){
        dq.removeLast();
      }
      //从尾部插入元素，即窗口右移
      dq.addLast(i);
      //从头部返回当前窗口的最大值
      if(i>=k-1){
        result[i-k+1]=nums[dq.getFirst()];
      }
    }
    return result;
  }

  public static void main(String[] args) {
//    int[] nums1={2,4};
//    int[] nums2={1,2,3,4};
//    int[] list=nextGreaterElement(nums1,nums2);
//    for(int i=0;i<list.length;i++){
//      System.out.println(list[i]);
//    }

//    String[] list={"5","-2","4","C","D","9","+","+"};
//    System.out.println(calPoints(list));

//    String S="a#c";
//    String T="b";
//    System.out.println(backspaceCompare(S,T));

    System.out.println(removeDuplicates("abbaca"));
  }

}
