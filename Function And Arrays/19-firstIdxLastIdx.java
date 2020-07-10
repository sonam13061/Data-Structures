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
    int k=0;
    int first=-1,last=-1;
    for(int i=0;i<arr.length;i++){
        if(arr[i]==key){
            if(k==0){
                first=i;
            }
            last=i;
            k++;
        }
    }
    System.out.println(first);
    System.out.println(last);
 }

}