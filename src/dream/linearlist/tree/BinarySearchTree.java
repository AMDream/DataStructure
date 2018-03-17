package dream.linearlist.tree;

/**
 * Created by Dream on 2018/3/13.
 */
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}
public class BinarySearchTree {
    /**
     * 查找二叉树的非递归实现
     * @param root
     * @param elem
     * @return
     */
    public TreeNode Find(TreeNode root,int elem){
        while(root != null){
            if (elem > root.val)
                root = root.right;
            else if (elem < root.val)
                root = root.left;
            else
                return root;
        }
        return null;
    }
    /**
     * 查找二叉树的递归实现
     * @param root
     * @param elem
     * @return
     */
    public TreeNode FindRecursive(TreeNode root,int elem){
        if (root == null)
            return null;
        if (elem > root.val)
            return  FindRecursive(root.right,elem);
        else if(elem < root.val)
            return  FindRecursive(root.left,elem);
        else
            return root;
    }
    /**
     * 插入结点的非递归实现
     * @param root
     * @param elem
     */
    public void InsertNode(TreeNode root,int elem){
        if (root == null)
            return;
        TreeNode prev = null,curr = root;
        while(curr != null){
            if(elem > curr.val){
                prev = curr;
                curr = curr.right;
            }else if(elem < curr.val){
                prev = curr;
                curr = curr.left;
            }else{
                System.out.println("结点已存在！");
                return;
            }
        }
        if (elem > prev.val){
            prev.right = new TreeNode(elem);
        }else{
            prev.left = new TreeNode(elem);
        }
    }
    /**
     * 插入结点的递归实现
     * @param bst
     * @param elem
     * @return
     */
    public TreeNode InsertNodeRecursive(TreeNode bst,int elem){
        if (bst == null){
            bst = new TreeNode(elem);
        }
        if (elem > bst.val)
            bst.right = InsertNodeRecursive(bst.right,elem);
        else if(elem < bst.val)
            bst.left = InsertNodeRecursive(bst.left,elem);
        return bst;
    }
    /**
     * 删除结点：
     * @param root
     * @param elem
     * @return
     */
    public TreeNode deleteNode(TreeNode root,int elem){
        TreeNode temp = null;
        if (root == null)
            return null;
        else if (elem > root.val){
            root.right = deleteNode(root.right,elem);
        }else if(elem < root.val)
            root.left = deleteNode(root.left,elem);
        else{  //找到了该结点
            if (root.left != null && root.right != null){     //左右子树均不为空
                temp = FindMinNode(root);  //找到右子树中的最小值
                root.val = temp.val;       //将最小值赋给当前结点，然后删除右子树中的最小结点值（保证该结点是没有左孩子结点的）
                root.right = deleteNode(root.right,root.val);
            }else{     //左右子树至少有一为空
                if(root.left != null){
                    root = root.left;
                }else{
                    root = root.right;
                }
            }
        }
        return root;
    }
    /**
     * 寻找最小结点，也就是最左叶子结点
     * @param root
     * @return
     */
    public TreeNode FindMinNode(TreeNode root){
        TreeNode curr = root;
        while(curr != null && curr.left != null){
            curr = curr.left;
        }
        return curr;
    }
    /**
     * 寻找最大结点，也就是最右叶子结点
     * @param root
     * @return
     */
    public TreeNode FindMaxNode(TreeNode root){
        if (root == null)
            return null;
        else if (root.right == null)   //找到最大右结点并返回
            return root;
        else
            return FindMaxNode(root.right);
    }
}
