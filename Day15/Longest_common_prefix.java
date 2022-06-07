class Solution {
    public String longestCommonPrefix(String[] strs) {
        String check = strs[0];
        int i;
        for(i=0;i<check.length();i++)
        {
            char chr = check.charAt(i);
            if(!isValid(strs,chr,i))
            break ;
        }
        return check.substring(0,i);
    }
    public boolean isValid(String[] s,char chr,int ind)
    {
        for(int i=0; i<s.length; i++)
        {
            if(ind>=s[i].length())
                return false;
            char Currchar = s[i].charAt(ind);
            if(Currchar!=chr)
                return false;
        }
        return true;
    } 
}
