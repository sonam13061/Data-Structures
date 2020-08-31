import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }
   public static class Pair{
       Node node;
       int state;
       Pair(Node node,int state){
           this.node=node;
           this.state=state;
       }
       Pair(){
           
       }
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
 
  public static void IterativePreandPostOrder(Node node) {
    // write your code here
    String preorder="";
    String postorder="";
    Stack<Pair> st=new Stack<>();
    st.push(new Pair(node,-1));
    // preorder+=st.peek().node.data;
     while(st.size()>0){
         Pair top=st.peek();
        int currstate= top.state;
        Node currnode=top.node;
        if(top.state==-1){
             preorder=preorder+currnode.data+" ";
            top.state++;
        }
        else if(currstate>=0 && currstate<currnode.children.size()){
            st.push(new Pair(currnode.children.get(currstate),-1));
            top.state++;
            
        }
        else{
            
            postorder=postorder+currnode.data+" ";
            st.pop();
        }
       
         
     }
     System.out.println(preorder);
     System.out.println(postorder);
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
   
    IterativePreandPostOrder(root);

  }

}