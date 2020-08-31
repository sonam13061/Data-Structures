import java.io.*;
import java.util.*;

public class Main {
    public static class Pair implements Comparable<Pair>{
        int ht;
        int wdth;
        public int compareTo(Pair other){
            if(this.ht==other.ht){
                return this.wdth-other.wdth; 
            }
            return this.ht-other.ht;
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        Pair[] envelopes=new Pair[n];
        for(int i=0;i<n;i++){
            Pair p =new Pair();
            p.ht=scn.nextInt();
            p.wdth=scn.nextInt();
            envelopes[i]=p;
        }
        System.out.println(russiandollEnvelopes(envelopes));
    }
    public static int russiandollEnvelopes(Pair[] p){
        Arrays.sort(p);
        int dp[]=new int[p.length];
        dp[0]=1;
        for(int i=1;i<p.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(p[j].wdth<p[i].wdth){
                    max=Math.max(max,dp[j]);
                }
            }
            dp[i]=max+1;
        }
        int max=0;
        for(int i=0;i<p.length;i++){
            max=Math.max(dp[i],max);
        }
        return max;
    }

}