import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int sourceBase = scn.nextInt();
     int  destBase= scn.nextInt();
     System.out.println(anybaseToanybase(n,sourceBase,destBase));
   }   
   public static int anybaseToanybase(int n,int sb,int db){
       int dec=getValueIndecimal(n,sb);
       int ans=getValueInBase(dec,db);
       return ans;
   }
    public static int getValueIndecimal(int n, int b){
  // write your code here
      int sum=0;
      int pow=1;
      while(n!=0){
          int dig=n%10;
          sum=sum+dig*pow;
          pow=pow*b;
           n=n/10;
      }
      return sum;
   }
   public static int getValueInBase(int n, int b){
       // write code here
       int sum=0,power=1;
       while(n!=0){
           int dig=n%b;
           sum=sum+dig*power;
           power=power*10;
           n=n/b;
           
       }
       return sum;
   }
  }