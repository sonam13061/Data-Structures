import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;

    return h;
  }

  public static void traversals(Node node){
    System.out.println("Node Pre " + node.data);

    for(Node child: node.children){
      System.out.println("Edge Pre " + node.data + "--" + child.data);
      traversals(child);
      System.out.println("Edge Post " + node.data + "--" + child.data);
    }

    System.out.println("Node Post " + node.data);
  }

  public static void levelOrderLinewiseZZ(Node node){
    // write your code here
    Stack<Node> ms=new Stack<>(); //Main stack
    ms.push(node);  //push node to main stack
    Stack<Node> cs=new Stack<>(); //make child stack=0;
    int l=0; //level,inititally 0
    while(ms.size()>0){
        Node n=ms.pop(); //Pop node.
        System.out.print(n.data+" "); //print the data
        if(l%2==0){
            //if level is even,push the children of popped node to child stack in right order.
            for(int i=0;i<n.children.size();i++){
             cs.push(n.children.get(i));   
            }
        }
        else{
            //if level is odd then push the children in reverse order.
             for(int i=n.children.size()-1;i>=0;i--){
                    cs.push(n.children.get(i));   
            }
        }
        //when main stack is empty then increase the level,move to next line and swap main and child stacks.
        if(ms.size()==0){
            System.out.println();
            Stack<Node> temp=ms;
            ms=cs;
            cs=temp;
            l++;
        }
        
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    levelOrderLinewiseZZ(root);
  }

}