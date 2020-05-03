package may3;
// 551. Nested List Weight Sum
// 中文
// English

// Given a nested list of integers, return the sum of all integers in the list weighted by their depth. Each element is either an integer, or a list -- whose elements may also be integers or other lists.
// Example

// Example 1:

// Input: the list [[1,1],2,[1,1]], 
// Output: 10. 
// Explanation:
// four 1's at depth 2, one 2 at depth 1, 4 * 1 * 2 + 1 * 2 * 1 = 10

// Example 2:

// Input: the list [1,[4,[6]]], 
// Output: 27. 
// Explanation:
// one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4 * 2 + 6 * 3 = 27

public class Nested_list_wght_sum {
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
        
        int depth=0;
        for(NestedInteger n:nestedList)
        {
            if(n.isInteger())
            {
                depth+=1*n.getInteger()*1;
            }
            else{
               depth+=dfs(n.getList(),2); 
            }
        }
        
        return depth;
    }
    int dfs(List<NestedInteger> nestedList,int d)
    {
        //khud ki depth 2
        int depth=0;
        for(NestedInteger n:nestedList)
        {
            if(n.isInteger())
            {
                depth+=1*n.getInteger()*d;
            }
            else{
               depth+=dfs(n.getList(),d+1); 
            }
        }
        return depth;
        
    }
}