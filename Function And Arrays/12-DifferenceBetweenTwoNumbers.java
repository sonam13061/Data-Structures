import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
     Scanner scn=new Scanner(System.in);
    int n1=scn.nextInt();
    int arr1[]=new int[n1];
    for(int i=0;i<n1;i++){
        arr1[i]=scn.nextInt();
    }
    int n2=scn.nextInt();
    int arr2[]=new int[n2];
    for(int i=0;i<n2;i++){
        arr2[i]=scn.nextInt();
    }
    int ans[]=new int[Math.max(n1,n2)];
    int i=n1-1,j=n2-1,k=ans.length-1;
    int borrow=0;
    while(i>=0 || j>=0){
           int dig1=i>=0?arr1[i]:0;
           int dig2=j>=0?arr2[j]:0;
           int diff=dig2-dig1-borrow;
           if(diff<0){
               diff=diff+10;
               borrow=1;
           }
           else{
               borrow=0;
           }
           ans[k]=diff;
           i--;
           j--;
           k--;
    }
    for(int idx=0;idx<ans.length;idx++){
        System.out.println(ans[idx]);
    }
 }

}