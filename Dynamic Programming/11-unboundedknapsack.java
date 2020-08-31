	import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
           Scanner scn=new Scanner(System.in);
           int n=scn.nextInt();
           int values[]=new int[n];
           for(int i=0;i<n;i++){
               values[i]=scn.nextInt();
           }
           int weights[]=new int[n];
           for(int i=0;i<n;i++){
               weights[i]=scn.nextInt();
           }
           int cap=scn.nextInt();
           System.out.println(unboundedknapsack(values,weights,cap));
	    }
	    public static int unboundedknapsack(int[]values,int weights[],int cap){
	        int dp[]=new int[cap+1];
	        for(int i=0;i<weights.length;i++){
	            for(int j=0;j<dp.length;j++){
	                if(j-weights[i]>=0)
	                dp[j]=Math.max(dp[j],values[i]+dp[j-weights[i]]);
	            }
	        }
	        return dp[cap];
	    }
	}