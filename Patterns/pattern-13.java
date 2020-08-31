import java.util.*;
     
     public class Main{
     
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         int n=scn.nextInt();
       
         for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                 if(j<=i){
                     System.out.print(ncr(i,j)+"	");
                 }
                 else{
                     System.out.print("	");
                 }
             }
             System.out.println();
         }
          // write ur code here
     
      }
      public static int factorial(int n){
          int fact=1;
          for(int i=1;i<=n;i++){
              fact=fact*i;
          }
          return fact;
      }
      public static int ncr(int n,int r){
          int nfact=factorial(n);
          int rfact=factorial(r);
          int nmrfact=factorial(n-r);
          return (nfact/(rfact*nmrfact));
      }
     }