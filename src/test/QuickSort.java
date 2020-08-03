package test;

public class QuickSort {

  public void quickSort(int[] nums,int left,int right){
    if(left>right) return;  //⚠️
    int pivot=partition(nums,left,right);
    quickSort(nums,left,pivot-1);
    quickSort(nums,pivot+1,right);
  }

  private int partition(int[] nums,int left,int right){
    int pivot=nums[right];
    int leftIndex=left;
    int rightIndex=right-1;
    while(true){
      while(leftIndex<nums.length && nums[leftIndex]<pivot) leftIndex++;
      while(rightIndex>=0 && nums[rightIndex]>pivot) rightIndex--;
      if(leftIndex>rightIndex) break;
      swap(nums,leftIndex,rightIndex);
    }
    swap(nums,leftIndex,right);
    return leftIndex;
  }

  private void swap(int[] nums,int i,int j){
    int temp=nums[i];
    nums[i]=nums[j];
    nums[j]=temp;
  }

  public static void main(String[] args) {
    int[] nums={9,8,7,6,5,4,3,2,1,0};
    new QuickSort().quickSort(nums,0,nums.length-1);
    for(Integer i:nums){
      System.out.print(i);
    }
  }

}
