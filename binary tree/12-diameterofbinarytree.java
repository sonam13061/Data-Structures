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

  public static int height(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = height(node.left);
    int rh = height(node.right);

    int th = Math.max(lh, rh) + 1;
    return th;
  }
  static int max=Integer.MIN_VALUE;
  public static int diameter1(Node node) {
    // write your code here
    if(node==null){
        return -1;
    }
    int leftd=diameter1(node.left);
    int rightd=diameter1(node.right);
   
    int d=leftd+rightd+2;
    if(d>max){
        max=d;
    }
    //ht++;
    return Math.max(leftd,rightd)+1;
  }

   public static Pairdia diameter2(Node node){
       if(node==null){
           Pairdia base=new Pairdia();
           base.height=-1;
           base.diameter=0;
           return base;
       }
      Pairdia lpair=diameter2(node.left);
      Pairdia rpair=diameter2(node.right);
      
      int localdia=lpair.height+rpair.height+2;
      int localheight=Math.max(lpair.height,rpair.height)+1;
      
      Pairdia res=new Pairdia();
      res.diameter=Math.max(localdia,Math.max(lpair.diameter,rpair.diameter));
      res.height=localheight;
      
      return res;
       
   }
   public static class Pairdia{
       int diameter;
       int height;
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

    //int diameter = 0;
    //max=Integer.MIN_VALUE;
    Pairdia ans = diameter2(root);
    
    System.out.println(ans.diameter);
  }

}