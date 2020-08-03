package Bit;

import java.util.HashMap;
import java.util.Map;

/**
 * 136. 只出现一次的数字
 */
public class SingleNumber {

  public int singleNumber(int[] nums) {
    int result=nums[0];
    for(int i=1;i<nums.length;i++){
      result^=nums[i];
    }
    return result;
  }


  public int singleNumber2(int[] nums){
    HashMap<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<nums.length;i++){
      if(!map.containsKey(nums[i])){
        map.put(nums[i],1);
      }else if(map.containsKey(nums[i])&&map.get(nums[i])==2){
        map.remove(nums[i]);
      }else{
        map.put(nums[i],map.get(nums[i])+1);
      }
    }
    for(Map.Entry<Integer,Integer> entry:map.entrySet()){
      return entry.getKey();
    }
    return -1;
  }

  public static void main(String[] args) {
    int nums[]={0,1,0,1,0,1,99};
    System.out.println(new SingleNumber().singleNumber2(nums));

    int x=1;
    int y=2;
    x=x^y;
    y=x^y;
    x=x^y;
    System.out.println(x+" "+y);

  }

}
