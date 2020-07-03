import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
          Stack<Character> st=new Stack<>();
          for(int i=0;i<str.length();i++){
              if(str.charAt(i)==')'){
                  if(st.peek()=='('){
                      System.out.println("true");
                      return;
                  }
                  while(st.peek()!='('){
                      st.pop();
                  }
                  st.pop(); //Pop ')' also
              }
              else{
                  
                  st.push(str.charAt(i));
              }
          }
         System.out.println("false");
          
    }

}