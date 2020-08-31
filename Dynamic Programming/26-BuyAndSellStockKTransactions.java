import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        int k=scn.nextInt();
        System.out.println(buyandsellktransactions(arr,k));
    }
    public static int buyandsellktransactions(int prices[],int k){
        int dp[][]=new int[k+1][prices.length];
        for(int i=1;i<=k;i++){
            for(int j=1;j<prices.length;j++){
                int max=Integer.MIN_VALUE;
                //max denoted that if we buy a product at x and sell it at j,then what will be the 
                //maximum profit till price[j] by doing at most ith transaction.
                for(int x=0;x<j;x++){
                    int ct=prices[j]-prices[x]+dp[i-1][x];
                    max=Math.max(max,ct);
                }
        
                dp[i][j]=Math.max(max,dp[i][j-1]);
            }
        }
        return dp[k][prices.length-1];
    }

}