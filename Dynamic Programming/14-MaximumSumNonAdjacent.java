import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner scn=new Scanner(System.in);
       int n=scn.nextInt();
       int arr[]=new int[n];
       for(int i=0;i<n;i++){
           arr[i]=scn.nextInt();
       }
       System.out.println(maxNonAdjacentEle(arr));
    }
    public static int maxNonAdjacentEle(int arr[]){
        
        int dp[][]=new int[2][arr.length];
        //0th row:- if we dont include the current element
        //1st row:-if we include the current element.
        dp[0][0]=arr[0];
        dp[1][0]=0;
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]=arr[i]+dp[1][i-1];
            dp[1][i]=Math.max(dp[0][i-1],dp[1][i-1]);
        }
        return Math.max(dp[0][arr.length-1],dp[1][arr.length-1]);
    }
}