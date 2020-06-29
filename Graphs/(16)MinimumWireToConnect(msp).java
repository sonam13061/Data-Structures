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
   static class Pair implements Comparable<Pair>{
       int vtx;
       int pvtx;
       int wt;
       Pair(int vtx,int pvtx,int wt){
           this.vtx=vtx;
           this.pvtx=pvtx;
           this.wt=wt;
       }
       public int compareTo(Pair p){
           return this.wt-p.wt;
       }
   }
   //A spanning tree is a subset of Graph G, which has all the vertices covered with minimum possible number of edges. 
   //Hence, a spanning tree does not have cycles and it cannot be disconnected.
   //By this definition, we can draw a conclusion that every connected and undirected Graph G has at least one spanning tree.
   //A disconnected graph does not have any spanning tree, as it cannot be spanned to all its vertices.
   //Removing one edge from the spanning tree will make the graph disconnected, i.e. the spanning tree is minimally connected.
//Adding one edge to the spanning tree will create a circuit or loop, i.e. the spanning tree is maximally acyclic.
  //Spanning tree has n-1 edges, where n is the number of nodes (vertices).
//From a complete graph, by removing maximum e - n + 1 edges, we can construct a spanning tree.
//   In a weighted graph, a minimum spanning tree is a spanning tree that has minimum weight than all other spanning trees of the same graph.
//   In real-world situations, this weight can be measured as distance, congestion, traffic load or any arbitrary value denoted to the edges.

//DIfference between Dijikstra And Prims.
//Dijkstra's Algorithm at every step greedily selects the next edge that is closest to some source vertex s. It does this until s is connected 
//to every other vertex in the graph. Clearly, the predecessor subgraph that is produced is a spanning tree of G, but is the sum of edge weights minimized?

//Prim's Algorithm, which is known to produce a minimum spanning tree, is highly similar to Dijkstra's Algorithm,
//but at each stage it greedily selects the next edge that is closest to any vertex currently in the working MST at that stage
 
//  Sample Input
// 7
// 8
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 40
// 3 4 2
// 4 5 3
// 5 6 3
// 4 6 8
// Sample Output
// [1-0@10]
// [2-1@10]
// [3-2@10]
// [4-3@2]
// [5-4@3]
// [6-5@3]
 public static void minimumspanning(ArrayList<Edge> graph[]){
       PriorityQueue<Pair> pq=new PriorityQueue<>();
       pq.add(new Pair(0,-1,0));
       boolean[] visited=new boolean[graph.length];
       while(pq.size()>0){
           Pair p=pq.remove();
           if(!visited[p.vtx]){
               if(p.pvtx!=-1){
                   System.out.println("["+p.vtx+"-"+p.pvtx+"@"+p.wt+"]");
               }
               visited[p.vtx]=true;
               for(Edge e:graph[p.vtx]){
                   if(!visited[e.nbr]){
                       pq.add(new Pair(e.nbr,p.vtx,e.wt));
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }
      minimumspanning(graph);

      // write your code here
   }

}