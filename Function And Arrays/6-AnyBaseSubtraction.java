import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getDifference(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getDifference(int b, int n1, int n2){
       // write your code here
       int borrow=0,sum=0,pow=1;
       while(n1!=0 || n2!=0){
       int dig1=n1%10;
       int dig2=n2%10-borrow;
       int diff=dig2-dig1;
       if(diff<0){
           diff=diff+b;
           borrow=1;a
       }
       else{
           borrow=0;
       }
       sum=sum+diff*pow;
       pow=pow*10;
       n1=n1/10;
       n2=n2/10;
       }
       return sum;
   }
  
  }