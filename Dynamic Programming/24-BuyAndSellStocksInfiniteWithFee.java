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
        int transfee=scn.nextInt();
        System.out.println(buySellInfiniteTransactionwithFeeM2(prices,transfee));
    }
    public static int buySellInfiniteTransactionwithFee(int prices[],int fee){
        int n=prices.length;
        int dp[][]=new int[2][n];
        dp[0][0]=-prices[0];
        dp[1][0]=0;
        for(int i=1;i<n;i++){
            dp[0][i]=Math.max(dp[0][i-1],dp[1][i-1]-prices[i]); //0th row represent max profit which we can earn if we buy the stock between 0 to ith day
            
            dp[1][i]=Math.max(dp[1][i-1],dp[0][i-1]+prices[i]-fee);  //1st row represent max profit which we can earn if we sell the stock between 0 to ith day
        }
     
        return dp[1][n-1];
    }
     public static int buySellInfiniteTransactionwithFeeM2(int prices[],int fee){
        int n=prices.length;
        int buy=-prices[0];
        int sell=0;
        for(int i=1;i<n;i++){
          buy=Math.max(buy,sell-prices[i]);
          sell=Math.max(sell,buy+prices[i]-fee);
          
        }
     
        return sell;
    }
    

}