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
   public static class Pair{
          int src;
          String path;
          Pair(int src,String path){
              this.src=src;
              this.path=path;
          }
      }
   public static void BFS( ArrayList<Edge>[] graph,int src ){
       boolean[] visited=new boolean[graph.length];
       Queue<Pair> q=new ArrayDeque<>();
       //Initially add source and its path to the queue.
       q.add(new Pair(src,src+""));
       while(q.size()>0){
           //Remove  1st element of queue.
           Pair p=q.remove();
           //if it has already visited ,do nothing else do the following work
           if(visited[p.src]==false){
               //Print its path
           System.out.println(p.src+"@"+p.path);
           //mark it true.
           visited[p.src]=true;
           //Add its unvisited neighbours.
           for(Edge e:graph[p.src]){
               if(visited[e.nbr]==false){
                   q.add(new Pair(e.nbr,p.path+e.nbr+""));
                   
               }
           }
           }
       }
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      BFS(graph,src);

      // write your code here  
   }
}