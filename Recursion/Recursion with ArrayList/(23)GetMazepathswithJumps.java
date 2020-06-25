import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
               Scanner scn=new Scanner(System.in);
               int r=scn.nextInt();
               int c=scn.nextInt();
               System.out.println(getMazePaths(0,0,r-1,c-1));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr==dr && sc==dc){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
         ArrayList<String> ans=new ArrayList<>();
        
         for(int i=1;i+sc<=dc;i++){
             ArrayList<String> vertical=getMazePaths(sr,sc+i,dr,dc);
             for(String val:vertical){
                 ans.add("h"+i+val);
             }
             
         }
          for(int i=1;i+sr<=dr;i++){
             ArrayList<String> horizontal=getMazePaths(sr+i,sc,dr,dc);
             for(String val:horizontal){
                 ans.add("v"+i+val);
             }
         }
         for(int i=1;i+sr<=dr && i+sc<=dc;i++){
             ArrayList<String> diagonal=getMazePaths(sr+i,sc+i,dr,dc);
             for(String val:diagonal){
                 ans.add("d"+i+val);
             }
         }
         return ans;
    }

}