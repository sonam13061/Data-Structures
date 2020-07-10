import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    int d = getProduct(b, n1, n2);
    System.out.println(d);
 }
 public static int getSum(int b, int n1, int n2){
       // write ur code here
       int sum=0;
       int carry=0;
       int pow=1;
       while(n1!=0 || n2 !=0 || carry!=0){
          int dig1=n1%10;
          int dig2=n2%10;
          int s=dig1+dig2+carry;
          sum=sum+pow*(s%b);
          carry=s/b;
          pow=pow*10;
          n1=n1/10;
          n2=n2/10;
       }
       return sum;
   }
  public static int multiplyonedig(int dig,int num,int b){
      int sum=0,carry=0,pow=1;
      while(num!=0 || carry!=0){
          int dig2=num%10;
          int s=(dig)*dig2+carry;
          sum=sum+(s%b)*pow;
          carry=s/b;
          pow=pow*10;
          num=num/10;
      }
      return sum;
  }
public static int getProduct(int b, int n1, int n2){
// write your code here
int pow=1;
int sum=0;
while(n2!=0){
    int dig=n2%10;
    int mul=multiplyonedig(dig,n1,b)*pow;
    sum=getSum(b,sum,mul);
    pow=pow*10;
    n2=n2/10;
}
return sum;
     
 }

}