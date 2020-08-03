package sort;

public class QuickSort {

  //快速排序
  /**
   * 对于当前数组，选最后一个元素当作基准数
   * 将所有比基准数小的元素排到基准数之前，比基准数大的元素排到基准数之后
   * 然后根据基准数的位置将数组分为前后两个子数组
   * 对自数组重复上述操作
   *
   * 最糟糕的情况下就是数组从大到小排序的，每次选择基数都要排到最前面，即n+(n-1)+...+1 O(n^2)
   * 平均时间复杂度O(nlogN)
   * 平均空间复杂度O(logN)
   */
  public void quickSort(int[] array,int left,int right){
    if(left>right) return;
    int index=partition(array,left,right);
    quickSort(array,left,index-1);
    quickSort(array,index+1,right);
  }

  /**
   * 划分数组
   * @param array
   * @param left 数组的左边界
   * @param right 数组的右边界
   * @return
   */
  public int partition(int[] array,int left,int right){
    int pivot=array[right];  //选取最后一个数作为基准数
    int leftIndex=left;      //用来从左遍历的下标
    int rightIndex=right-1;  //用来从右遍历的下标
    while(true){
      while(leftIndex<right && array[leftIndex]<pivot) leftIndex++; //从左开始遍历，找到比基准数大的数字
      while(rightIndex>=left && array[rightIndex]>pivot) rightIndex--; //从右开始遍历，找到比基准数小的数字
      if(leftIndex>rightIndex) break;
      swap(array,leftIndex,rightIndex);
    }
    swap(array,leftIndex,right); //swap pivot to the right position 将基准数放到正确的位置
    return leftIndex;
  }


  /**
   * 交换
   */
  public void swap(int[] array,int leftIndex,int rightIndex){
    int temp=array[leftIndex];
    array[leftIndex]=array[rightIndex];
    array[rightIndex]=temp;
  }

  public static void main(String[] args) {
//    int[] nums={9,8,7,6,5,4,3,2,1,0};
    int[] nums={3,0,4,1,2,5,9,8,7,6};
    new QuickSort().quickSort(nums,0,nums.length-1);
    for(Integer i:nums){
      System.out.print(i);
    }
  }

}
