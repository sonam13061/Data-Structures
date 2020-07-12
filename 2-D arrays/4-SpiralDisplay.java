import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int r=scn.nextInt();
        int c=scn.nextInt();
        int arr[][]=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[i][j]=scn.nextInt();
            }
        }
        int count=0;
        int strtrow=0,strtcol=0,endrow=r-1,endcol=c-1;
        while(count<r*c){
            for(int i=strtrow;i<=endrow && count<r*c;i++){
                System.out.println(arr[i][strtcol]);
                count++;
             }
            strtcol++;
            for(int i=strtcol;i<=endcol && count<r*c;i++){
                System.out.println(arr[endrow][i]);
                count++;
            }
            endrow--;
             for(int i=endrow;i>=strtrow && count<r*c;i--){
                System.out.println(arr[i][endcol]);
                count++;
            }
            endcol--;
            for(int i=endcol;i>=strtcol && count<r*c;i--){
                System.out.println(arr[strtrow][i]);
                count++;
            }
            strtrow++;
           
           
            
           
        }
        
    }

}