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
    int key=scn.nextInt();
    System.out.println(find(arr,key));
 }
 public static int find(int arr[],int key){
     for(int i=0;i<arr.length;i++){
        if(arr[i]==key){
            return i;
        }
    }
    return -1;
 }

}