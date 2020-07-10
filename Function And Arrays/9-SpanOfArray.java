import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    int arr[]=new int[n];
    for(int i=0;i<n;i++){
        arr[i]=scn.nextInt();
    }
    System.out.println(span(arr));
    
 }
 public static int span(int arr[]){
     int max=Integer.MIN_VALUE;
     int min=Integer.MAX_VALUE;
     for(int i=0;i<arr.length;i++){
         max=Math.max(max,arr[i]);
         min=Math.min(min,arr[i]);
     }
     return max-min;
 }

}