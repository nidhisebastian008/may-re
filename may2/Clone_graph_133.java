class Solution {
    
    
    //refer gfg
    1)DFStraversal 
    2)while visiting a node make a clone node of it (a copy of original node). 
    3) already visited then it already has a clone node.(base case)
    4)map or hmap for visited check and mapping clone to original
    5)visit all the neighboring nodes 
        for  each neighbor 
                 find the corresponding clone  node(if not found create one) 
                 and then push into the neighboring al of node.



    //mps original and clone
    HashMap<Node,Node> mp= new HashMap<>();
    public Node cloneGraph(Node node) {
        
        if(node==null) return node;
        // dfs
        return dfs(node);
        
    }
    Node dfs(Node node)
    {
        
        if(mp.containsKey(node))return mp.get(node);//return clone to add its nbrs
        //new copy of curr node with empty nbr
        Node clone = new Node (node.val, new ArrayList<Node>());
        // visited=true
        mp.put(node,clone);
        for(Node nbr:node.neighbors)
        {
            clone.neighbors.add(dfs(nbr));
        }
        return clone;
    }
    
    
}