import java.util.*;

public class Main{
    public static class Node{
        int data;
        ArrayList<Node> children=new ArrayList<>();
    }
    public static Node construct(int[] input){
        Stack<Node> st=new Stack<>();
        Node root=new Node();
        root.data=input[0];
        st.push(root);
        for(int i=1;i<input.length;i++){
            if(input[i]==-1){
                st.pop();
            }
            else{
                Node node=new Node();
                node.data=input[i];
                Node parent=st.peek();
                parent.children.add(node);
                st.push(node);
            }
        }
        return root;
        
    }
    public static void display(Node root){
        System.out.print(root.data+"->");
     for(int i=0;i<root.children.size();i++){
        System.out.print(root.children.get(i).data+" ");
    }
    System.out.println(".");
    for(int i=0;i<root.children.size();i++){
        display(root.children.get(i));
    }
    }

public static void main(String[] args) {

// write your code here.
int[] input={10,20,50,-1,60,-1,-1,30,70,-1,-1,40,100,-1,-1,-1};
Node root=construct(input);
display(root);

 }
}