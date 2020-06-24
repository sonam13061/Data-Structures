import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        HashMap<Character,Integer> freqmp=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char key=str.charAt(i);
            if(freqmp.containsKey(key)){
                int old=freqmp.get(key);
                freqmp.put(key,old+1);
            }
            else{
                freqmp.put(key,1);
            }
        }
        int max=Integer.MIN_VALUE;
        char ans=' ';
        for(Character key:freqmp.keySet()){
            int freq=freqmp.get(key);
            if(freq>max){
                max=freq;
                ans=key;
            }
        }
        System.out.println(ans);
    }

}