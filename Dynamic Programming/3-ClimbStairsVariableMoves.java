import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int moves[]=new int[n];
        for(int i=0;i<moves.length;i++){
            moves[i]=scn.nextInt();
        }
       // System.out.println(clsvariablerec(moves,0));
      // System.out.println(clsvariablemem(moves,0,new int[n]));
      System.out.println(clsvariableTab(moves));
    }
    
    public static int clsvariablerec(int moves[],int i){
        if(i==moves.length-1){
            return 1;
        }
        int totalways=0;
        for(int jump=1;jump<=moves[i] && jump+i<moves.length;jump++){
            totalways+=clsvariablerec(moves,jump+i);
        }
        return totalways;
    }
    public static int clsvariablemem(int moves[],int i,int dp[]){
        if(i==moves.length-1){
            return dp[i]=1;
        }
        if(dp[i]!=0){
            return dp[i];
        }
        int totalways=0;
        for(int jump=1;jump<=moves[i] && jump+i<moves.length;jump++){
            totalways+=clsvariablemem(moves,jump+i,dp);
        }
        return dp[i]=totalways;
    }
    public static int clsvariableTab(int moves[]){
        int dp[]=new int[moves.length];
        for(int i=moves.length-1;i>=0;i--){
             if(i==moves.length-1){
               dp[i]=1;
               continue;
             }
        int totalways=0;
        for(int jump=1;jump<=moves[i] && jump+i<moves.length;jump++){
            totalways+=dp[jump+i];
        }
           dp[i]=totalways;
        }
        return dp[0];
    }

}