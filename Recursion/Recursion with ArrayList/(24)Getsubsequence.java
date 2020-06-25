import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
          Scanner scn=new Scanner(System.in);
          String str=scn.nextLine();
          System.out.println(gss(str));
    }

    //Sample input:- abc
    //Sample output:-
    //[, c, b, bc, a, ac, ab, abc]
    public static ArrayList<String> gss(String str) {
         if(str.length()==0){
             ArrayList<String> base=new ArrayList<>();
             base.add("");
             return base;
         }
         char ch=str.charAt(0);
         str=str.substring(1);
         ArrayList<String> result=new ArrayList<>();
         ArrayList<String> list=gss(str);
         for(String val:list){
             result.add(val);
         }
         for(String val:list){
             result.add(ch+val);
         }
         return result;
    }

}