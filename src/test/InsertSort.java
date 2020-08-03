package test;

public class InsertSort {

  public void sort(int[] nums){
    for(int i=1;i<nums.length;i++){
      int cur=nums[i];
      int j=i-1;
      while(j>=0 && nums[j]>cur){
        nums[j+1]=nums[j];
      }
      swap(nums,j+1,i);
    }
  }

  private void swap(int[] nums,int i,int j){
    int temp=nums[i];
    nums[i]=nums[j];
    nums[j]=temp;
  }

  public static void main(String[] args) {
//    int[] nums={3,0,4,1,2,5,9,8,7,6};
    int[] nums={9,8,7,6,5,4,3,2,1};
    new InsertSort().sort(nums);
    for(Integer i:nums){
      System.out.print(i);
    }
  }

}
