//Lowest Common Ancestor of Binary Tree

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(isPresentinNode(p,q))  //Checking whether the node is the subroot of q node
            return p;
        if(isPresentinNode(q,p))  //Checking whether the node is the subroot of p node
            return q;
        TreeNode[] ans = new TreeNode[1];
        FindLCA(root,p,q,ans);  //Finding the ancestor if left consists one node and right contains other
        return ans[0];
    }
    public boolean FindLCA(TreeNode root,TreeNode p,TreeNode q,TreeNode[] ans)
    {
        if(root==null)
            return false;
        if(root==q||root==p) //If one of p or q is present retur true
            return true;
        boolean left = FindLCA(root.left,p,q,ans);
        boolean right = FindLCA(root.right,p,q,ans);
        if(left && right && ans[0]==null) //First time when both the paths return true is lowest ancestor
            ans[0]=root;
        return left||right;
    }
    public boolean isPresentinNode(TreeNode root, TreeNode key)
    {
        if(root==null)
            return false;
        if(root==key)
            return true;
        boolean left = isPresentinNode(root.left,key);
        boolean right = isPresentinNode(root.right,key);
        return left||right;
    }
}
