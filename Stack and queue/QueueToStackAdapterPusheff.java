import java.io.*;
import java.util.*;

public class Main {

  public static class QueueToStackAdapter {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapter() {
      mainQ = new ArrayDeque<>();
      helperQ = new ArrayDeque<>();
    }

    int size() {
      // write your code here
      return mainQ.size();
    }

    void push(int val) {
      // write your code here
       mainQ.add(val);
    }

    int pop() {
      // write your code here
      if(mainQ.size()==0){
          System.out.println("Stack underflow");
          return -1;
      }
	  //Move n-1 elements from mainQ to helperQ.
      while(mainQ.size()>1){
		  int val=mainQ.remove();
		  helperQ.add(val);
	  }
	  //remove nth element and store its value in a variable.
	  int rem=mainQ.remove();
	  //Now interchange mainQ and helperQ.
	  //method 1
	  //while(helperQ.size>1){
	      //mainQ.add(helperQ.remove());
	       //}
	       //method 2
	   Queue<Integer>temp=mainQ;
	   mainQ=helperQ;
	   helperQ=temp;
	    return rem;
    }

    int top() {
      // write your code here
        if(mainQ.size()==0){
          System.out.println("Stack underflow");
          return -1;
         }
      while(mainQ.size()>1){
		  int val=mainQ.remove();
		  helperQ.add(val);
	  }
	  int rem=mainQ.remove();
	  helperQ.add(rem);
	   Queue<Integer> temp=mainQ;
	   mainQ=helperQ;
	   helperQ=temp;
	    return rem;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    QueueToStackAdapter st = new QueueToStackAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      }
      str = br.readLine();
    }
  }
}