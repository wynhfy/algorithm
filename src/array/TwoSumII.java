package array;

/**
 * 167. 两数之和 II - 输入有序数组
 */
public class TwoSumII {

  public int[] twoSum(int[] numbers,int target){
    int low=0;
    int high=numbers.length-1;
    while(low<high){
      int mid=(low+high)/2;
      if(numbers[mid]==target) return new int[]{low+1,high+1};
      else if(numbers[mid]<target) low++;
      else if(numbers[mid]>target) high++;
    }
    return null;
  }

}
