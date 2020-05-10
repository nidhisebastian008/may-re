//1161
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
    public int maxLevelSum(TreeNode root) {
        
        int maxsum=0;
        int maxlevel=1;
        int sum=0;
        // if(root==null)return leve;
        LinkedList<TreeNode> queue= new LinkedList<>();
        queue.addLast(root);
        // HashSet<TreeNode>vis = new HashSet<>();
        int level=1;
        
        while(!queue.isEmpty())
        {
            int size=queue.size();
            sum=0;
            
            while(size-->0)
            {
                TreeNode rem= queue.removeFirst();
                sum+=rem.val;
                // vis.add(rem);
                if(rem.left!=null)
                {
                    queue.addLast(rem.left);
                }
                if(rem.right!=null)
                {
                    queue.addLast(rem.right);
                }
                
            }
            if(sum>maxsum)
            {
                maxsum=sum;
                maxlevel=level;
            }
            level++;
        }
        return maxlevel;
        
    }
}