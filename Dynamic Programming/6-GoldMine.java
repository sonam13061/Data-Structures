import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int gold[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                gold[i][j] = scn.nextInt();
            }
        }
        // int max=Integer.MIN_VALUE;
        // int dp[][]=new int[n][m];
        // for(int i=0;i<n;i++){
        //     int cg=Goldmine(gold,i,0,dp);
        //     max=Math.max(max,cg);
        // }
        // System.out.println(max);
        System.out.println(GoldMineTab(gold));

    }
    public static int Goldmine(int[][] gold, int i, int j, int dp[][]) {
        if (j == gold[0].length - 1) {
            return dp[i][j] = gold[i][j];
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int right = Goldmine(gold, i, j + 1, dp);
        int topright = (i - 1) >= 0 ? Goldmine(gold, i - 1, j + 1, dp) :0;
        int bottomright = ((i + 1) < gold.length) ? Goldmine(gold, i + 1, j + 1, dp) :0;
        return dp[i][j] = Math.max(right, Math.max(topright, bottomright)) + gold[i][j];

    }
    public static int GoldMineTab(int[][] gold) {
        int n = gold.length;
        int m = gold[0].length;
        int dp[][] = new int[n][m];
        for (int j = m - 1; j >= 0; j--) {
            for (int i = n - 1; i >= 0; i--) {
                if (j == gold[0].length - 1) {
                    dp[i][j] = gold[i][j];
                    continue;
                }
                int right = dp[i][j + 1];
                int topright = (i - 1) >= 0 ? dp[i - 1][j + 1] :0;
                int bottomright = ((i + 1) < gold.length) ? dp[i + 1][j + 1] :0;
                dp[i][j] = Math.max(right, Math.max(topright, bottomright)) + gold[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }

}