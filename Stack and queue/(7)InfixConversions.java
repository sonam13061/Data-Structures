import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        prefixandpostfix(exp);
        // code
    }
    public static void prefixandpostfix(String exp) {
        Stack < Character > operators = new Stack < > ();
        Stack < String > prefix = new Stack < > ();
        Stack < String > postfix = new Stack < > ();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch >= 'A' && ch == 'Z' || ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
                prefix.push(ch + "");
                postfix.push(ch + "");
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {

                while (operators.size()>0 && operators.peek() != '(') {
                    String oprtr = operators.pop() + "";
                    String preop2 = prefix.pop();
                    String preop1 = prefix.pop();
                    prefix.push(oprtr + preop1 + preop2);
                    String postop2 = postfix.pop();
                    String postop1 = postfix.pop();
                    postfix.push(postop1 + postop2 + oprtr);
                }
                operators.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '(' && prec(operators.peek()) >= prec(ch)) {
                    String oprtr = operators.pop() + "";
                    String preop2 = prefix.pop();
                    String preop1 = prefix.pop();
                    prefix.push(oprtr + preop1 + preop2);
                    String postop2 = postfix.pop();
                    String postop1 = postfix.pop();
                    postfix.push(postop1 + postop2 + oprtr);
                }
                operators.push(ch);
            }
        }
        while (operators.size() > 0) {
            String oprtr = operators.pop() + "";
            String preop2 = prefix.pop();
            String preop1 = prefix.pop();
            prefix.push(oprtr + preop1 + preop2);
            String postop2 = postfix.pop();
            String postop1 = postfix.pop();
            postfix.push(postop1 + postop2 + oprtr);
        }
        System.out.println(postfix.pop());
        System.out.println(prefix.pop());
     

    }
    public static int prec(char ch) {
        if (ch == '*' || ch == '/') {
            return 1;
        } else {
            return 0;
        }
    }

}