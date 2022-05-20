//Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

//LOGIC: If sum-k is present, then we have encounter a sum with diff k
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> memo = new HashMap<>(); //HashMap to store the previous encounter sum
        int sum=0;
        int ans=0;
        memo.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
            if(memo.containsKey(sum-k))  //Checking if sum-k is present
                ans=ans+memo.get(sum-k);  //Increasing the answer as per the freq of the sum-k present
            if(memo.containsKey(sum))    //Storing the sum value to the HashMap
                memo.put(sum,memo.get(sum)+1);
            else
                memo.put(sum,1);
        }
        return ans;
    }
}
