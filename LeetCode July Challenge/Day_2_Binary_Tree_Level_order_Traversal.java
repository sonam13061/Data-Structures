/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>list=new ArrayList<>();
        if(root!=null){
        Queue<Pair> q=new ArrayDeque<>();
        q.add(new Pair(root,0));
        int currlevel=-1;
        while(q.size()>0){
            Pair p=q.remove();
          
            if(currlevel!=p.level){
                 list.add(new ArrayList<Integer>()); 
                currlevel=p.level;
            }
              list.get(currlevel).add(p.node.val);
            if(p.node.left!=null){
                q.add(new Pair(p.node.left,p.level+1));
            }
            if(p.node.right!=null){
                q.add(new Pair(p.node.right,p.level+1));
            }
            
        }
        }
        Collections.reverse(list);
        return list;
    }
    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node,int level){
            this.node=node;
            this.level=level;
        }
    }
}