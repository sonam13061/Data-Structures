import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
         Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int prices[]=new int[n];
        for(int i=0;i<prices.length;i++){
            prices[i]=scn.nextInt();
        }
        int totalprofit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i-1]<prices[i]){
                //whenever you see profit,add it to our totalprofit
                totalprofit=totalprofit+prices[i]-prices[i-1];
            }
        }
        System.out.println(totalprofit);
    }

}