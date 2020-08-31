import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
     Scanner scn=new Scanner(System.in);
     String str=scn.nextLine();
     System.out.println( countPaindromicSubstring(str));
    }
    public static int countPaindromicSubstring(String str){
        boolean dp[][]=new boolean[str.length()][str.length()];
        int count=0;
        for(int diag=0;diag<str.length();diag++){
            for(int i=0,j=diag;j<str.length();i++,j++){
                if(diag==0){
                    dp[i][j]=true;
                }
                else if(diag==1){
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j]=true;
                    }
                }
                else{
                    if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1]==true){
                        dp[i][j]=true;
                    }
                }
                if(dp[i][j]==true){
                    count++;
                }
            }
        }
        return count;
    }

}