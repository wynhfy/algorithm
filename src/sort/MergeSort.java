package sort;

public class MergeSort {

  //归并排序
  public void merge(int[] array,int left,int mid,int right){
    int[] tmp=new int[array.length];
    int i=left,j=mid+1,k=left;
    while(i<=mid&&j<=right){
      if(array[i]<=array[j]){
        tmp[k++]=array[i++];
      }else{
        tmp[k++]=array[j++];
      }
    }
    while(i<=mid) tmp[k++]=array[i++];
    while(j<=right) tmp[k++]=array[j++];
    for(int a=left;a<=right;a++){
      array[a]=tmp[a];
    }
  }

  public void mergeSort(int[] array,int start,int end){
    if(start<end){
      int mid=(start+end)/2;
      mergeSort(array,start,mid);   //对左侧子序列进行递归排序
      mergeSort(array,mid+1,end); //对右侧子序列进行递归排序
      merge(array,start,mid,end); //合并两个数组
    }
  }

}
