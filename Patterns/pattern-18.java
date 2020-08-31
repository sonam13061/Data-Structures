import java.util.*;
       
       public class Main{
       
       public static void main(String[] args) {
           Scanner scn = new Scanner(System.in);
               int n=scn.nextInt();
               int mid=(n+1)/2;
               int k=mid;
               for(int i=1;i<=n;i++){
                   for(int j=1;j<=n;j++){
                       if(i==mid){
                           System.out.print("*	");
                       }
                       else{
                            if(j>=mid && j<=k){
                               System.out.print("*	");
                            
                           }
                           else{
                               System.out.print("	");
                           }
                       }
                   }
                   if(i<mid-1){
                       k++;
                   }
                   if(i>mid){
                       k--;
                   }
                   System.out.println();
               }
            // write ur code here
       
        }
       }