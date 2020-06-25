import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        System.out.println(getStairPaths(n));
    }
        // Sample Input
        // 3
        // Sample Output
        // [111, 12, 21, 3]
        
    public static ArrayList<String> getStairPaths(int n) {
        if(n==0){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> result=new ArrayList<>();
        if(n-1>=0){
            ArrayList<String> list=getStairPaths(n-1);
            for(String val:list){
                result.add("1"+val);
            }
        
        }
         if(n-2>=0){
            ArrayList<String> list=getStairPaths(n-2);
            for(String val:list){
                result.add("2"+val);
            }
        
        }
         if(n-3>=0){
            ArrayList<String> list=getStairPaths(n-3);
            for(String val:list){
                result.add("3"+val);
            }
        
        }
        return result;
    }

}