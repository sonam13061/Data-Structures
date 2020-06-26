import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
           Scanner scn=new Scanner(System.in);
           String str=scn.nextLine();
           System.out.println(getKPC(str));
    }
    static String[] keys={ ".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> getKPC(String str) {
        if(str.length()==0){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        //Find first character
        char ch=str.charAt(0);
        //find remaining string.
        str=str.substring(1);
        //find character in integer.
         int num=Integer.parseInt(ch+"");
         ArrayList<String> result=new ArrayList<>();
         //Make call to the remaining string.
            ArrayList<String> list=getKPC(str);
            //Iterate over the numth index of keys array ans concatenate its character one by one in all the elemennts of return arraylist.
            
         for(int i=0;i<keys[num].length();i++){
             char k=keys[num].charAt(i);
          
             for(String val:list){
                 result.add(k+val);
             }
         }
         return result;
         
       
    }

}