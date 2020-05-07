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
    public boolean isCousins(TreeNode root, int x, int y)
    {
         LinkedList<TreeNode> queue= new LinkedList<>();
        
        queue.addLast(root);
        int level=0;boolean flagx=false;boolean flagy=false;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            while(size-->0)
            {
                TreeNode rem=queue.removeFirst();
                if(rem.val==x)flagx=true;
                if(rem.val==y)flagy=true;
                if(flagx&&flagy)return true;
                
                
                
            if(rem.right!=null&&rem.left!=null)
            {
                if(x==rem.right.val&&y==rem.left.val)
                {
                    System.out.println(1);
                    return false;
                }
                if(y==rem.right.val&&x==rem.left.val)
                {
                    System.out.println(2);
                    return false;
                }
            }
                
                if(rem.right!=null)
                {
                    queue.addLast(rem.right);
                }
                if(rem.left!=null)
                {
                    queue.addLast(rem.left);
                } 
            }
               if(flagx||flagy)
               {System.out.println(3);
                   return false;}
                level++;
            }
            
           return true; 
            
        }
    
    
}