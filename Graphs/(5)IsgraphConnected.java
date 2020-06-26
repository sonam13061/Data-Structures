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
   public static boolean isconnected(ArrayList<Edge> graph[]){
       ArrayList<ArrayList<Integer>> comp=new ArrayList<>();
        boolean visited[]=new boolean[graph.length];
       for(int i=0;i<graph.length;i++){
           if(visited[i]==false){
           ArrayList<Integer> list=gcc(graph,i,visited);
              comp.add(list);
           }
       }
       if(comp.size()==1){
           return true;
       }
        return false;
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
       System.out.println(isconnected(graph));
      // write your code here
   }
}