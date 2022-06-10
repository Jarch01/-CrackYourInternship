class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        for(int i=0; i<n; i++)
        {
            if(needle.charAt(0)==haystack.charAt(i))
            {
                if(Check(haystack,needle,i))
                    return i;
            }
        }
        return -1;
    }
    public boolean Check(String s1, String s2, int k)
    {
        int n = s2.length();
        if(s1.length()-k <s2.length())
            return false;
        for(int i=0; i<n; i++,k++)
        {
            if(s2.charAt(i)!=s1.charAt(k))
                return false;
        }
        return true;
    }
}
