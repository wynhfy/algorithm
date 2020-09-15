package window;

import java.util.*;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 *
 * 1、暴力的解法
 *   第一层循环：n-(k-1) 第二层循环 k  时间复杂度 O(n*k)
 *
 * 2、优先队列
 *   底层基于一个完全二叉树来完成  时间复杂度O(nlogk)
 *
 * 3、单调双端队列
 *   双端队列存的是数组的下标，这样才可以判断是否改变滑动窗口的范围
 *
 */
public class MaxSlidingWindow {

  public int[] maxSlidingWindow1(int[] nums,int k){
    if(nums.length==0) return new int[]{};
    int len=nums.length-k+1;
    int[] result=new int[len];
    for(int i=0;i<len;i++){
      result[i]= Arrays.stream(nums,i,i+k).max().getAsInt();
    }
    return result;
  }

  /**
   * 使用双端队列解决
   */
  public int[] maxSlidingWindow(int[] nums,int k){
    if(nums.length==0 || nums.length<k) return nums;
    //deque存的是下标
    Deque<Integer> deque=new LinkedList<>();
    int[] result=new int[nums.length-(k-1)];
    for(int i=0;i<nums.length;i++){
      //头，判断是否超出范围，超出则从头部移除
      if(!deque.isEmpty() && deque.getFirst()<(i-(k-1))){
        deque.removeFirst();
      }
      //尾，将比当前值还小的从尾部移除
      while(!deque.isEmpty() && nums[deque.getLast()]<nums[i]){
        deque.removeLast();
      }
      //尾，尾部入队
      deque.addLast(i);
      //头，从头部返回最大值
      if(i>=k-1){
        result[i-(k-1)]=nums[deque.getFirst()];
      }
    }
    return result;
  }



}
