class Solution {
    public boolean isPalindrome(int x) {
        String st = Integer.toString(x);
        int si = 0;
        int ei = st.length() - 1;
        while(si<=ei)
        {
            if(st.charAt(si)!=st.charAt(ei))
                return false;
            si++;
            ei--;
        }
        return true;
    }
}
