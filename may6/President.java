import java.io.InputStreamReader;
import java.util.*;

class TestClass {

    
    static int[] par;
    public static void main(String args[] ) {
       
        Scanner scn = new Scanner (new InputStreamReader(System.in));

        int n=scn.nextInt();
        int m=scn.nextInt();
        long k=scn.nextLong();

        

        par= new int[n+1];
        for(int i=1;i<par.length;i++)
        {
            par[i]=i;
        }
        ArrayList<ArrayList<Integer>> roads = new ArrayList<>();
        while(m-->0)
        {
                int u=scn.nextInt();
                int v=scn.nextInt();
                int w=scn.nextInt();
                ArrayList<Integer> road= new  ArrayList<>();
                road.add(u);
                road.add(v);
                road.add(w);
                roads.add(road);
        }
        Collections.sort(roads,(ArrayList<Integer>a,ArrayList<Integer>b)->
        (
              a.get(2)-b.get(2)
        ));

        long mincost=0;

        ArrayList<ArrayList<Integer>>kruskalGraph= new  ArrayList<>();

        for(ArrayList<Integer> road:roads)
        {
            int p1=findpar(road.get(0));
            int p2=findpar(road.get(1));
            if(p1!=p2)
            {
                par[p1]=p2;
                mincost+=road.get(2);
                
                kruskalGraph.add(road);
            }
        }
        int super_r=0;
        int countComponent=0;
        for(int i=1;i<par.length;i++)
        {
            if(par[i]==i && ++countComponent>1)
            {
                super_r=-1;
                System.out.println(super_r);
                return;
            }
        }   
        for(int i=kruskalGraph.size()-1;i>=0;i--)
        {
            if(mincost<=k)
            break;
            mincost=mincost-kruskalGraph.get(i).get(2)+1;
            super_r++;
        }
        if(mincost<=k)
        {
            System.out.println(super_r);
        }
        else{
            System.out.println(-1);
        }

    }

     static int findpar(int vtx)
        {
            if(par[vtx]==vtx) return vtx;
            return par[vtx]=findpar(par[vtx]);
        }
}