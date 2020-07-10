import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
   for(int i=0;i<a.length;i++){
       System.out.println(a[i]);
   }
}
  public static int[] inverse(int[] a){
    // write your code here
    int inverse[]=new int[a.length];
    for(int i=0;i<a.length;i++){
        inverse[a[i]]=i;
    }
    return inverse;
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] inv = inverse(a);
    display(inv);
 }

}