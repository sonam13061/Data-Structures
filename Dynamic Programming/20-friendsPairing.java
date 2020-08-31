import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int dp[]=new int[n+1];
        dp[1]=1; //bcz if there is only one person,thn it can only stay single,can't form pair
        dp[2]=2; //if 2 person then two options,either pair up or stay single.
        for(int i=3;i<dp.length;i++){
            dp[i]=dp[i-1]+(i-1)*dp[i-2];
            //if stay single then problem will reduce to n-1
            //if pair up then problem will reduce to n-2,and it can form pair with n-1 friends.
        }
        System.out.println(dp[n]);
    }

}