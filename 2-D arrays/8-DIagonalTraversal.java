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
        for(int col=0;col<n;col++){
             int temp=col;
            for(int row=0;row<n && temp<n;row++){
                System.out.println(arr[row][temp]);
                temp++;
            }
        }
    }

}