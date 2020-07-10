import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    int arr[]=new int[n];
    int max=Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
        arr[i]=scn.nextInt();
        max=Math.max(arr[i],max);
    }
    for(int i=0;i<max;i++){
        for(int j=0;j<arr.length;j++){
            if(i>=max-arr[j]){
                System.out.print("*\t");
            }
            else{
                System.out.print("\t");
            }
        }
        System.out.println();
    }
 }

}