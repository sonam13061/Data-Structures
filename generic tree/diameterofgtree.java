import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int data;
        ArrayList < Node > children = new ArrayList < > ();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child: node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child: node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack < Node > st = new Stack < > ();
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

    static int maxdia;
    //diameter of any two nodes.
    public static int diameter(Node node) {
        int ht = -1;
        int lh = -1, slh = -1;
        for (int i = 0; i < node.children.size(); i++) {
            int ch = diameter(node.children.get(i));
            ht = Math.max(ht, ch);
            if (ch > lh) {
                slh = lh;
                lh = ch;
            } else if (ch > slh) {
                slh = ch;
            }

        }
        
            int diameter = lh + slh + 2;
            if (diameter > maxdia) {
                maxdia = diameter;
            }
           }

        ht++;
        return ht;
    }
    //diameter of leaf nodes.
    public static int diameterofleaf(Node node) {
        int ht = -1;
        int lh = -1, slh = -1;
        for (int i = 0; i < node.children.size(); i++) {
            int ch = diameter(node.children.get(i));
            ht = Math.max(ht, ch);
            if (ch > lh) {
                slh = lh;
                lh = ch;
            } else if (ch > slh) {
                slh = ch;
            }

        }
        if (lh != -1 && slh != -1) {
            int diameter = lh + slh + 2;
            if (diameter > maxdia) {
                maxdia = diameter;
            }
        }

        ht++;
        return ht;
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
        maxdia = 0;
        diameter(root);
        System.out.println(maxdia);

        // write your code here
    }

}