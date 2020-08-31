import java.util.*;
               
               public class Main{
               
               public static void main(String[] args) {
                   Scanner scn = new Scanner(System.in);
               
                    // write ur code here
                 int n=scn.nextInt();
                 int mid=(n+1)/2;
                 int k=mid+1;
                 for(int i=1;i<=n;i++){
                     if(i<=mid){
                         k--;
                     }
                     else{
                         k++;
                     }
                     for(int j=1;j<=n;j++){
                         
                         if(j==k || j==n-k+1){
                             System.out.print("*	");
                         }
                         else{
                              System.out.print("	");
                         }
                         
                     }
                      System.out.println();
                 }
                }
               }