import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner scn=new Scanner(System.in);
       int n=scn.nextInt();
       int m=scn.nextInt();
       int dp[]=new int[n+1];
       //cell meaning:-- Number of ways of placing tiles in i*m
       for(int i=1;i<dp.length;i++){
           if(i<m){
               dp[i]=1; //we have only one way to place all the tiles vertical.
           }
           else if(i==m){
               dp[i]=2; //we have 2 options.Either place all the tiles horizontal or vertical.
           }
           else{
           dp[i]=dp[i-1]+dp[i-m]; 
           //if we place current tile vertical then our problem will reduce to i-1.
           //if we place current tile horizontal then our problem will reduce to i-m.
           }
       }
      
       System.out.println(dp[n]);
       
    }
}