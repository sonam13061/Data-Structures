import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
       System.out.println(LargestAreaHistogram(a));
    // code
 }
 public static int LargestAreaHistogram(int arr[]){
     Stack<Integer> leftHelper=new Stack<>();
     //Find  the index of next Minimum element in the left.
     int[] left=new int[arr.length];
     for(int i=0;i<arr.length;i++){
         while(leftHelper.size()>0 && arr[leftHelper.peek()]>=arr[i]){
             leftHelper.pop();
         }
         if(leftHelper.size()==0){
             left[i]=-1;
         }
         else{
             left[i]=leftHelper.peek();
             
         }
         leftHelper.push(i);
     }
      Stack<Integer> rightHelper=new Stack<>();
      //Find index of next minimum in right.
     int[] right=new int[arr.length];
     for(int i=arr.length-1;i>=0;i--){
         while(rightHelper.size()>0 && arr[rightHelper.peek()]>=arr[i]){
            rightHelper.pop();
         }
         if(rightHelper.size()==0){
             right[i]=arr.length;
         }
         else{
             right[i]=rightHelper.peek();
             
         }
        rightHelper.push(i);
     }
     //area covered by height arr[i] would be-----
     //its breadth will be  the index of next minimum in right minus index of next minimum in left-1.
     //Then we can calculate the maximum area out of all the areas..
     int max=Integer.MIN_VALUE;
     for(int i=0;i<arr.length;i++){
         int area=(right[i]-left[i]-1)*arr[i];
         max=Math.max(max,area);
     }
     return max;
 }
}