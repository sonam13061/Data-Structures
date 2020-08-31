import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner scn=new Scanner(System.in);
       String str1=scn.nextLine();
       String str2=scn.nextLine();
      
       System.out.println(LCS(str1,str2));;
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