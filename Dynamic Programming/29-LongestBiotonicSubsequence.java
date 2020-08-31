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
        System.out.println(longestbiotonicSubsequence(arr));
    }
    public static int longestbiotonicSubsequence(int arr[]){
        //Find LIS from left(LIS ending at i) and right(LIS starting at i) both.
        //then return the value where left+right sum is maximum.
        //then subtract 1 also because ith index is included in both left and right. 
         int n=arr.length;
        int left[]=new int[n];
        for(int i=0;i<n;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(arr[j]<=arr[i]){
                max=Math.max(left[j],max);
                }
            }
            left[i]=max+1;
        }
        int right[]=new int[n];
        for(int i=n-1;i>=0;i--){
            int max=0;
            for(int j=i+1;j<n;j++){
                if(arr[j]<=arr[i]){
                    max=Math.max(right[j],max);
                }
            }
            right[i]=max+1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,left[i]+right[i]-1);
        }
        return ans;
    }

}