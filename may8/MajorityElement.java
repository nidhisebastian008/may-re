package may8;

public class MajorityElement {
    public static void main(String[] args) {
        
    }
    public int majorityElement(int[] nums) {
        int maj_idx=0;int count=0;
        
        //cancel an  elem e with all other different elem
        //if elem e exists even after the above then its candidate for maj
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==nums[maj_idx])
            {
                count++;
            }
            else
            {
                count--;
            }
            if(count==0)
            {
                maj_idx=i;
                count=1;
            }
            
        }
        //is candiadate majority elem
        return nums[maj_idx];
    }
}