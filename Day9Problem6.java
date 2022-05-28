//Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

//The solution set must not contain duplicate subsets. Return the solution in any order.

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);  //Sorted the array for removing duplicates
        
        List<List<Integer>> ans = new ArrayList<>();
        FindSubsets(nums,0,new ArrayList<Integer>(),ans);
        return ans;
    }
    public void FindSubsets(int[] a,int ci,List<Integer> Cans,List<List<Integer>> ans)
    {
        if(ci>=a.length)
        {
            ans.add(new ArrayList(Cans)); //Storing in the answer list
            return ;
        }
        
        Cans.add(a[ci]);
        FindSubsets(a,ci+1,Cans,ans); //Path for taken
        Cans.remove(Cans.size()-1); //BackTracking
        
        while(ci<a.length-1&&a[ci]==a[ci+1])  //Passing to remove duplicates
            ci++;
        
        FindSubsets(a,ci+1,Cans,ans); //Path for skipping
        return ;
    }
}
