import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n=scn.nextInt();
    int mid=(n+1)/2;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(i==1){
                if(j<=mid || j==n){
                      System.out.print("*	");
                }
                else{
                    System.out.print("	");
                }
            }
            else if(i<mid){
                if(j==mid || j==n){
                     System.out.print("*	");
                }
                else{
                    System.out.print("	");
                    
                }
                
            }
            else if(i==mid){
                System.out.print("*	");
            }
            else if(i==n){
                if(j==1 ||j>=mid){
                     System.out.print("*	");
                }
                else{
                    System.out.print("	");
                }
            }
            else{
                 if(j==mid || j==1){
                     System.out.print("*	");
                }
                else{
                    System.out.print("	");
                    
                }
            }
        }
        System.out.println();
    }
     // write ur code here

 }
}