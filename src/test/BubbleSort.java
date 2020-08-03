package test;

public class BubbleSort {

  public void sort(int[] nums){
    boolean isSorted=false;
    for(int i=nums.length-1;i>=0&&!isSorted;i--){
      isSorted=true;
      for(int j=0;j<i;j++){
        if(nums[j]>nums[j+1]){
          swap(nums,j,j+1);
          isSorted=false;
        }
      }
    }
  }

  private void swap(int[] nums,int i,int j){
    int temp=nums[i];
    nums[i]=nums[j];
    nums[j]=temp;
  }

  public static void main(String[] args) {
    int[] nums={3,0,4,1,2,5,9,8,7,6};
    new BubbleSort().sort(nums);
    for(Integer i:nums){
      System.out.print(i);
    }
  }

}
