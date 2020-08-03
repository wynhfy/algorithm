package array;

import java.util.*;

/**
 * 15. 三数之和
 */
public class ThreeSum {

  /**
   * 循环遍历i，剩下的当作两数之和那道题来解
   */
  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result=new ArrayList<>();
    Arrays.sort(nums);
    if(nums.length ==0) return result;
    for(int i=0;i<nums.length;i++){
      if(i>0 && nums[i]==nums[i-1]) continue; //先去重,保证下一次和前一次的i是不同的
      int j=i+1;
      int k=nums.length-1;
      int target=-nums[i];
      //循环将nums[i]下的所有情况列举出来，j和k就是两数之和相加的情形
      while(j<k){
        if(nums[j]+nums[k]==target){
          List<Integer> list=new ArrayList<>();
          list.add(nums[i]);
          list.add(nums[j]);
          list.add(nums[k]);
          result.add(list);
          j++; //j往后走一步
          k--; //k往前走一步
          while (j<nums.length&& nums[j]==nums[j-1]) j++; //去重
          while(k>j && nums[k]==nums[k+1]) k--; //去重
        }else if(nums[j]+nums[k]>target){   //如果两数相加大于，说明nums[k】大了
          k--;
        }else{
          j++;
        }
      }
    }
    return result;
  }


  public List<List<Integer>> threeSum1(int[] nums){
    List<List<Integer>> result=new ArrayList<>();
    Arrays.sort(nums);
    if(nums.length==0) return result;
    for(int i=0;i<nums.length;i++){
      if(i>0 && nums[i]==nums[i-1]) continue; //先去重，找到每组重复的最后一个，比如 1 1 1 2，找到最后一个1
      //剩下的两个按照找两数之和的方式去查找
      int j=i+1;
      int k=nums.length-1;
      int target=-nums[i];
      while(j<k){
        if(nums[j]+nums[k]==target){
          List<Integer> list=new ArrayList<>();
          list.add(nums[i]);
          list.add(nums[j]);
          list.add(nums[k]);
          result.add(list);
          j++;
          k--;
          //开始找下一组重复里的最后一个
          while( j<k && nums[j]==nums[j-1]) j++; //去重复
          while( j<k && nums[k]==nums[k+1]) k--; //去重复
        }else if(nums[j]+nums[k]<target){
          j++; //两数之和比目标数小，则需要增大
        }else if(nums[j]+nums[k]>target){
          k--; //两束之和比目标数大，则需要减小
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums=new int[]{-1, 0, 1, 2, -1, -4};
    System.out.println(threeSum(nums));
  }

}
