import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner scn=new Scanner(System.in);
       String exp=scn.nextLine();
       System.out.println(isbalanced(exp));
    }
    public static boolean isbalanced(String exp){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(ch=='['||ch=='{' || ch=='('){
                st.push(ch);
            }
            else if(ch==']'){
                if(st.size()==0 ||st.peek()!='['){
                    return false;
                }
                else{
                 st.pop();
                }
            }
            else if(ch=='}'){
                if(st.size()==0 ||st.peek()!='{'){
                    return false;
                }
                else{
                 st.pop();
                }
            }
            else if(ch==')'){
               if(st.size()==0 ||st.peek()!='('){
                    return false;
                }
                else{
                 st.pop();
                }
            }
        }
        // if(st.size()==0){
        // return true;
        // }
        // else{
        //     return false;
        // }
         return st.size()==0;
    }

}