import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    prefixEvaluationAndConversions(exp);

    // code
 }
 public static void prefixEvaluationAndConversions(String exp){
      Stack<Integer> eval=new Stack<>();
     Stack<String> infix=new Stack<>();
     Stack<String> postfix=new Stack<>();
     for(int i=exp.length()-1;i>=0;i--){
         char ch=exp.charAt(i);
         if(ch>='0' && ch<='9'){
             eval.push(Integer.parseInt(ch+""));
             infix.push(ch+"");
             postfix.push(ch+"");
         }
         else{
             int op1=eval.pop();
             int op2=eval.pop();
             eval.push(solve(op1,op2,ch));
             String inop1=infix.pop();
             String inop2=infix.pop();
             infix.push("("+inop1+ch+inop2+")");
             String postop1=postfix.pop();
             String postop2=postfix.pop();
             postfix.push(postop1+postop2+ch);
         }
     }
     System.out.println(eval.peek());
     System.out.println(infix.peek());
     System.out.println(postfix.peek());
 }
 public static int solve(int op1,int op2,char ch){
     if(ch=='+'){
         return op1+op2;
     }
     else if(ch=='-'){
         return op1-op2;
     }
     else if(ch=='*'){
         return op1*op2;
     }
     else{
         return op1/op2;
     }
 }
}