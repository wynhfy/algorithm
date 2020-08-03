package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1. 两数之和
 */
public class TwoSum {

  /**
   * 空间换时间，增加一个map O(n)
   */
  public int[] twoSum2(int[] nums,int target){
    int temp;
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i=0;i<nums.length;i++){
      temp=target-nums[i];
      if(map.containsKey(temp)){
        return new int[]{map.get(temp),i};
      }
      map.put(nums[i],i);
    }
    return null;
  }

  /**
   * 暴力解法O(n2)
   */
  public int[] twoSum1(int[] nums, int target) {
    int[] list = new int[2];
    for(int i=0;i<nums.length-1;i++){
      for(int j=i+1;j<nums.length;j++){
        if(nums[i]+nums[j]==target){
          list[0]=i;
          list[1]=j;
          break;
        }
      }
    }
    return list;
  }

  public static void main(String[] args) {
    int[] nums={2,7,11,15};
    for(Integer i:new TwoSum().twoSum2(nums,9)){
      System.out.println(i);
    }
  }
}
