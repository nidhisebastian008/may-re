

//1443
class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
       
        //create graph 
        //directional is only  needed
        ArrayList<Integer>[]graph = new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            graph[i]=new ArrayList<Integer>();
            
        }
        for(int[]edge:edges)
        {
            graph[edge[0]].add(edge[1]);
        }
        
       return dfs(graph,0,hasApple);
    }
    int dfs(ArrayList<Integer>[]graph ,int src,List<Boolean> hasApple)
    {
        
        int d=0;
        for(int child:graph[src])
        {
            d+=dfs(graph,child,hasApple);
        }
        //// If any of the subtree has an apple AND is not root node of original tree
        //root me no d (reason)
        //d>0 tellls ki uske kisi child me addple hai
        //kunki uske child yaha se guzar chuke usse pele
        //aur agar umpe pple hai toh add bhi kar chuke d me toh isle d>0 matlb childo me kahin apple pada hai
        //do eclipse debug for this
        if((d>0||hasApple.get(src))&&src!=0)
        {
            d+=2;
        }
        return d;
    }

   
}