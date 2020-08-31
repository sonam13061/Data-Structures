import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int moves[]=new int[n];
        for(int i=0;i<n;i++){
            moves[i]=scn.nextInt();
        }
       // System.out.println(minMoves(0,moves,new int[n]));
       System.out.println(minmovesTabulation(moves));
    }
    //Memoization
    public static int minMoves(int i,int moves[],int dp[]){
        if(i==moves.length-1){
            return dp[i]=0;
        }
        if(dp[i]!=0){
            return dp[i];
        }
        int min=Integer.MAX_VALUE;
        for(int jumps=1;jumps<=moves[i] && jumps+i<moves.length;jumps++){
            min=Math.min(min,minMoves(jumps+i,moves,dp));
        }
        if(min==Integer.MAX_VALUE){
            return dp[i]=min;
        }
        return dp[i]=min+1;
    }
    public static int minmovesTabulation(int moves[]){
        int n=moves.length;
        int dp[]=new int[n];
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            int min=Integer.MAX_VALUE;
            for(int jumps=1;jumps<=moves[i] && jumps+i<n;jumps++){
             min=Math.min(min,dp[jumps+i]);
            }
            if(min==Integer.MAX_VALUE){
                dp[i]=min;
            }
            else{
                dp[i]=min+1;
            }
        }
        return dp[0];
    }

}