import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn=new Scanner(System.in);
    int n1=scn.nextInt();
    int arr1[]=new int[n1];
    for(int i=0;i<n1;i++){
       arr1[i]=scn.nextInt();
    }
    int n2=scn.nextInt();
    int arr2[]=new int[n2];
    for(int i=0;i<n2;i++){
        arr2[i]=scn.nextInt();
    }
    HashMap<Integer,Integer> mp=new HashMap<>();
    for(int i=0;i<n1;i++){
        int key=arr1[i];
        if(mp.containsKey(key)){
                int old=mp.get(key);
                mp.put(key,old+1);
            }
            else{
                mp.put(key,1);
            }
    }
     for(int i=0;i<n2;i++){
         int key=arr2[i];
         if(mp.containsKey(key)){
             System.out.println(key);
             mp.remove(key);
         }
         
     }
    
 }

}