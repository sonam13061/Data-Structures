import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        System.out.println(getMazePaths(0,0,n-1,m-1));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    
    //Sample input 3 3
    //Sample Output
    //[hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]

    
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        
         if(sr==dr && sc==dc){
             ArrayList<String> base=new ArrayList<>();
             base.add("");
             return base;
         }
           ArrayList<String> result=new ArrayList<>();
        if(sc+1<=dc){
            ArrayList<String> list=getMazePaths(sr,sc+1,dr,dc);
            for(String val:list){
                result.add("h"+val);
            }
        }
        if(sr+1<=dr){
            ArrayList<String> list=getMazePaths(sr+1,sc,dr,dc);
            for(String val:list){
                result.add("v"+val);
            }
        }
        return result;
    }

}