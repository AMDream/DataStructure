package swordoffer.chapter4;

/**
 * Created by Dream on 2018/3/12.
 */
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}
public class Interview27 {
    private TreeNode lastNode = null;
    public static void main(String[] args){
        Interview27 i27 = new Interview27();
        TreeNode root = new TreeNode(10);
        i27.insertNode(root,6);
        i27.insertNode(root,14);
        i27.insertNode(root,4);
        i27.insertNode(root,8);
        i27.insertNode(root,12);
        i27.insertNode(root,16);
        i27.InOrderTraverse(root);
        System.out.println("-------------------------------------");
        i27.Convert(root);
    }
    public void InOrderTraverse(TreeNode root){
        if (root == null)
            return;
        InOrderTraverse(root.left);
        System.out.print(root.val+" ");
        InOrderTraverse(root.right);
    }
    public void insertNode(TreeNode root,int val){
        if (root == null)
            return;
        TreeNode curr = root;
        TreeNode prev = null;
        while(curr != null){
            if (val > curr.val){
                prev = curr;
                curr = curr.right;
            }else if(val < curr.val) {
                prev = curr;
                curr = curr.left;
            }
            else
                return;
        }
        TreeNode nNode = new TreeNode(val);
        if(nNode.val > prev.val)
            prev.right = nNode;
        else
            prev.left = nNode;
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return pRootOfTree;

        ConvertNode(pRootOfTree);
        while(lastNode != null && lastNode.left != null){
            lastNode = lastNode.left;
        }
        return lastNode;
    }
    private void ConvertNode(TreeNode root){
        if(root == null)
            return;
        TreeNode curr = root;
        if(curr.left != null){
            ConvertNode(curr.left);   //一直递归直到遍历到最左边的叶结点,从最左边的结点开始连接
        }
        curr.left = lastNode;
        if(lastNode != null)
            lastNode.right = curr;
        lastNode = curr;
        if(curr.right != null)
            ConvertNode(curr.right);
    }
}
