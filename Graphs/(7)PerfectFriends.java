import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   //We can also change the return type of gcc to void but in that case we need to pass an empty
   //arraylist as parameter.
   public static ArrayList<Integer> gcc(ArrayList<Edge> graph[],int src,boolean[] visited){
       visited[src]=true;
       ArrayList<Integer> result=new ArrayList<>();
      result.add(src);
       for(Edge e:graph[src]){
          if(visited[e.nbr]==false){
             ArrayList<Integer>list=gcc(graph,e.nbr,visited);
             for(Integer val:list){
                 result.add(val);
             }
          }
       }
        
       return result;
   }
   public static int perfectfriends(ArrayList<Edge> graph[]){
      boolean visited[]=new boolean[graph.length];
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      for(int i=0;i<graph.length;i++){
          if(visited[i]==false){
              ArrayList<Integer> list=gcc(graph,i,visited);
              comps.add(list);
          }
      }
      int ans=0;
      for(int i=0;i<comps.size();i++){
          int pro=comps.get(i).size();
          for(int j=i+1;j<comps.size();j++){
              ans=ans+pro*comps.get(j).size();
          }
      }
      return ans;
   }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[n];
      for (int i = 0; i <n; i++) {
         graph[i] = new ArrayList<>();
      }
   
      int k = Integer.parseInt(br.readLine());
      for (int i = 0; i <k; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      
     
      // write your code here

      System.out.println(perfectfriends(graph));
   }
}