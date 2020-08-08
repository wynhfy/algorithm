package sort;

public class MergeSort {

  //归并排序
//  public void merge(int[] array,int left,int mid,int right){
//    int[] tmp=new int[array.length];
//    int i=left,j=mid+1,k=left;
//    while(i<=mid&&j<=right){
//      if(array[i]<=array[j]){
//        tmp[k++]=array[i++];
//      }else{
//        tmp[k++]=array[j++];
//      }
//    }
//    while(i<=mid) tmp[k++]=array[i++];
//    while(j<=right) tmp[k++]=array[j++];
//    for(int a=left;a<=right;a++){
//      array[a]=tmp[a];
//    }
//  }
//
//  public void mergeSort(int[] array,int start,int end){
//    if(start<end){
//      int mid=(start+end)/2;
//      mergeSort(array,start,mid);   //对左侧子序列进行递归排序
//      mergeSort(array,mid+1,end); //对右侧子序列进行递归排序
//      merge(array,start,mid,end); //合并两个数组
//    }
//  }

  public void mergeSort(int[] nums,int start,int end){
    if(start<end){
      int mid=(start+end)/2;     //从中间将数组分为两部分
      mergeSort(nums,start,mid); //左半部分进行归并排序
      mergeSort(nums,mid+1,end); //有半部分进行归并排序
      merge(nums,start,mid,end); //合并两个排好序的数组
    }
  }
  private void merge(int[] nums,int left,int mid,int right){
    int leftSize=mid-left+1;
    int rightSize=right-mid;
    int[] tmpLeft=new int[leftSize+1];
    int[] tmpRight=new int[rightSize+1];
    for(int i=0;i<leftSize;i++) tmpLeft[i]=nums[left+i];
    for(int i=0;i<rightSize;i++) tmpRight[i]=nums[mid+1+i];
    tmpLeft[leftSize]=Integer.MAX_VALUE;
    tmpRight[rightSize]=Integer.MAX_VALUE;
    for(int k=left,i=0,j=0;k<=right;k++){
      if(tmpLeft[i]<tmpRight[j]) nums[k]=tmpLeft[i++];
      else nums[k]=tmpRight[j++];
    }
  }

  public static void main(String[] args) {
    int[] nums={3,0,4,1,2,5,9,8,7,6};
    new MergeSort().mergeSort(nums,0,nums.length-1);
    for(Integer i:nums){
      System.out.print(i);
    }
  }



}
