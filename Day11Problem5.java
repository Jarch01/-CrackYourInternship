class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        AllPath(m,n,0,0,"",ans);
        return ans;
    }
    public static void AllPath(int[][] m, int n,int row,int col, String s, ArrayList<String> ans)
    {
        if(row>=n||row<0||col>=n||col<0)
        return ;
        if(m[row][col]==0)
        return ;
        if(m[row][col]==-1)
        return ;
        if(row==n-1&&col==n-1)
        {
            ans.add(s);
            return ;
        }
        int CurrVal=m[row][col];
        m[row][col]=-1;
        AllPath(m,n,row+1,col,s+"D",ans);
        AllPath(m,n,row,col-1,s+"L",ans);
        AllPath(m,n,row,col+1,s+"R",ans);
        AllPath(m,n,row-1,col,s+"U",ans);
        m[row][col]=CurrVal;
    }
}
