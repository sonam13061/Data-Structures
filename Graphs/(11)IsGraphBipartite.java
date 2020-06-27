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
    public static class Pair {
        int vtx;
         int level;
        Pair(int vtx, int level) {
            this.vtx = vtx;
            this.level =level;
        }
    }
	//Some Facts:-
	//If a graph is acyclic then it will always be bipartite.
	//If any cycle in graph contains odd number elements,then it will not bipartite
	//if any cycle contains cycles with even number of elements then it will be bipartite
	//If we can color the graph using 2 colors,such that no adjacent vertices have same color,then it will be bipartite.
	//so,if we get 2 same vertices on same level that means it contains cycle with even elements.
	//And if we get 2 same vertices on different level,that means it have odd number of elements.
    public static boolean isbipartite(ArrayList < Edge > [] graph, int src,HashMap<Integer,Integer> visited) {

        Queue < Pair > q = new ArrayDeque < > ();
        //Initially add source and its path to the queue.
        q.add(new Pair(src,0));
        while (q.size() > 0) {
            Pair p = q.remove();
            if (visited.containsKey(p.vtx)) {
               if(visited.get(p.vtx)%2!=p.level%2){
                   return false;
               } 
               
            }
        
          
            else {
                visited.put(p.vtx,p.level);
                 
                //Add its unvisited neighbours.
                for (Edge e: graph[p.vtx]) {
                    if (!visited.containsKey(e.nbr)) {
                        q.add(new Pair(e.nbr, p.level+1));

                    }
                }
            }
            
        }

        return true;
    }
    public static boolean isbipartite(ArrayList < Edge > [] graph) {
      HashMap<Integer,Integer> visited = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visited.containsKey(i) && !isbipartite(graph, i, visited)) {
                
                    return false;
                
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList < Edge > [] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList < > ();
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
        System.out.println(isbipartite(graph));
        // write your code here
    }
}