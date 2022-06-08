class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length() - 1;
        int ei = n;
        int si = 0;
        while(si<=ei)
        {
            if(s.charAt(si)==s.charAt(ei))
            {
                si++;
                ei--;
            }
            else
            {
                boolean ans = isPalin(s,si+1,ei) || isPalin(s,si,ei-1);
                return ans;
            }
        }
        return true;
    }
    public boolean isPalin(String s, int si, int ei)
    {
        while(si<=ei)
        {
            if(s.charAt(si)!=s.charAt(ei))
                return false;
            si++;
            ei--;
        }
        return true;
    }
}
