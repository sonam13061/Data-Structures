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
        for(int i=0;i<n;i++){
            int min=Integer.MAX_VALUE;
            int minidx=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(arr[i][j]<min){
                    min=arr[i][j];
                    minidx=j;
                }
            }
            boolean flag=true;
            for(int k=0;k<n;k++){
                if(arr[k][minidx]>min){
                    flag=false;
                }
            }
            if(flag==true){
                System.out.println(min);
                return;
            }
        }
        System.out.println("Invalid input");
    }

}