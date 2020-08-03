package array;

/**
 * 26. 删除排序数组中的重复项
 */
public class RemoveDuplicates {

  /**
   * 双指针法 遇到相同的i就向后移动，遇到不同的j向后移动一位，然后将下标为i的值赋值到j的位置，最后j+1即为不同的个数(因为从零开始)
   * @param nums
   * @return
   */
  public int removeDuplicates(int[] nums) {
    int j=0;
    for(int i=1;i<nums.length;i++){
      if(nums[i]!=nums[j]){
        j++;
        nums[j]=nums[i];
      }
    }
    return j+1;
  }

  public int removeDuplicates1(int[] nums){
    int i=0;
    int j=1;
    while(j<nums.length){
      if(nums[i]==nums[j]) j++;
      else{
        nums[i+1]=nums[j];
        i++;
        j++;
      }
    }
    return i+1;
  }

}
