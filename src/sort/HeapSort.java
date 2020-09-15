package sort;

import java.util.Arrays;
import java.util.HashSet;

public class HeapSort {

    public int[] heapSort(int[] array){
        int[] arr = Arrays.copyOf(array,array.length);
        //构建大顶堆,从最后一个非叶子结点开始下沉
        for(int i=(arr.length-2)/2;i>=0;i--){
            heapify(arr,i,arr.length);
        }
        //开始堆排序，每次将最大的元素放到最后，然后让首元素下沉
        for(int i=arr.length-1;i>=1;i--){
            int temp=arr[i]; //当前堆中最大的元素
            arr[i]=arr[0];     //将最大的元素放到最后
            arr[0]=temp;
            heapify(arr,0,i);
        }
        return arr;
    }

    /**
     * @param arr  堆
     * @param index 要下沉的坐标
     * @param length 当前堆的长度
     */
    public void heapify(int[] arr,int index,int length){
        int leftChild=index*2+1;  //左孩子的下标
        int curValue=arr[index];  //记录当前的值
        while(leftChild<length){
            //如果有右孩子，找出左右孩子中最大的
            if(leftChild+1<length && arr[leftChild]<arr[leftChild+1]) leftChild++;
            //如果孩子中的最大值比父节点大，则交换
            if(arr[leftChild] < curValue) break;
            arr[index]=arr[leftChild];
            index=leftChild;
            leftChild=2*index+1;
        }
        arr[index]=curValue;

    }

    public static void main(String[] args) {
    int[] nums={9,8,7,6,5,4,3,2,1,0};
//        int[] nums={2,1,3,5,4,0,6,8,9,7};
        System.out.println(Arrays.toString(new HeapSort().heapSort(nums)));
        System.out.println(HeapSort.result(9876673));
    }

    public static int result(int n){
        int temp;
        int compare=-1;
        StringBuilder string=new StringBuilder();
        while(n!=0){
            temp=n%10;
            if(temp!=compare){
                string.append(temp);
                compare=temp;
            }
            n/=10;
        }
        return Integer.parseInt(string.toString());
    }

}
