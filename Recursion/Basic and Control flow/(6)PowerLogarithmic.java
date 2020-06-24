import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int x=scn.nextInt();
        int n=scn.nextInt();
        System.out.println(power(x,n));
    }

    public static int power(int x, int n){
           if(n==0){
               return 1;
           }
            int pownb2=power(x,n/2);
            int pown=pownb2*pownb2;
            if(n%2==1){
                pown=x*pown;
            }
            return pown;
    }

}