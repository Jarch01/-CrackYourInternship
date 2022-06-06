//Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets among M students such that :
//1. Each student gets exactly one packet.
//2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.
class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        long ans = a.get(m-1)-a.get(0);
        int i=m;
        int j=1;
        while(i<n)
        {
            ans=Math.min(ans,a.get(i)-a.get(j));
            i++;
            j++;
        }
        return ans;
    }
}
