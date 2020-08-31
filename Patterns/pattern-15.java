import java.util.*;
               
               public class Main{
               
               public static void main(String[] args) {
                   Scanner scn = new Scanner(System.in);
                   int n=scn.nextInt();
                   int mid=(n+1)/2;
                   int k=mid+1;
                   int num;
                   for(int i=1;i<=n;i++){
                       if(i<=mid){
                           k--;
                           num=i;
                       }
                       else{
                           k++;
                           num=n+1-i;
                       }
                       //System.out.println(k);
                       for(int j=1;j<=n;j++){
                            if(j>=k && j<=n+1-k){
                               
                                System.out.print(num+"	");
                                 if(j<mid){
                                    num++;
                                }
                                else{
                                    num--;
                                }
                                
                            }
                            else{
                                System.out.print("	");
                            }
                       }
                       
                       System.out.println();
                   }
                    // write ur code here
               
                }
               }