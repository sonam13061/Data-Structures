import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
      Scanner scn=new Scanner(System.in);
      int n=scn.nextInt();
      int k=scn.nextInt();
      System.out.println(paintfence(n,k));
      
    }
    public static int paintfence(int n,int k){
        int same=0;
        int diff=k;
        for(int i=1;i<n;i++){
            int newsame=diff;
            int newdiff=(same+diff)*(k-1);
            same=newsame;
            diff=newdiff;
        }
        return same+diff;
    }
}