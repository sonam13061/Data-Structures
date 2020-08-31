import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      
      PriorityQueue<Integer> pq=new PriorityQueue<>();
      //Selection process.
      //Time Complexity Average Case=O(nlogk) Worst Case=O(nlogn);
      //Space Complexity= O(logk)
      for(int i=0;i<k;i++){
          pq.add(arr[i]);
          //Add initial k values in priority queue.
      }
      for(int i=k;i<n;i++){
          // If any value greater than the smallest value in array found then remove the smallest element and
          //add current value in queue.
          if(arr[i]>pq.peek()){
              pq.remove();
              pq.add(arr[i]);
          }
      }
      //Now our priority queue will contain k largest numbers.
      while(pq.size()>0){
          System.out.println(pq.remove());
      }
      // write your code here
    }

}