class Solution {
    public int numJewelsInStones(String J, String S) {
        int count =0;
        boolean[] jewels= new  boolean[256];
        for(int i=0;i<J.length();i++)
        {
            char c=J.charAt(i);
            jewels[c]=true;
        }
        for(int i=0;i<S.length();i++)
        {
            char c=S.charAt(i);
            if(jewels[c])count++;
        }
        return count;
    }
}