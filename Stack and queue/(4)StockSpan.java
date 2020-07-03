import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] span = solve(a);
    display(span);
 }

 public static int[] solve(int[] arr){
   // solve
   int ans[]=new int[arr.length];
   Stack<Integer> st=new Stack<>();
   for(int i=0;i<arr.length;i++){
       //Remove elements until value of index stored at top is less than current value.
       while(st.size()>0 && arr[st.peek()]<arr[i]){
           st.pop();
       }
       //If size=0 that means current value is highest in its left
       if(st.size()==0){
           ans[i]=i+1;
       }
       //Else the stock span would be the difference between indices of current element and the 
       //next element in in its left.because all the values between these two indices would be smaller than 
       //current element.
       else{
           ans[i]=i-st.peek();
       }
       //At last push current index.
       st.push(i);
   }
   return ans;
 }

}