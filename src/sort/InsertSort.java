package sort;

import java.util.LinkedList;

public class InsertSort {

  //插入排序
  /**
   * 将每次遍历到的数插入到前面已经排好序的组合中
   * 时间复杂度O(n^2)
   * 最坏的情况是：外层为n，内层为1+2+...+n,O(n(n+1)/2)=O(n^2)
   * 空间复杂度O(1) 通过移位，不需要多余的空间
   * @param array
   */
  public void sort(int[] array){
    int cur;
    int j;
    for(int i=1;i<array.length;i++){
      cur=array[i];
      j=i-1;
      while( j>=0 && array[j]>cur){
        array[j+1]=array[j];
        j--;
      }
      array[j+1]=cur;
    }
  }

  public void insertionSort(int[] nums){
    if(nums.length<=1) return;
    for(int i=1;i<nums.length;i++){
      int temp=nums[i];
      int j=i-1;
      while(j>=0){
        if(nums[j]>temp){
          nums[j+1]=nums[j];
          j--;
        }else{
          break;
        }
      }
      nums[j+1]=temp;
    }
  }

  public void insertSort(int[] nums){
      for(int i=1;i<nums.length;i++){
        int t=nums[i];
        int j=i;
        for(j=i;j>0 && nums[j-1]>t ; j--){
           nums[j]=nums[j-1];
        }
        nums[j]=t;
      }
  }


  public static void main(String[] args) {
    int[] nums={9,8,7,6,5,4,3,2,1,0};
    new InsertSort().insertSort(nums);
    for(Integer i:nums){
      System.out.print(i);
    }
  }
}
