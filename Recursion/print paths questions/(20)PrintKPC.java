import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        printKPC(str,"");
    }
// Sample Input
// 78
// Sample Output
// tv
// tw
// tx
// uv
// uw
// ux
    static String[] keys={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void printKPC(String str,String ans) {
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        char ch=str.charAt(0);
        int num=Integer.parseInt(ch+"");
        str=str.substring(1);
        for(int i=0;i<keys[num].length();i++){
            printKPC(str,ans+keys[num].charAt(i));
        }
    }

}