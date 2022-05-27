//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

//Each number in candidates may only be used once in the combination

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);  //Array sorted to avoid duplicates
        List<List<Integer>> ans = new ArrayList<>();
        CombineSum(candidates,0,target,new ArrayList<Integer>(),ans);
        return ans;
    }
    public void CombineSum(int[] a,int ci,int s,List<Integer> subset,List<List<Integer>> ans)
    {
        if(s==0)
        {
            ans.add(new ArrayList(subset));
            return ;
        }
        if(ci>=a.length)
            return ;
        if(a[ci]<=s)
        {
            subset.add(a[ci]);
            CombineSum(a,ci+1,s-a[ci],subset,ans);  //Path if the element choosen for subset
            subset.remove(subset.size()-1); //BackTracking
        }
        
        while(ci<a.length-1&&a[ci]==a[ci+1]) //Skipping the dublicate elements
            ci++;
        
        CombineSum(a,ci+1,s,subset,ans);  //Path if the element is not chosen
        return ;
    }
}
