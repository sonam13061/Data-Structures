import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int maze[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                maze[i][j]=scn.nextInt();
            }
        }
        floodfill(maze,0,0,"",new boolean[n][m]);
    }

    public static void floodfill(int[][] maze, int row, int col, String psf, boolean[][] visited){
        if(row<0 || col<0 || row==maze.length|| col==maze[0].length|| visited[row][col]==true || maze[row][col]==1){
            return;
        }
        if(row==maze.length-1 && col==maze[0].length-1){
            System.out.println(psf);
            return;
        }
        visited[row][col]=true;
        floodfill(maze,row-1,col,psf+"t",visited);
        floodfill(maze,row,col-1,psf+"l",visited);
        floodfill(maze,row+1,col,psf+"d",visited);
        floodfill(maze,row,col+1,psf+"r",visited);
        visited[row][col]=false;
    }
}