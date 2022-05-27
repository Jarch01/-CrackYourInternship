//Given the root of a binary tree, return all root-to-leaf paths in any order.

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        AllPaths(root,"",ans);
        return ans;
    }
    void AllPaths(TreeNode root,String s,List<String> ans)
    {
        if(root==null)
            return ;
        if(root.left==null && root.right==null)
        {
            s=s+"->"+root.val;  //Updating the leaf node to string
            String answer = s.substring(2);  //to remove the arrow in the front
            ans.add(answer);
            return ;
        }
        AllPaths(root.left,s+"->"+root.val,ans);  //Left child traversal path
        AllPaths(root.right,s+"->"+root.val,ans); //Right child traversal path
        return ;
    }
}
