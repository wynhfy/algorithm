package heap;

/**
 * 二叉堆的基本实现：增、删、构建
 */
public class BinaryHeap {

  /**
   * 上浮操作
   * @param arr
   * @param length  二叉堆的长度
   * @return
   */
  public int[] upAdjust(int[] arr,int length){
    int child=length-1;  //得到要插入的节点，即最后一个节点。
    int parent=(child-1)/2; //得到插入节点的父节点。
    int temp=arr[child]; //将要插入的值保存
    //上浮操作
    while(child>=0 && temp<arr[parent]){
      //无需每次进行交换，只需进行单向赋值即可，最后再将temp赋值即可。
      arr[child]=arr[parent];
      child=parent;
      parent=(child-1)/2;
    }
    arr[child]=temp;
    return arr;
  }

  /**
   * 下沉操作
   * @param arr
   * @param parent  标记要下沉元素的下标
   * @param length  二叉堆的长度
   * @return
   */
  public int[] downAdjust(int[] arr,int parent,int length){
    int temp=arr[parent];
    //左孩子的下标
    int child=2*parent+1;
    while(child<length){
      //有右节点，且右节点的值比左节点的小（即选出左右节点中最小的一个）
      if(child+1<length && arr[child]>arr[child+1]){
        child++;
      }
      //如果父节点比左右节点都小
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

  /**
   * 构建二叉堆
   * @param arr
   * @param length
   * @return
   */
  public int[] buildHeap(int[] arr,int length){
    //从最后一个非叶子节点开始下沉
    for(int i=(length-2)/2;i>=0;i--){
      arr=downAdjust(arr,i,length);
    }
    return arr;
  }

}
