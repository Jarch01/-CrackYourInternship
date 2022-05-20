//Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

//LOGIC: the remainder will repeat if the sum is divisibe by k

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> memo = new HashMap<>(); //HashMap to store the remainder
        int ps=0,rem;
        int ans=0;
        memo.put(ps,1);     //to avoid edge cases
        for(int i=0;i<nums.length;i++)
        {
            ps=(ps+nums[i]);
            rem=(ps%k+k)%k;     //remainder of every sum
            if(memo.containsKey(rem))
            {
                ans=ans+memo.get(rem);   //adding the number of subarrays possible to answer
                memo.put(rem,memo.get(rem)+1);
            }
            else
                memo.put(rem,1);
        }
        return ans;
    }
}
