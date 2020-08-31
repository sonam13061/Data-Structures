import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }
   public static class Pair implements Comparable<Pair>{
       int st;
       int et;
       Pair(int st,int et){
           this.st=st;
           this.et=et;
       }
       public int compareTo(Pair other){
           return this.st-other.st;
       }
   }
    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Pair intervals[]=new Pair[arr.length];
        for(int i=0;i<arr.length;i++){
            Pair p=new Pair(arr[i][0],arr[i][1]);
            intervals[i]=p;
        }
        Arrays.sort(intervals);
        Stack<Pair> st=new Stack<>();
        st.push(intervals[0]);
        for(int i=1;i<arr.length;i++){
            if(st.peek().et>=intervals[i].st){
                st.peek().et=Math.max(intervals[i].et,st.peek().et);
            }
            else{
                st.push(intervals[i]);
            }
        }
        Pair ans[]=new Pair[st.size()];
        int i=0;
        while(st.size()>0){
            ans[i++]=st.pop();
            
        }
        for(int idx=ans.length-1;idx>=0;idx--){
            Pair p=ans[idx];
            System.out.println(p.st+" "+p.et);
        }
    }

}