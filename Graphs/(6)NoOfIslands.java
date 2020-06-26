import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }
        System.out.println(islands(arr));
        // write your code here
    }
    public static int islands(int area[][]) {
        boolean[][] visited = new boolean[area.length][area[0].length];
        int count = 0;
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[0].length; j++) {
                if (!visited[i][j] && area[i][j] == 0) {
                    count++;
                    gcc(area, i, j, visited);
                }
            }
        }
        return count;
    }
    public static void gcc(int[][] area, int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        if (y - 1 >= 0) {
            if (visited[x][y - 1] == false && area[x][y - 1] == 0) {
                gcc(area, x, y - 1, visited);
            }
        }
        if (x + 1 < area.length) {
            if (visited[x + 1][y] == false && area[x + 1][y] == 0) {
                gcc(area, x + 1, y, visited);
            }
        }
        if (y + 1 < area[0].length) {
            if (visited[x][y + 1] == false && area[x][y + 1] == 0) {
                gcc(area, x, y + 1, visited);
            }
        }
        if (x - 1 >= 0) {
            if (visited[x - 1][y] == false && area[x - 1][y] == 0) {
                gcc(area, x - 1, y, visited);
            }
        }
    }

}