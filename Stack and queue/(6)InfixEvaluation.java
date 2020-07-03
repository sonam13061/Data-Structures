import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Stack<Character> operators=new Stack<>();
    Stack<Integer> operands=new Stack<>();
    for(int i=0;i<exp.length();i++){
        char ch=exp.charAt(i);
        if(ch>='0' && ch<='9'){
            operands.push(Integer.parseInt(ch+""));
        }
        else if(ch=='('){
            operators.push(ch);
        }
        else if(ch==')'){
            while(operators.peek()!='('){
                int num2=operands.pop();
                int num1=operands.pop();
                char op=operators.pop();
                operands.push(solve(num1,num2,op));
            }
            operators.pop();
        }
        else if(ch=='+' || ch=='*'|| ch=='-' || ch=='/'){
            while(operators.size()>0 && operators.peek()!='(' && prec(operators.peek())>=prec(ch)){
                int num2=operands.pop();
                int num1=operands.pop();
                char op=operators.pop();
                operands.push(solve(num1,num2,op));
            }
            operators.push(ch);
        }
    }
             while(operators.size()>0){
                int num2=operands.pop();
                int num1=operands.pop();
                char op=operators.pop();
                operands.push(solve(num1,num2,op));
    }
     
     System.out.println(operands.peek());
    // code
 }
 public static int prec(char ch){
     if(ch=='*' || ch=='/'){
         return 1;
     }
     else{
         return 0;
     }
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