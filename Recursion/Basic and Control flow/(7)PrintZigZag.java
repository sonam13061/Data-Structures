import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        pzz(n);
    }
    // Input1 -> 1
    // Output1 -> 1 1 1

    // Input2 -> 2
    // Output2 -> 2 1 1 1 2 1 1 1 2

    // Input3 -> 3
    // Output3 -> 3 2 1 1 1 2 1 1 1 2 3 2 1 1 1 2 1 1 1 2 3
    public static void pzz(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        pzz(n-1);
        System.out.print(n+" ");
        pzz(n-1);
        System.out.print(n+" ");
        
    }

}