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
        int minprice=prices[0];
        int maxprofit=0;
        for(int i=1;i<prices.length;i++){
            //update the minprice everytime.
            if(prices[i]<minprice){
                minprice=prices[i];
            }
            //if currentprofit is greater than maxproft then update the maxprofit. 
            int currentprofit=prices[i]-minprice;
            if(currentprofit>maxprofit){
                maxprofit=currentprofit;
            }
        }
        System.out.println(maxprofit);
    }

}