class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        Paranthesis(0,0,"",n,ans);
        return ans;
    }
    public void Paranthesis(int op,int cp,String s,int n,List<String> ans)
    {
        if(op==n && cp==n)
        {
            ans.add(s);
            return ;
        }
        if(op<n)
            Paranthesis(op+1,cp,s+"(",n,ans);
        if(op>cp)
            Paranthesis(op,cp+1,s+")",n,ans);
        return ;
    }
}
