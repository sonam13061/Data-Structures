import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        printSS(str,"");
        System.out.println();
    }

   //Sample Input:- abc
   //Sample Output:-
    // c
    // b
    // bc
    // a
    // ac
    // ab
    // abc
    public static void printSS(String str,String ans) {
        if(str.length()==0){
            if(ans.length()>0){
            System.out.println(ans);
            }
            return;
        }
        
        char ch=str.charAt(0);
        str=str.substring(1);
        printSS(str,ans);
        printSS(str,ans+ch);
        
    }

}