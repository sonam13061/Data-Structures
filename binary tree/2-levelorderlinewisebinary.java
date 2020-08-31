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
    Node(int data){
        this.data=data;
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
  public static class PairLevel{
      Node node;
      int level;
      PairLevel(Node node,int level){
          this.node=node;
          this.level=level;
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

  public static void levelOrder(Node node) {
    // write your code here
    Queue<PairLevel> q=new ArrayDeque<>();
    q.add(new PairLevel(node,1));
    int currlevel=1;
    while(q.size()>0){
        PairLevel temp=q.remove();
        if(currlevel!=temp.level){
            currlevel=temp.level;
            System.out.println();
        }
        System.out.print(temp.node.data+" ");
        if(temp.node.left!=null)
        q.add(new PairLevel(temp.node.left,currlevel+1));
            
        if(temp.node.right!=null)
        q.add(new PairLevel(temp.node.right,currlevel+1));
        
    }
  }
  public static void levelOrderapp2(Node node){
      Queue<Node> q=new ArrayDeque<>();
      q.add(node);
      while(q.size()>0){
          int count=q.size();
          for(int i=0;i<count;i++){
             
              Node temp=q.remove();
               System.out.print(temp.data+" ");
              if(temp.left!=null){
              q.add(temp.left);
              }
              if(temp.right!=null){
              q.add(temp.right);
              }
          }
          System.out.println();
      }
      
  }
  public static void levelOrderapp3(Node node){
      Queue<Node> q=new ArrayDeque<>();
      q.add(node);
      q.add(new Node(Integer.MIN_VALUE));
      while(q.size()>0){
          Node temp=q.remove();
          if(temp.data==Integer.MIN_VALUE){
                System.out.println();
                if(q.size()!=0){
                    q.add(new Node(Integer.MIN_VALUE));
                }
                
          }
          else{
              System.out.print(temp.data+" ");
              if(temp.left!=null){
                  q.add(temp.left);
              }
              if(temp.right!=null){
                  q.add(temp.right);
              }
              
          }
      }
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
    levelOrderapp3(root);
  }

}