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
     public static boolean iscyclic( ArrayList<Edge>[] graph,int src,boolean[] visited ){
      
       Queue<Integer> q=new ArrayDeque<>();
       //Initially add source and its path to the queue.
       q.add(src);
       while(q.size()>0){
           //Remove everytime the 1st element of queue.
           int vtx=q.remove();
           //If the vertex is already visited,that means the graph is cyclic. 
           if( visited[vtx]==true){
               return true;
           }
           //else mark it as visied.
           visited[vtx]=true;
           //Add its unvisited neighbours.
             for(Edge e:graph[vtx]){
                   if(visited[e.nbr]==false)
                   q.add(e.nbr);a
                   
               
           }
       }
       return false;
   }
   public static boolean iscyclic(ArrayList<Edge>[] graph){
       boolean[] visited=new boolean[graph.length];
       //if graph is connected,that means this for loop will execute only once.
       //But if graph is not connected,that means this for loop will execute more than 1 times.
       //we are applying this loop to check all components of a non connected graph
       //because it is possible that 1st component is not cyclic but 2nd component is.
       for(int i=0;i<visited.length;i++){
              if(visited[i]==false){
                if(iscyclic(graph,i,visited)){
                     return true;
                 }
              }
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
       System.out.println(iscyclic(graph));
      // write your code here
   }
}