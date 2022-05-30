//Given a string Str which may contains lowercase and uppercase chracters. 
//The task is to remove all duplicate characters from the string and find the resultant string. 
//The order of remaining characters in the output should be same as in the original string.

class Solution {
    String removeDuplicates(String str) {
        int l=str.length();
        int i;
        String st="";
        int f[] = new int[256];  //Frequency array to store frequency of the characters
        for(i=0;i<l;i++)
        {
            char chr=str.charAt(i);
            f[chr]++;
            if(f[chr]==1) //If the frequency is one its added o the new string
            st=st+chr;
        }
        return st;
    }
}
