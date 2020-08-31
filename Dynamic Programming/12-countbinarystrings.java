import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    System.out.println(countbinarystring(n));
 }
 public static int countbinarystring(int n){
     int dp[][]=new int[2][n+1];
     //cell meaning:- 0th row->number of strings with no alternate zeroes with length i,ending with 0
     //cell meaning:-1st row->number of strings with no alternate zeroes with length i,ending with 1
     dp[0][1]=1;
     dp[1][1]=1;
     for(int i=2;i<dp[0].length;i++){
         dp[0][i]=dp[1][i-1];
         dp[1][i]=dp[0][i-1]+dp[1][i-1];
     }
     return dp[0][n]+dp[1][n];
 }

}