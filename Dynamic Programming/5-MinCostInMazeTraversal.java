import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
      Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=scn.nextInt();
            }
        }
        int dp[][]=new int[n][m];
        //System.out.println(MinCostMemo(arr,0,0,dp));
        System.out.println(MinCostTabulation(arr));
    }
    
    public static int MinCostMemo(int cost[][],int i,int j,int dp[][] ){
        if(i>=cost.length || j>=cost[0].length){
            return Integer.MAX_VALUE;
        }
        if(i==cost.length-1 && j==cost[0].length-1){
            return dp[i][j]=cost[i][j];
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int bottomcost=MinCostMemo(cost,i+1,j,dp);
        int rightcost=MinCostMemo(cost,i,j+1,dp);
        
        return dp[i][j]=(Math.min(bottomcost,rightcost)+cost[i][j]);
    }
    public static int MinCostTabulation(int cost[][]){
        int n=cost.length;
        int m=cost[0].length;
      int dp[][]=new int[n][m];
      for(int i=n-1;i>=0;i--){
          for(int j=m-1;j>=0;j--){
              if(i==n-1 && j==m-1){
                  dp[i][j]=cost[i][j];
              }
              else if(i==n-1){
                  dp[i][j]=dp[i][j+1]+cost[i][j];
              }
              else if(j==m-1){
                  dp[i][j]=dp[i+1][j]+cost[i][j];
              }
              else{
                  dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])+cost[i][j];
              }
          }
      }
        return dp[0][0];
    } 

}