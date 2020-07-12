import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=scn.nextInt();
            }
        }
        //find transpose of 2-D array
        transpose(arr);
        //then reverse every row of matrix.
        for(int i=0;i<n;i++){
            int j=0,k=n-1;
            while(j<k){
                int temp=arr[i][j];
                arr[i][j]=arr[i][k];
                arr[i][k]=temp;
                j++;
                k--;
            }
        }
        display(arr);
    }
  public static void transpose(int[][] arr){
      for(int i=0;i<arr.length;i++){
          for(int j=0;j<arr[0].length;j++){
              if(i<j){
                  int temp=arr[i][j];
                  arr[i][j]=arr[j][i];
                  arr[j][i]=temp;
                  }
          }
      }
  }
    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}