import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
          Scanner scn=new Scanner(System.in);
          String str=scn.nextLine();
          int[][] dp=new int[str.length()][str.length()];
          for(int diag=0;diag<str.length();diag++){
          for(int i=0,j=diag;j<str.length();i++,j++){
              if(diag==0){
                  dp[i][j]=1;
              }
              else if(diag==1){
                  if(str.charAt(i)==str.charAt(j)){
                      dp[i][j]=3;
                  }
                  else{
                      dp[i][j]=2;
                  }
              }
              else{
                    if(str.charAt(i)==str.charAt(j)){
                      dp[i][j]=dp[i][j-1]+dp[i-1][j]+1;
                  }
                  else{
                      dp[i][j]=dp[i][j-1]+dp[i+1][j]-dp[i+1][j-1];
                  }
              }
          }
          }
          
          System.out.println(dp[0][str.length()-1]);
    }

}