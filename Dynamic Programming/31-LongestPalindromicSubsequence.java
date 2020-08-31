import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner scn=new Scanner(System.in);
       String str=scn.nextLine();
       System.out.println(longestpalindromicMethod2(str));
    }
    public static int LongestPalindromicmethod1(String str){
        String str2="";
        for(int i=str.length()-1;i>=0;i--){
            str2=str2+str.charAt(i);
        }
        return LCS(str,str2);
    }
    public static int longestpalindromicMethod2(String str){
        int dp[][]=new int[str.length()][str.length()];
        int n=str.length();
        for(int diag=0;diag<n;diag++){
            for(int i=0,j=diag;j<n;i++,j++){
                if(diag==0){
                    dp[i][j]=1;
                }
                else{
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j]=2+dp[i+1][j-1];
                    }
                    else{
                        dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[0][str.length()-1];
    }
     public static int LCS(String str1,String str2){
     int dp[][]=new int[str1.length()+1][str2.length()+1];
       for(int i=1;i<dp.length;i++){
           for(int j=1;j<dp[0].length;j++){
               if(str1.charAt(i-1)==str2.charAt(j-1)){
                   dp[i][j]=1+dp[i-1][j-1];
               }
               else{
                   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
               }
           }
       }
       return dp[str1.length()][str2.length()];
    }

}