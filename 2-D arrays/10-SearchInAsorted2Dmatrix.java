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
        int key=scn.nextInt();
        int j=n-1,i=0;
        while(i>=0 && j>=0 && i<n && j<n){
            if(arr[i][j]<key){
                i++;
            }
            else if(arr[i][j]>key){
                j--;
            }
            else{
                System.out.println(i);
                System.out.println(j);
                return;
            }
        }
        System.out.println("Not Found");
    }

}