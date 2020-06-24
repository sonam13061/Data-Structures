import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        printDecreasing(n);
    }
//Faith:- if I will print myself,then all numbers smaller than me will automatically get printed.
    public static void printDecreasing(int n){
        if(n==0){
            return;
        }
		
        System.out.println(n);
        printDecreasing(n-1);
        
    }

}