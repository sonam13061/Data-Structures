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
       int wsf;
       String psf;
       Pair(int vtx,int wsf,String psf){
           this.vtx=vtx;
           this.wsf=wsf;
           this.psf=psf;
       }
       public int compareTo(Pair p){
           return this.wsf-p.wsf;
       }
       
   }
//   Sample Input
// 7
// 9
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 40
// 3 4 2
// 4 5 3
// 5 6 3
// 4 6 8
// 2 5 5
// 0
// Sample Output
// 0 via 0 @ 0
// 1 via 01 @ 10
// 2 via 012 @ 20
// 5 via 0125 @ 25
// 4 via 01254 @ 28
// 6 via 01256 @ 28
// 3 via 012543 @ 30
   //This algorithm will always work,because from the priority Queue,we are removing the smallest weighted  path element,so,this would be the smallest weight possible path to reach that node from source
   //Because other nodes have already greater weights than the current node,and we can reach up our node  by the current path or the nodes which would be left in our priority queue
   //so this would impossible to give remaining nodes to reach up node with less weight than our current node becuase their weights are already greater than our current node path,and to reach 
   //up the node,we need to add more weights. 
   public static void dijikstra(ArrayList<Edge> graph[],int src){
       PriorityQueue<Pair> pq=new PriorityQueue<>();
       pq.add(new Pair(src,0,src+""));
       boolean[] visited=new boolean[graph.length];
       while(pq.size()>0){
           Pair p=pq.remove();
           if(!visited[p.vtx]){
               visited[p.vtx]=true;
               System.out.println(p.vtx+" via "+p.psf+" @ "+p.wsf);
               for(Edge e:graph[p.vtx]){
                   if(!visited[e.nbr]){
                   pq.add(new Pair(e.nbr,p.wsf+e.wt,p.psf+e.nbr+""));
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

      int src = Integer.parseInt(br.readLine());
      // write your code here
       dijikstra(graph,src);
   }
}