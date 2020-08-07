package sort;

public class BubbleSort {


  /**
   * 外层循环表示每次遍历比较的次数
   * 内层循环用于实际的遍历
   * 每次将最大的元素置于最右边
   */
  public void sort(int[] nums){
    boolean isSorted=false;//用来查看是否已经排好序了，如果在其中一次遍历的过程中没有发生交换，则代表是已经排好序的，可以直接退出
    for(int i=nums.length-1;i>0&&!isSorted;i--){
      isSorted=true;
      for(int j=0;j<i;j++){
        if(nums[j]>nums[j+1]){
          swap(nums,j,j+1);
          isSorted=false;
        }
      }
      if(isSorted) break;
    }
  }

  private static void swap(int[] nums,int i, int j){
    int temp=nums[i];
    nums[i]=nums[j];
    nums[j]=temp;
  }

  public static void main(String[] args) {
//    int[] nums={3,0,4,1,2,5,9,8,7,6};
    int[] nums={9,8,7,6,5,4,3,2,1,0};
    new BubbleSort().sort(nums);
    for(Integer i:nums){
      System.out.print(i);
    }
  }

}
