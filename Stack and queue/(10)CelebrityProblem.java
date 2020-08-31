import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it''s index (not position), if there is not then
        // print "none"
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            st.push(i);
        }
        while(st.size()>1){
            int x=st.pop();
            int y=st.pop();
            //that means x knows y,so x cant be celebrity but y can.
            if(arr[x][y]==1){
                st.push(y);
            }
            //that means x doesnt know y,so y cant be celebrity,but x can.
            else{
                st.push(x);
            }
        }
        boolean isceleb=true;
        int p=st.pop();
        for(int i=0;i<arr.length;i++){
            if(i!=p){
                //if any person doesnt know p or p knows any other person then p cant be celebrity.
                if(arr[p][i]==1 || arr[i][p]==0){
                    isceleb=false;
                    break;
                }
            }
        }
        if(isceleb){
            System.out.println(p);
        }
        else{
            System.out.println("none");
        }
    }

}