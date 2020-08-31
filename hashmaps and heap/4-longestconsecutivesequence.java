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
    HashMap<Integer,Boolean> mp=new HashMap<>();
    //Step 1
    //Mark all true.
    for(int i=0;i<n;i++){
        mp.put(arr[i],true);
    }
    
    //Step 2
    //mark false if the number can't be the starting point of sequence.
    //if its previous value exist then the number can't be the starting point of sequence.
    for(int key:mp.keySet()){
        if(mp.containsKey(key-1)){
            mp.put(key,false);
        }
    }
    //Step 3
    //find statring point and the length of maximum sequence.
    int sp=-1,ms=0;
    for(int key:mp.keySet()){
      if(mp.get(key)==true){
          int nextele=key+1;
          int count=1;
          while(mp.containsKey(nextele)){
              count++;
              nextele++;;
          }
          if(count>ms){
              ms=count;
              sp=key;
          }
      }
    }
    for(int i=0;i<ms;i++){
        System.out.println(sp+i);
    }
    
    
    
 }

}