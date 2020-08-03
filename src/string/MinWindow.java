package string;

/**
 * 76. 最小覆盖子串
 */
public class MinWindow {

  public String minWindow(String s,String t){
    int slen=s.length();
    int tlen=t.length();
    int minLength=slen+1; //记录最小的子字符串的长度
    int begin=0; //记录最小子字符串起始的位置
    int[] winFerq=new int[128]; //窗口中的各个字符出现的频数
    int[] tFerq=new int[128];
    //计算字符串t中各字母出现的频数
    for(char c:t.toCharArray()){
      tFerq[c]++;
    }
    //计算字符串t中有多少种字符
    int kinds=0;
    for (int i=0;i<tFerq.length;i++){
      if(tFerq[i]!=0){
        kinds++;
      }
    }
    int distance=0;  //计算窗口中已经有多少个字符满足要求了
    int left=0,right=0;
    //右边界先开始向右移动
    while(right<slen){
      char c=s.charAt(right);
      winFerq[c]++;
      //如果右边界的这个字符在字符串t中存在，且已经达到了个数要求的时候，distance+1
      if(tFerq[c]>0 && winFerq[c]==tFerq[c]){
        distance++;
      }
      right++;
      //如果窗口内已经满足了要求，则可以开始移动左边界了
      while(distance == kinds){
        if(right-left<minLength){
          minLength=right-left;
          begin=left;
        }
        char c1=s.charAt(left);
        winFerq[c1]--;
        //如果去掉左边这个元素后，不满足条件了则需要将distance-1
        if(tFerq[c1]>0 && winFerq[c1]<tFerq[c1]){
          distance--;
        }
        left++;
      }
    }
    if(minLength==slen+1) return "";
    return s.substring(begin,begin+minLength);
  }

  public String minWindow1(String s, String t) {
    int sLen=s.length();
    int tLen=t.length();
    if(sLen==0||tLen==0||sLen<tLen) return "";
    char[] charArrayS=s.toCharArray();
    char[] charArrayT=t.toCharArray();
    int[] winFreq=new int[128];
    int[] tFreq=new int[128];
    for(char c:charArrayT){
      tFreq[c]++;
    }
    //滑动窗口内部包含多少T中的字符，对应字符频数超过不重复计算。
    //记录窗口中已经有多少个字符满足要求了
    int distance=0;
    int minLen=sLen+1;
    int begin=0;
    int left=0;
    int right=0;
    //[left,right)
    //右指针移动的循环
    while(right<sLen){
      //如果字符串t中没有该字符，就继续右移动
      if(tFreq[charArrayS[right]]==0){
        right++;
        continue;
      }
      //找到了字符串t中的字符，则distance+1
      if(winFreq[charArrayS[right]]<tFreq[charArrayS[right]]){
        distance++;
      }
      winFreq[charArrayS[right]]++;
      right++;
      //distance=tLen代表已经找到了字符串t中的所有字符的时候，此时已经满足题目条件了，就可以开始移动左边界了
      //左指针移动的循环
      while(distance==tLen){
        if(right-left<minLen){
          minLen=right-left;
          begin=left;
        }
        //如果字符串t中没有该字符，就继续移动
        if(tFreq[charArrayS[left]]==0){
          left++;
          continue;
        }
        if(winFreq[charArrayS[left]]==tFreq[charArrayS[left]]){
          distance--;
        }
        winFreq[charArrayS[left]]--;
        left++;
      }
    }
    if(minLen==sLen+1){
      return "";
    }
    return s.substring(begin,minLen);
  }





}
