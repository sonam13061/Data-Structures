import java.util.*;

public class Main{

public static class Node{
    Integer data;
    Node left;
    Node right;
    Node(Integer data){
        this.data=data;
        left=null;
        right=null;
    }
    Node(Integer data,Node lchild,Node rchild){
        this.data=data;
        this.left=lchild;
        this.right=rchild;
    }
}
public static class Pair{
    Node node;
    int state;
    Pair(Node node,int state){
        this.node=node;
        this.state=state;
    }
}
public static Node construct(Integer[] input){
    Node root=new Node(input[0]);
    Stack<Pair> st=new Stack<>();
    st.push(new Pair(root,1));
    int idx=1;
    
    while(st.size()>0){
        Pair top=st.peek();
     
        if(top.state==1){
               Integer val=input[idx];
            if(val!=null){
                Node node=new Node(val);
                top.node.left=node;
                st.push(new Pair(node,1));
                
            }
            else{
                top.node.left=null;
            }
            top.state++;
            idx++;
        }
        else if(top.state==2){
               Integer val=input[idx];
            if(val!=null){
                Node node=new Node(val);
                top.node.right=node;
                st.push(new Pair(node,1));
                
            }
            else{
                top.node.right=null;
            }
            top.state++;
            idx++;
        }
        else if(top.state==3){
            st.pop();
        }
        
    }
    return root;
    
}
public static void display(Node node){
    String str="";
    if(node.left==null){
        str=str+".";
    }
    else{
        str=str+node.left.data;
    }
    str=str+"<- "+node.data+"->";
     if(node.right==null){
        str=str+".";
    }
    else{
        str=str+node.right.data;
    }
    System.out.println(str);
    if(node.left!=null){
    display(node.left);
    }
    if(node.right!=null){
    display(node.right);
    }
    
}
public static void main(String[] args) {

// write your code here.
Integer[] input={10,20,40,null,null,50,60,null,null,null,30,null,70,80,null,null,90,null,null};
 
Node root=construct(input);
display(root);
}
}