import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner scn=new Scanner(System.in);
       int n=scn.nextInt();
       int dp[]=new int[n+1];
       dp[1]=1; //....coz if we have 2*1 board,then we have only option to place the tile horizontly
       dp[2]=2 ; //,,if we have 2*2 then we have 2 options,either place both tiles horizontal or both vertical.
       for(int i=3;i<dp.length;i++){
           dp[i]=dp[i-1]+dp[i-2];
           //cause we place a verical tile,then our problem reduces to n-1.
           //and if we place a horizontal tule,then our problem reduces to n-2.
       }
       System.out.println(dp[n]);
       
    }
}