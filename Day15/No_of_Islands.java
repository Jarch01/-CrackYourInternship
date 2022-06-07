class Solution {
    public int numIslands(char[][] graph) {
        int m=graph.length;
        int n=graph[0].length;
        int ans=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(graph[i][j]=='1' && isValid(graph,i,j))
                {
                    ans++;
                }
            }
        }
        return ans;
    }
    public static boolean isValid(char[][] graph,int row,int col)
    {
        if(row<0||row>=graph.length||col<0||col>=graph[0].length)
        return true;
        if(graph[row][col]=='0')
        return true;
        graph[row][col]='0';
        boolean up = isValid(graph,row-1,col);
        boolean down = isValid(graph,row+1,col);
        boolean left = isValid(graph,row,col-1);
        boolean right = isValid(graph,row,col+1);
        return up && down && left && right;
    }
}
