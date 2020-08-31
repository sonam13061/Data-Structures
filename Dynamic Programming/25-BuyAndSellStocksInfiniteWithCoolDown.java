import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int prices[]=new int[n];
        for(int i=0;i<n;i++){
            prices[i]=scn.nextInt();
        }
        System.out.println( BuyAndSellInfiniteWithCoolDown(prices));
    }
    public static int BuyAndSellInfiniteWithCoolDown(int prices[]){
        int n=prices.length;
        int dp[][]=new int[2][n];
        dp[0][0]=-prices[0];
        dp[1][0]=0;
        dp[0][1]=Math.max(dp[0][0],-prices[1]);
        dp[1][1]=Math.max(dp[1][0],dp[0][0]+prices[1]);
        for(int i=2;i<n;i++){
            dp[0][i]=Math.max(dp[0][i-1],dp[1][i-2]-prices[i]);
            dp[1][i]=Math.max(dp[1][i-1],dp[0][i-1]+prices[i]);
        }
        // for(int i=0;i<2;i++){
        //     for(int j=0;j<prices.length;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
     return dp[1][n-1];
    }

}