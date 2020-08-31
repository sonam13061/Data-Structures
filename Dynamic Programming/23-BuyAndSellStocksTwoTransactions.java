import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
      int ans=buyandselltwotransactions(arr);
        System.out.println(ans);
    }
    public static int buyandselltwotransactions(int arr[]){
        int n=arr.length;
       int left[]=new int[n];
        //left indicates,that if we are present at ith day,then atmost profit which we can earn
        //by doing a transaction from 0 to i day.
        int minprice=arr[0];
        left[0]=0;
        for(int i=1;i<n;i++){
            if(arr[i]<minprice){
                minprice=arr[i];
            }
            int crntprofit=arr[i]-minprice;
            if(crntprofit>left[i-1]){
                left[i]=crntprofit;
            }
            else{
                left[i]=left[i-1];
            }
        }
        int right[]=new int[n];
         //left indicates,that if we are present at ith day,then atmost profit which we can earn
        //by doing a transaction from i to nth day.
        right[n-1]=0;
        int maxprice=arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(arr[i]>maxprice){
                maxprice=arr[i];
            }
            int currprofit=maxprice-arr[i];
            if(currprofit>right[i+1]){
                right[i]=currprofit;
            }
            else{
                right[i]=right[i+1];
            }
        }
        //At last we will check the point where we will get maximum profit by doing 2 transactions.
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
        ans=Math.max(ans,left[i]+right[i]);
        }
        return ans;
    }

}