import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
     Scanner scn=new Scanner(System.in);
     String str=scn.nextLine();
     System.out.println(countabcSubsequence(str));
    }
    public static int countabcSubsequence(String str){
        int a=0;
        int ab=0;
        int abc=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a'){
                a=1+2*a;
            }
            else if(str.charAt(i)=='b'){
                ab=a+2*ab;
            }
            else{
                abc=ab+2*abc;
            }
        }
        return abc;
    }
}