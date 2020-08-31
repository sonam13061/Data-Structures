import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
     Scanner scn=new Scanner(System.in);
     int n=scn.nextInt();
     int k=scn.nextInt();
     int arr[][]=new int[n][k];
     for(int i=0;i<n;i++){
         for(int j=0;j<k;j++){
             arr[i][j]=scn.nextInt();
         }
     }
     System.out.println(painthousemanycolors(arr));
    }
    public static int painthousemanycolors(int arr[][]){
        int n=arr.length;
        int k=arr[0].length;
        int dp[][]=new int[n][k];
        for(int i=0;i<k;i++){
            dp[0][i]=arr[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<k;j++){
                dp[i][j]=arr[i][j];
                int min=Integer.MAX_VALUE;
                for(int l=0;l<k;l++){
                    if(l!=j){
                        min=Math.min(min,dp[i-1][l]);
                    }
                }
                dp[i][j]=dp[i][j]+min;
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            min=Math.min(min,dp[n-1][i]);
        }
        return min;
    }
}