package swordoffer.chapter7;

/**
 * 二叉排序树:
 * 将当前的结点值与两个结点进行比较
 * 1.如果当前结点的值大于两个结点，那么两个结点的最低公共父结点一定是在当前节点的左子树中
 * 2.如果当前结点的值小于两个结点，那么两个结点的最低公共父结点一定是在当前结点的右子树中
 * 3.如果当前结点的值在两个输入结点的值之间，那么该结点就是最低的公共结点
 */
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}
public class LastCommonParent_1 {
    public TreeNode GetLastCommonParent(TreeNode root,TreeNode n1,TreeNode n2){
        TreeNode curr = root;
        while(curr != null){
            int currVal = curr.val;
            if (currVal > n1.val &&currVal > n2.val){
                curr = curr.left;
            }else if(currVal < n1.val && currVal < n2.val)
                curr = curr.right;
            else
                return curr;
        }
        return null;
    }
}
