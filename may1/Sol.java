class Sol
{
    public int firstBadVersion(int n) {
        //binary search
        int left=1;int right=n;
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(isBadVersion(mid)==false)
            {
                left=mid;
                if(isBadVersion(left+1)==true)return left+1;
            }
            else
            {
                right=mid;
            }
        }
        return 1;
        
    }
}