import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
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
   public static ArrayList<ArrayList<Integer>> getAllconectedcomponents(ArrayList<Edge> graph[]){
      boolean visited[]=new boolean[graph.length];
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      for(int i=0;i<graph.length;i++){
          if(visited[i]==false){
              ArrayList<Integer> list=gcc(graph,i,visited);
              comps.add(list);
          }
      }
      return comps;
   }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      
     ArrayList<ArrayList<Integer>> comps=getAllconectedcomponents(graph);
      // write your code here

      System.out.println(comps);
   }
}