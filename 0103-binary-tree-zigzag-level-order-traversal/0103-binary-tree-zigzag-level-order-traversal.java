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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> outer =new ArrayList<>();
        if(root==null) return outer;
        Queue<TreeNode> q=new LinkedList<>();
        int flag=0;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> inner=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                inner.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            if(flag==1){
                Collections.reverse(inner);
                outer.add(inner);
                flag=0;
            }else{
                outer.add(inner);
                flag=1;
            }
        }
        return outer;
    }
}