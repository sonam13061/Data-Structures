import java.io.*;
import java.util.*;

public class Main {

  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }
    private int FindBucket(int bi,K key){
        int di=0;
        //Traverse in the bucket,if node found then return the index of node. 
        for(HMNode node:buckets[bi]){
            if(node.key.equals(key)){
                return di;
            }
            di++;
        }
        //If key not found,return -1.
        return -1;
    }
    private int HashFunction(K key){
        //Calculate hashcode of the key.
        int hc=key.hashCode();
        //Calculate valid index for the key.
        int bi=Math.abs(hc)% buckets.length;
        //then return the valid index.
        return bi;
    }
    private void rehashing() throws Exception{
        //Make a reference of buckets array.
        LinkedList<HMNode>[] oldbuckets=buckets;
        //Create an array of the size double of oldbuckets.
        initbuckets(2*oldbuckets.length);
        //then initialize size to 0,because our buckets array is empty now.
        size=0;
        //Now add the nodes of our oldbuckets array to our buckets array.
        for(LinkedList<HMNode> bucket:oldbuckets){
            for(HMNode node:bucket){
                put(node.key,node.value);
            }
        }
    }
    public void put(K key, V value) throws Exception {
      // write your code here
      //Find Bucket Index.
      int bi=HashFunction(key);
      //Find data index.
      int di=FindBucket(bi,key);
      //If key doesn't exist, get the node at the index and update the value.
      if(di!=-1){
          HMNode node=buckets[bi].get(di);
          node.value=value;
      }
      //Else create a new node and add the node at the last of bucket and increase the size.
      else{
          HMNode node=new HMNode(key,value);
          buckets[bi].addLast(node);
           size++;
          
      }
     
      double lambda=(size*1.0)/buckets.length;
      // If lamba is greater thans 2,then we need to do rehashing.
      if(lambda>2.0){
          rehashing();
      }
    }

    public V get(K key) throws Exception {
      // write your code here
      //find bucket and node index.
       int bi=HashFunction(key);
      int di=FindBucket(bi,key);
      //if node found then return value at that index.
      if(di!=-1){
          HMNode node=buckets[bi].get(di);
         return node.value;
      }
      //else return null.
      else{
         return null;
      }
    }

    public boolean containsKey(K key) {
      // write your code here
       int bi=HashFunction(key);
      int di=FindBucket(bi,key);
      //if value found return true,else false.
      if(di!=-1){
         return true;
      }
      else{
         return false;
      }
    }

    public V remove(K key) throws Exception {
      // write your code here
       int bi=HashFunction(key);
      int di=FindBucket(bi,key);
      //if node found,then remove the node and decrease size by 1.
      if(di!=-1){
          HMNode node=buckets[bi].remove(di);
          size--;
          return node.value;
      }
      //else return null because node doesnt exist,so we cannot remove it.
      else{
         return null;
      }
    }

    public ArrayList<K> keyset() throws Exception {
      // write your code here
      ArrayList<K> ans=new ArrayList<>();
      //Traverse the array of linkedlist.
      for(LinkedList<HMNode> bucket:buckets){
          //Now traverse every node of that bucket and add it to our arrayList.
            for(HMNode node:bucket){
                ans.add(node.key);
            }
        }
        return ans;
    }

    public int size() {
      // write your code here
      
      //return our private size variable,because we are maintaining that size variable evrytime we add or remove node.
      return size;
    }

    public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print(node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}