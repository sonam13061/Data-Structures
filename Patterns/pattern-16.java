import java.util.*;
               
               public class Main{
               
               public static void main(String[] args) {
                   Scanner scn = new Scanner(System.in);
                   int n=scn.nextInt();
                   for(int i=1;i<=n;i++){
                       int num=1;
                       for(int j=1;j<=2*n-1;j++){
                            if(j<=i || j>=2*n-i){
                                System.out.print(num+"	");
                                if(j<i){
                                    num++;
                                }
                                else if(j==i){
                                    if(i==n){
                                        num--;
                                    }
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