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
    int d=scn.nextInt();
    int ceil=-1;
    int floor=-1;
    for(int i=0;i<n;i++){
        if(arr[i]<=d){
            floor=arr[i];
        }
        if(arr[i]>=d){
            ceil=arr[i];
            break;
        }
        
    }
    System.out.println(ceil);
    System.out.println(floor);
 }

}