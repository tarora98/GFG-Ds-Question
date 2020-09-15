
//136
class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans^=nums[i]; // left only the  single one as in xor the same same(for eg.      0,0) will be 0 
        }
        return ans;
    }
}