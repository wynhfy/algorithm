package test;

public class SelectionSort {

  public void sort(int[] nums){
    for(int i=0;i<nums.length;i++){
      int min=i;
      for(int j=i+1;j<nums.length;j++){
        if(nums[j]<nums[i]){
          min=j;
        }
      }
      swap(nums,min,i);
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
    new SelectionSort().sort(nums);
    for(Integer i:nums){
      System.out.print(i);
    }
  }

}
