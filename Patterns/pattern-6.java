import java.util.*;
               
               public class Main{
               
               public static void main(String[] args) {
                   Scanner scn = new Scanner(System.in);
                   int n=scn.nextInt();
                   int mid=(n+1)/2;
                   int k=mid+1;
                  
                   for(int i=1;i<=n;i++){
                       System.out.print("*	");
                       if(i<=mid){
                           k--;
                       }
                       else{
                           k++;
                       }
                       //System.out.println(k);
                       for(int j=1;j<=n;j++){
                            if(j>=k && j<=n+1-k){
                                System.out.print("	");
                            }
                            else{
                                System.out.print("*	");
                            }
                       }
                          System.out.print("*	");
                       System.out.println();
                   }
                    // write ur code here
               
                }
               }