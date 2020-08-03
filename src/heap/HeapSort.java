package heap;

import java.util.Arrays;

/**
 * 堆排序，最小堆排序完后是递减序列，因为堆顶最小的元素每次都被放到最后
 * 最大堆排序完后是递增序列
 */
public class HeapSort {
  /**
   * 下沉操作
   * @param arr
   * @param parent  要下沉的元素的下标
   * @param length  二叉堆的长度
   * @return
   */
  public int[] downAdjust(int[] arr,int parent,int length){
    int temp=arr[parent];
    int child=2*parent+1;//左孩子的坐标
    while(child<length){
      if(child+1<length && arr[child]>arr[child+1]){
        child++;
      }
      if(temp<arr[child]){
        break;
      }
      arr[parent]=arr[child];
      parent=child;
      child=2*parent+1;
    }
    arr[parent]=temp;
    return arr;
  }


  public int[] heapSort(int[] arr,int length){
    for(int i=(length-2)/2;i>=0;i--){
      arr=downAdjust(arr,i,length);
    }
    for(int i=length-1;i>=1;i--){
      int temp=arr[0];
      arr[0]=arr[i];
      arr[i]=temp;
      arr=downAdjust(arr,0,i);
    }
    return arr;
  }

  public static void main(String[] args) {
//    int[] nums={9,8,7,6,5,4,3,2,1,0};
    int[] nums={2,1,3,5,4,0,6,8,9,7};
    System.out.println(Arrays.toString(new HeapSort().heapSort(nums,10)));
  }

}
