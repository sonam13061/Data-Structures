import java.io.*;
import java.util.*;

public class Main {
  public static class Pair implements Comparable<Pair>{
      int np;
      int sp;
      public int compareTo(Pair other){
          if(this.np==other.np){
              return this.sp-other.sp;
          }
          return this.np-other.np;
      }
  }
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        Pair[] bridges=new Pair[n];
        for(int i=0;i<n;i++){
        Pair p=new Pair();
        p.np=scn.nextInt();
        p.sp=scn.nextInt();
        bridges[i]=p;
        }
        System.out.println( max_nonoverlapping_bridges(bridges));
        
    }
    public static int max_nonoverlapping_bridges(Pair[] p){
        Arrays.sort(p);
        int dp[]=new int[p.length];
        dp[0]=1;
        for(int i=1;i<dp.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(p[j].sp<p[i].sp)
                max=Math.max(dp[j],max);
            }
            dp[i]=max+1;
        }
        int max=0;
        for(int i=0;i<dp.length;i++){
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    

}