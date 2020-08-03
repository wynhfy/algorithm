package sort;

/**
 * 选择排序
 */
public class SelectionSort {

  /**
   * 从数组中选出最小的元素，和数组的第一个位置交换
   * 再从剩下的数组中选出最小的元素，与数组的第二个位置交换，直到整个数组排好序
   */
  public void sort(int[] nums){
    for(int i=0;i<nums.length-1;i++){
      int min=i;
      for(int j=i+1;j<nums.length;j++){
        if(nums[min]>nums[j]){
          min=j;
        }
      }
      swap(nums,i,min);
    }
  }

  private static void swap(int[] nums,int i,int j){
    int temp=nums[i];
    nums[i]=nums[j];
    nums[j]=temp;
  }

  public static void main(String[] args) {
//    int[] nums={3,0,4,1,2,5,9,8,7,6};
    int[] nums={9,8,7,6,5,4,3,2,1,0};
    new SelectionSort().sort(nums);
    for(Integer i:nums){
      System.out.print(i);
    }
  }

}
