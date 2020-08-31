import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
       Scanner scn=new Scanner(System.in);
       int n=scn.nextInt();
       int k=scn.nextInt();
       long dp[][]=new long[n+1][k+1];
       for(int i=1;i<=n;i++){
           for(int j=1;j<=k;j++){
               //if j=1,that means we have only one subset,so we will simply add element to that subset.
               //if i==j,that means for example we have 3 elements and 3 subsets,so we have only one way.
               if(j==1 || i==j){
                   dp[i][j]=1;
               }
               else{
                   //if j is greater than i,that means we have more subsets than elements for example
                   //we need to put 3 elements in 4 subsets,so this is not possible
    
                   if(j<i){
                       
                       //example if we have i==4 and j==3.
                       //we have two options either to place element in new subset or existing subset
                       //so if we place this ith element in new subset,
                       //then we need to place 3 elements in 2 subsets.
                       //if we place in existing 
                       //then we can place element in any out of j.
                   dp[i][j]=j*dp[i-1][j]+dp[i-1][j-1];
                   }
               }
           }
       }
       System.out.println(dp[n][k]);
   }
}