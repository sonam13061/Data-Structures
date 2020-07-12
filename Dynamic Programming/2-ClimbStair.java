import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        //System.out.println(climbstairs(n,new int[n+1]));
        System.out.println(climbstairsTabulation(n));
        
    }
    //Memoization
    public static int climbstairs(int n,int dp[]){
        if(n<0){
            return 0;
        }
        if(n==0){
            return dp[n]=1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int minone=climbstairs(n-1,dp);
        int mintwo=climbstairs(n-2,dp);
        int minthree=climbstairs(n-3,dp);
        return dp[n]=minone+mintwo+minthree;
    }
    //tablulation;
    public static int climbstairsTabulation(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            if(i-1>=0){
                dp[i]=dp[i]+dp[i-1];
            }
            if(i-2>=0){
                dp[i]=dp[i]+dp[i-2];
            }
            if(i-3>=0){
                dp[i]=dp[i]+dp[i-3];
            }
        }
        return dp[n];
    }

}