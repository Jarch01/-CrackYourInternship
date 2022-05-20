//Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n=nums.length+1;
        int i;
        for(i=0;i<nums.length;i++)
        {
            int index = nums[i]%n;  //Since value lies in 1 to N so it is present in array index
            nums[index-1]+=n;       //Increasing the index value to a value out of range
        }
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]/n==2)    //Checking frequency == 2
                ans.add(i+1);   //Since index is the answer so index is added to the list ans
            nums[i]=nums[i]%n;  //Converting the array to its original value
        }
        return ans;
    }
}
