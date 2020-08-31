import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    postfixEvaluationAndConversions(exp);

    // code
 }
 public static void postfixEvaluationAndConversions(String exp){
     Stack<Integer> eval=new Stack<>();
     Stack<String> infix=new Stack<>();
     Stack<String> prefix=new Stack<>();
     for(int i=0;i<exp.length();i++){
         char ch=exp.charAt(i);
         if(ch>='0' && ch<='9'){
             eval.push(Integer.parseInt(ch+""));
             infix.push(ch+"");
             prefix.push(ch+"");
         }
         else{
             int op2=eval.pop();
             int op1=eval.pop();
             eval.push(solve(op1,op2,ch));
             String inop2=infix.pop();
             String inop1=infix.pop();
             infix.push("("+inop1+ch+inop2+")");
             String preop2=prefix.pop();
             String preop1=prefix.pop();
             prefix.push(ch+preop1+preop2);
         }
     }
     System.out.println(eval.peek());
     System.out.println(infix.peek());
     System.out.println(prefix.peek());
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