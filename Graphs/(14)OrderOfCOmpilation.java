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
    // Sample Input
    // 7
    // 7
    // 0 1
    // 1 2
    // 2 3
    // 0 3
    // 4 5
    // 5 6
    // 4 6
    // Sample Output
    // 4
    // 5
    // 6
    // 0
    // 1
    // 2
    // 3
   public static void OFC(ArrayList<Edge> graph[],int src,boolean[]  visited,Stack<Integer> st){
       
        visited[src]=true;
        for(Edge e:graph[src]){
            if(!visited[e.nbr]){
                OFC(graph,e.nbr,visited,st);
            }
        }
        //We are pushing the src in the post area,so the node which will be the on the top would be executed first.
        st.push(src);
   }
   public static void OrderOfcompilation(ArrayList<Edge> graph[]){
       boolean visited[]=new boolean[graph.length];
       Stack<Integer> st=new Stack<>();
       for(int i=0;i<graph.length;i++){
           if(!visited[i]){
               OFC(graph,i,visited,st);
           }
       }
       while(st.size()>0){
           System.out.println(st.pop());
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
      }
      OrderOfcompilation(graph);
      // write your code here
   }

}