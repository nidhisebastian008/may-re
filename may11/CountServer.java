package may11;


//1267
public class CountServer {
    
    class Solution {
        public int countServers(int[][] grid) {
            
            int m=grid.length;
            int n=grid[0].length;
            int count=0;
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(grid[i][j]==1)
                    {
                        int size=dfs(grid,i,j,m,n);
                        if(size>1)
                        count+=size;
                    }
                        
                }
            }
            return count;
            
        }
        // int[][]dir={{0,1},{1,0},{-1,0},{0,-1}};
        int   dfs(int[][]grid,int r,int c,int m,int n)
        {
            grid[r][c]=0;
            int size=1;
            for(int i=0;i<m;i++)
            {
                if(grid[i][c]==1)
                size+=dfs(grid,i,c,m,n);
            }
            for(int j=0;j<n;j++)
            {
                if(grid[r][j]==1)
                size+=dfs(grid,r,j,m,n);            
            }
            return size;
        }
    }
}