package Bit;

public class HammingWeight {

    public int hammingWeight(int n){
        int count=0;
        while(n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }

    public int hammingWeight1(int n) {
        int count=0;
        while(n!=0){
            count+=n&1;
            n>>>=1;
        }
        return count;
    }

    public int hamingWeight(int n){
        int count=0;
        int flag=1;
        while(flag!=0){
            if((n&flag)!=0){
                count++;
            }
            flag<<=1;
        }
        return count;
    }

}
