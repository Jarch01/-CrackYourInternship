/*Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.*/

class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        s=s+' ';
        String str="",ans="";
        for(int i=0;i<s.length();i++) //Traversing the string
        {
            char chr=s.charAt(i); 
            if(chr==' ')      //Checking if the character is a ' ' then added to new string
            {
                if(str.length()!=0)
                {
                    ans=str+' '+ans; //added to new string if the length is not empty
                    str="";  //Reiniatizing for taking another word
                }
            }
            else
                str=str+chr; //if character is not ' ' string str is populate
        }
        ans=ans.trim(); //Trim to remove the forward and backword space characters
        return ans;
    }
}
