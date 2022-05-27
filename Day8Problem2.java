//Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        AllCombo(n,1,k,new ArrayList<Integer>(),ans);
        return ans;
    }
    public void AllCombo(int n,int ci,int k,List<Integer> Cans,List<List<Integer>> ans)
    {
        if(k==0)  //Count of k
        {
            ans.add(new ArrayList(Cans));
            return ;
        }
        if(ci>n)
            return ;
        
        Cans.add(ci);
        AllCombo(n,ci+1,k-1,Cans,ans);  //Path if the element is chosen
        Cans.remove(Cans.size()-1);  //BackTracking
        
        AllCombo(n,ci+1,k,Cans,ans); //Path if the element is not chosen
        return ;
    }
}
