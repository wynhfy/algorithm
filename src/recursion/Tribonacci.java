package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 1137. 第 N 个泰波那契数
 */
public class Tribonacci {

  private Map<Integer,Integer> map=new HashMap<>();

  public int tribonacci(int n) {
    if(n==0) return 0;
    if(n==1 || n==2) return 1;
    if(map.containsKey(n)){
      return map.get(n);
    }else{
      map.put(n,tribonacci(n-3)+tribonacci(n-2)+tribonacci(n-1));
      return map.get(n);
    }
  }

  public static void main(String[] args) {
    System.out.println(new Tribonacci().tribonacci(25));
  }

}
