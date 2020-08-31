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
       int target=scn.nextInt();
       System.out.println(canTargetAcheived(arr,target));
       
    }
    public static boolean canTargetAcheived(int arr[],int target){
        int n=arr.length;
        boolean dp[][]=new boolean[n+1][target+1];
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(j==0){
                    dp[i][j]=true;
                }
                else{
                    if(j-arr[i-1]>=0){
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-arr[i-1]];
                    }
                    else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
        }
        for(int i=0;i<dp.length;i++){
            if(dp[i][target]==true){
                return true; 
            }
        }
        return false;
    }
}