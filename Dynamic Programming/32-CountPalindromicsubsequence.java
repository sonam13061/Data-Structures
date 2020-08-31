import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        System.out.println(CountPalindromicSubsequence(str));
        

    }
    public static int CountPalindromicSubsequence(String str){
        int dp[][]=new int[str.length()][str.length()];
        for(int diag=0;diag<str.length();diag++){
            for(int i=0,j=diag;j<str.length();i++,j++){
                if(diag==0){
                    dp[i][j]=1;
                }
               
                else{
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j]=dp[i+1][j]+dp[i][j-1]+1;
                    }
                    else{
                        dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
                    }
                }
                    
            }
        }
        return dp[0][str.length()-1];
    }

}