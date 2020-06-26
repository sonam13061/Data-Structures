import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
     Scanner scn=new Scanner(System.in);
     int n=scn.nextInt();
     printNQueens(new int[n][n],"",0);
     System.out.println();
     
    }
    public static boolean issafe(int[][] chess,int row,int col){
        //Check Top
        for(int i=0;i<row;i++){
            if(chess[i][col]==1){
                return false;
            }
        }
        //CHeck Left diaogonal
        for(int i=row-1,j=col-1;i>=0 &&j>=0;i--,j-- ){
            if(chess[i][j]==1){
                return false;
            }
        }
        //Check Right diogonal
        for(int i=row-1,j=col+1;i>=0 && j<chess.length;i--,j++){
            if(chess[i][j]==1){
                return false;
            }
        }
        //No need to check on left,right,bottom and both bottom diagonals
        //Becuse before making call to 2nd coloumn we are putting back 0 to the 1st col
        //And we are filling the matrix from top to bottom,so bottom will not be filled before top
        //So no need check bottom and bottom diagonals
        //And we are filling left coloumn before the right,so we dont need to check the right part also.
        return true;
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        if(row==chess.length){
            System.out.println(qsf+".");
            return;
        }
        //Make call to every coloumn to get all the possible configurations.
        for(int j=0;j<chess[0].length;j++){
            if(issafe(chess,row,j)){
                chess[row][j]=1;
                //Placing 1 means place the queen on that index.
                printNQueens(chess,qsf+row+"-"+j+", ",row+1);
                //unplacing the queen.
                chess[row][j]=0;
            }
        }
    }
}