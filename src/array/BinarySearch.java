package array;

public class BinarySearch {

  public int binarySearch(int[] nums,int target){
    int left=0;
    int right=nums.length-1;
    while(left<=right){
      int mid=(left+right)/2;
      if(nums[mid]==target) return mid;
      else if(nums[mid]<target) left=mid+1;
      else if(nums[mid]>target) right=mid-1;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums={0,1,2,3,4,5,6,7,8,9};
    System.out.println(new BinarySearch().binarySearch(nums,5));
  }

}
