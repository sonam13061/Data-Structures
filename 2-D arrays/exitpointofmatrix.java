import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int A[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = scn.nextInt();
            }
        }
        int dir=0;
        int row=0,col=0;
        while(true){
            dir=(dir+A[row][col])%4;
            if(dir==0){
                col++;
            }
            if(dir==1){
                row++;
            }
            if(dir==2){
                col--;
            }
            if(dir==3){
                row--;
            }
            if(row==-1){
                row++;
                break;
            }
            else if(col==-1){
                col++;
                break;
            }
            else if(row==n){
                row--;
                break;
            }
            else if(col==m){
                col--;
                break;
            }
        }
        System.out.println(row);
        System.out.println(col);

    }

}