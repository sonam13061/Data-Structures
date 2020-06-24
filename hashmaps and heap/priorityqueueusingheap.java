import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }
    public void swap(int i,int j){
        int ival=data.get(i);
        int jval=data.get(j);
        data.set(i,jval);
        data.set(j,ival);
    }
     public void upheapify(int ci){
         if(ci==0){
             return;
         }
         //calculate index of parents.
         int pi=(ci-1)/2;
         //call heapify until every root has higher priority than its children.
         if(data.get(pi)>data.get(ci)){
             swap(pi,ci);
             upheapify(pi);
         }
     }
    public void add(int val) {
      // write your code here
      //simply add value to last of arraylist.
      data.add(val);
      //Now call upheapify to last element of arrayList.
      //interchange elements to maintain heap order property(priority of root should be greater than its children).
      
      upheapify(data.size()-1);
    }
    public void downheapify(int pi){
        //find index of left and right child.
        int lci=2*pi+1;
        int rci=2*pi+2;
        //set minimum to parent;
        int minidx=pi;
        
        //Now calculate the minimum of parent,left child and right child.
        if(lci<data.size() && data.get(minidx)>data.get(lci)){
            minidx=lci;
        }
        if(rci<data.size() && data.get(minidx)>data.get(rci)){
            minidx=rci;
        }
        // if parent is already min element then do nothing
        //else swap the data of minimum element and parent and call downheapify to minidx.
        if(minidx!=pi){
            swap(minidx,pi);
            downheapify(minidx);
        }
    }
    public int remove() {
      // write your code here
      if(data.size()==0){
          System.out.println("Underflow");
          return -1;
      }
      // swap 1st index with last.
      swap(0,data.size()-1);
      //remove the last element.
      int eletoberemoved=data.remove(data.size()-1);
      //call down heapify to 1st element.
      downheapify(0);
     //return the removed element.
      return eletoberemoved;
      
      
    }

    public int peek() {
      // write your code here
      if(data.size()==0){
          System.out.println("Underflow");
          return -1;
      }
      //return 1st element because root will always be the minimum element.
      return data.get(0);
      
    }

    public int size() {
      // write your code here
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}