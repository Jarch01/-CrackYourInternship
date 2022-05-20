//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

//You may assume that each input would have exactly one solution, and you may not use the same element twice.

//You can return the answer in any order.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> memo = new HashMap<>(); //HashMap to store the previous encounter element
        int a[] = new int[2];
        int i;
        for(i=0;i<nums.length;i++)
            memo.put(nums[i],i); //Storing the elements encounter wiyth index
        for(i=0;i<nums.length;i++)
        {
            int key=target-nums[i]; //Getting values that are target-k
            if(memo.containsKey(key)&&memo.get(key)!=i) //Checking if the diff is present and its not the same index
            {
                a[0]=i; //storing the index in array
                a[1]=memo.get(key);
                return a;
            }
        }
        a[0]=-1; //if the answer is not present
        a[1]=-1;
        return a;
    }
}
