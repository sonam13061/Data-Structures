import java.util.*;

public class Main{

public static void main(String[] args) {


HashMap<String,Integer> hm=new HashMap<>();
hm.put("India",135);
hm.put("china",139);
hm.put("Nepal",20);
System.out.println(hm.get("India"));
hm.put("India",140);
System.out.println(hm.get("India"));

System.out.println(hm.get("USA"));
System.out.println(hm.containsKey("India"));
System.out.println(hm);
for(String key:hm.keySet()){
    System.out.println(key+" -> "+hm.get(key));
}
System.out.println(hm.values());
// write your code here.

 }
}