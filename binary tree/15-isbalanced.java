import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }
 public static Pairheight isBalanced(Node node){
     if(node==null){
         Pairheight base=new Pairheight();
         base.height=-1;
         base.isbalanced=true;
         return base;
     }
     Pairheight l=isBalanced(node.left);
     Pairheight r=isBalanced(node.right);
     Pairheight ans=new Pairheight();
     ans.height=Math.max(l.height,r.height)+1;
     int diff=Math.abs(l.height-r.height);
     if(diff<=1 && l.isbalanced==true && r.isbalanced==true){
         ans.isbalanced=true;
     }
     else{
         ans.isbalanced=false;
     }
     return ans;
 }
 public static class Pairheight{
     int height;
     boolean isbalanced;
 }
 static boolean isbalanced=true;
 public static int ht(Node node){
     if(node==null|| isbalanced==false){
         return -1;
     }
     int lh=ht(node.left);
     int rh=ht(node.right);
     
      
          if(Math.abs(lh-rh)>1){
              isbalanced=false;
          }
      
      return Math.max(lh,rh)+1;
 }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    // Pairheight ans=isBalanced(root);
    // System.out.println(ans.isbalanced);
    // write your code here
    ht(root);
    System.out.println(isbalanced);
  }

}