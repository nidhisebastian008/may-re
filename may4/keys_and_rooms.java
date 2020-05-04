class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int N=rooms.size();
         boolean[]vis= new boolean[N];
        int max_size=0;
        int count=0;
        for(int i=0;i<N;i++)
        {
            if(!vis[i])
            {
                count++;
                gcc_dfs(i,vis,rooms);
            }
            
        }
       
        return count==1;
    }
    
    public static int gcc_dfs(int src,boolean[]vis,List<List<Integer>> rooms)
    {
        
        vis[src]=true;
        int count=0;
        for(int roomsnext:rooms.get(src))
        {
            if(!vis[roomsnext])
            {
                count+=gcc_dfs(roomsnext, vis,rooms);
            }
        }
        return count+1;
        
    }
}