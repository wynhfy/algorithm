package 动态规划;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 青蛙跳
 */
public class Jump {

    int f(int n){
        if(n<=2) return n;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=3;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

}
