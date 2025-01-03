class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1=new ArrayList<>();
        ArrayList<TreeNode> path2=new ArrayList<>();
        if(!ancestor(root,p,path1)||!ancestor(root,q,path2)){
            return null;
        }
        int i=0;
        while(i<path1.size()&&i<path2.size()&&path1.get(i)==path2.get(i)){
        i++;
        }
        return path1.get(i-1);

        
    }
    public boolean ancestor(TreeNode root,TreeNode target,ArrayList<TreeNode> a){
        if(root==null){
            return false;
        }
        a.add(root);
        if(root==target){
            return true;
        }
        boolean left=ancestor(root.left,target,a);
        boolean right=ancestor(root.right,target,a);
        if(left||right){
            return true;
        }
        a.remove(a.size()-1);
        return false;
    }
}