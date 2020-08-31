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
        System.out.println(LIS(arr));
    }
    public static int LIS(int arr[]){
        int n=arr.length;
        int dp[]=new int[n];
        //cell meaning:- maximum length of LIS ended at i.
        for(int i=0;i<n;i++){
            int max=0;
            //FInd the maximum LIS from 0 to i-1,then add one to the value.
            for(int j=0;j<i;j++){
                if(arr[j]<=arr[i]){
                max=Math.max(dp[j],max);
                }
            }
            dp[i]=max+1;
        }
        int max=0;
        for(int i=0;i<dp.length;i++){
            max=Math.max(max,dp[i]);
        }
        return max;
    }

}