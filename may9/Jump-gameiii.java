
//1306

class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        ArrayList<Integer>[] dgraph= new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            dgraph[i]=new ArrayList<Integer>();
        }
        int src=start;
        ArrayList<Integer> des= new ArrayList<>();
        for(int idx=0;idx<n;idx++)
        {
            int val=arr[idx];
            if(val==0)
            {
                des.add(idx);
            }
            //check boundary
            if(idx+val<n)
            {
                int n1=idx+val;
                dgraph[idx].add(n1);
            }
            if(idx-val>=0)
            {
                int n2=idx-val;    
                dgraph[idx].add(n2);
            } 
            
        }
        
        for(int d:des)
        {
            boolean[]vis= new boolean[n];
            if(hasPath(dgraph,start,d,vis))return true;
        }
        return false;
    }
    boolean hasPath(ArrayList<Integer>[]graph,int src,int des,boolean [] vis)
    {
        if(src==des)
        {
            return true;
        }
        boolean res=false;
        vis[src]=true;
        for(int nbr:graph[src])
        {
            if(!vis[nbr])
            {
                res=res||hasPath(graph,nbr,des,vis);
            }
        }
        return res;
    }
}