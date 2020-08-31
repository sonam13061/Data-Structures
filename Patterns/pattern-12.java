import java.util.*;
     
     public class Main{
     
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         int n=scn.nextInt();
         int a=0,b=1;
           for(int i=1;i<=n;i++){
               for(int j=1;j<=i;j++){
                //   if(i==1){
                //       System.out.print(a+"	");
                //   }
                //   else if(i==2){
                //          System.out.print(b+"	");
                //          a=b;
                //   }
                //   else{
                       //int c=a+b;
                       System.out.print(a+"	");
                       int c=a+b;
                       a=b;
                       b=c;
                   
                   
                   
                }
           System.out.println();
           }
          // write ur code here
     
      }
     }