class Solution {
    public int numDistinct(String s, String t) {
        int ans = AllPaths(s,"",0,t,0,new HashMap<String,Integer>());
        return ans;
    }
    public int AllPaths(String s, String check, int ci, String t, int len,HashMap<String,Integer> memo)
    {
        if(len == t.length())
        {
            if(check.equals(t))
                return 1;
            return 0;
        }
        if(ci>=s.length())
            return 0;
        String key = check+"-"+ci;
        if(memo.containsKey(key))
            return memo.get(key);
        char chr = s.charAt(ci);
        int take = AllPaths(s,check+chr,ci+1,t,len+1,memo);
        int leave = AllPaths(s,check,ci+1,t,len,memo);
        int ans = take + leave;
        memo.put(key,ans);
        return ans;
    }
}
