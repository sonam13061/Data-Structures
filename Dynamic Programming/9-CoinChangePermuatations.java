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
       int amnt=scn.nextInt();
       System.out.println(coinchangePermutations(arr,amnt));
    }
    public static int coinchangePermutations(int arr[],int amnt){
        int dp[]=new int[amnt+1];
        dp[0]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[j]<=i){
                    dp[i]=dp[i]+dp[i-arr[j]];
                }
            }
        }
        
        return dp[amnt];
    }
}