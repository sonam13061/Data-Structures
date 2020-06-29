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
//   Sample Input
// 7
// 9
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 10
// 3 4 10
// 4 5 10
// 5 6 10
// 4 6 10
// 2 5 10
// 0
// Sample Output
// 0123456.
// 0123465.
// 0125643*
// 0346521*
    public static void HamiltonianPathAndCycle(ArrayList<Edge> graph[],int src,int osrc,HashSet<Integer> visited,String psf){
        if(visited.size()==graph.length-1){
            psf=psf+src;
            //At top we are checking the size of visited,if size of visited is graph.length-1,then it is either hamiltoninan path\
            //or cycle.To check if it is a cycle or not,we check the neighbours of our last vertex,if its one of neighbour is source vertrx
            //then it is a hamiltonian cycle.
            boolean iscycle=false;
            for(Edge e:graph[src]){
                if(e.nbr==osrc){
                    iscycle=true;
                    break;
                }
            }
            if(iscycle){
                System.out.println(psf+"*");
            }
            else{
                System.out.println(psf+".");
            }
        }
        visited.add(src);
        for(Edge e:graph[src]){
            if(!visited.contains(e.nbr)){
               HamiltonianPathAndCycle(graph,e.nbr,osrc,visited,psf+src+"");
            }
        }
        visited.remove(src);
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
      HamiltonianPathAndCycle(graph,src,src,new HashSet<Integer>(),"");
      // write all your codes here
   }


}