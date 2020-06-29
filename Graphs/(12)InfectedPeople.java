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
   static class Pair{
       int vtx;
       int toi;
       Pair(int vtx,int toi){
           this.vtx=vtx;
           this.toi=toi;
       }
   }
  public static int infectedPeople(ArrayList<Edge> graph[],int t,int src){
      Queue<Pair> q=new ArrayDeque<>();
      boolean[] visited=new boolean[graph.length];
      //initially add src and initital time=1,means src person will get infected at 1 unit of time.
      q.add(new Pair(src,1));
      //count=0,means currently no person is infected.
      int count=0;
      while(q.size()>0){
          Pair p=q.remove();
          //If the current vertex is not visited then mark it visited,increase count,and add its children if its time of infection is less than the  total time.
          
          if(!visited[p.vtx]){
          visited[p.vtx]=true;
          count++;
          //Because if the time of infection will reach the total time,then it will not infect its neighbour.
          if(p.toi<t){
          for(Edge e:graph[p.vtx]){
              if(!visited[e.nbr]){
                  q.add(new Pair(e.nbr,p.toi+1));
              }
          }
          }
          
      }
    
  }
  //when queue will become empty then return total number of infected people
    return count;
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
      int t = Integer.parseInt(br.readLine());
      System.out.println(infectedPeople(graph,t,src));
      // write your code here
   }

}