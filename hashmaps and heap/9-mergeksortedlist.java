import java.io.*;
import java.util.*;

public class Main {
    public static class Pair implements Comparable<Pair>{
        int li;
        int di;
        int val;
        Pair(int li,int di,int val){
            this.li=li;
            this.di=di;
            this.val=val;
        }
        //compare on the basis of values,because we want priority on the basis of values in arraylist in our PQ
        public int compareTo(Pair o){
            return this.val-o.val;
        }
    }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();
      PriorityQueue<Pair> pq=new PriorityQueue<>();
      //Add elements which are present at 0th index in all the list in the priority queue along with their index and list index.
      
      for(int i=0;i<lists.size();i++){
          ArrayList<Integer> ithlist=lists.get(i);
          pq.add(new Pair(i,0,ithlist.get(0)));
      }
      while(pq.size()>0){
          //remove min  element from PQ and add it in our resultant arraylist.
          Pair minpair=pq.remove();
          rv.add(minpair.val);
          //increase the index of the list from which we removed the element recently.
          minpair.di++;
          // if this index is valid index,then add element present at this index in our priority queue.
          
          if(minpair.di<lists.get(minpair.li).size()){
              minpair.val=lists.get(minpair.li).get(minpair.di);
              pq.add(minpair);
          }
      }
      // write your code here

      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}