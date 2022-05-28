//Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int ans = MaxRepeat(nums1,nums2,0,0,new HashMap<String,Integer>()); //HashMap to store overlapping subproblems
        return ans;
    }
    public int MaxRepeat(int[] n1,int[] n2,int i,int j,HashMap<String,Integer> memo)
    {
        if(i==n1.length||j==n2.length) //If either of the length is finished processing
            return 0;
        int ans=0;
        String key = i+"-"+j;
        if(memo.containsKey(key))
            return memo.get(key);
        if(n1[i]==n2[j])
            ans=1+MaxRepeat(n1,n2,i+1,j+1,memo); //If both the element is same we move forward
        else
        {
            int Diff1=MaxRepeat(n1,n2,i+1,j,memo); //Path where we move forward on 1st Array
            int Diff2=MaxRepeat(n1,n2,i,j+1,memo); //Path where we move forward on 2nd Array
            ans=Math.max(Diff1,Diff2);
        }
        memo.put(key,ans);
        return ans;
    }
}
