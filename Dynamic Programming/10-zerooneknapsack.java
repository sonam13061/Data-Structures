import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
   Scanner scn=new Scanner(System.in);
   int n=scn.nextInt();
   int values[]=new int[n];
   for(int i=0;i<n;i++){
       values[i]=scn.nextInt();
   }
   int weights[]=new int[n];
   for(int i=0;i<n;i++){
       weights[i]=scn.nextInt();
   }
   int cap=scn.nextInt();
    System.out.println(zerooneknapsack(values,weights,cap));
    }
    public static int zerooneknapsack(int values[],int weights[],int cap){
        int n=values.length;
        int dp[][]=new int[n+1][cap+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j-weights[i-1]>=0){
                dp[i][j]=Math.max(dp[i-1][j],values[i-1]+dp[i-1][j-weights[i-1]]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][cap];
    }
}