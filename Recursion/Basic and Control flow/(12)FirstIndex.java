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
        int key=scn.nextInt();
        System.out.println(firstIndex(arr,0,key));
    }
    //   Sample Input
    //     6
    //     15
    //     11
    //     40
    //     4
    //     4
    //     9
    //     4
    //   Sample Output
    //     3
    public static int firstIndex(int[] arr, int idx, int x){
        if(idx==arr.length){
            return -1;
        }
        if(arr[idx]==x){
            return idx;
        }
        int ans=firstIndex(arr,idx+1,x);
        return ans;
    }

}