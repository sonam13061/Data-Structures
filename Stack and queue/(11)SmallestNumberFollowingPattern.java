import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    smallestNumberFollowingPattern(str);
    // code
 }
 public static void smallestNumberFollowingPattern(String str){
     Stack<Integer> st=new Stack<>();
     int count=1;
     String ans="";
     for(int i=0;i<=str.length();i++){
         st.push(count);
         count++;
         while(st.size()>0 && (i==str.length()|| str.charAt(i)=='i')){
             ans+=st.pop();
         }
     }
     System.out.println(ans);
 }
}