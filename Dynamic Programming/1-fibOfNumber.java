import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    //System.out.println(fib(n,new int[n+1]));
    System.out.println(fibtabulation(n));
 }
 //Memoization
 public static int fib(int n,int[]dp){
     if(n==0 || n==1){
         return dp[n]=n;
     }
     if(dp[n]!=0){
         return dp[n];
     }
     int ans=fib(n-1,dp)+fib(n-2,dp);
     return dp[n]=ans;
 }
 //Tabulation
 public static int fibtabulation(int n){
     int dp[]=new int[n+1];
     dp[1]=1;
     for(int i=2;i<=n;i++){
         dp[i]=dp[i-1]+dp[i-2];
     }
     return dp[n];
 }

}