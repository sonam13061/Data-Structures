import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    int arr[]=new int[n];
    for(int i=0;i<n;i++){
        arr[i]=scn.nextInt();
    }
    int pow=(int)Math.pow(2,n);
    for(int i=0;i<pow;i++){
        int temp=i;
        String ans="";
        int k=0;
        int idx=n-1;
        while(k<n){
            int rem=temp%2;
            temp=temp/2;
            if(rem==0){
                ans="-\t"+ans;
            }
            else{
                ans=arr[idx]+"\t"+ans;
            }
           k++;
           idx--;
        }
        System.out.println(ans);
    }
 }

}