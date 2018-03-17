package swordoffer.chapter7;

/**
 * 普通的树，但是有指向父结点的引用
 * 那么这种情况下就可以看作是两个单向链表的第一个交点即两个结点的最低公共父结点
 * 求两个单向链表的交点：
 * 1.首先分别求出两个链表的长度
 * 2.相对长的链表先遍历多出来的长度的结点
 * 3.然后两个链表同时遍历，那么会同时指向的第一个相同的结点即是两个链表的第一个相交点
 */
class TreeNode2 {
    TreeNode2 parent;
    int val;
}
public class LastCommonParent_2 {
    public TreeNode2 GetLastCommonNode(TreeNode2 root, TreeNode2 n1, TreeNode2 n2){
        TreeNode2 curr1 = n1;
        TreeNode2 curr2 = n2;
        int len1 = 0;
        int len2 = 0;
        while(curr1 != null && curr2 != null){
            len1++;
            len2++;
            curr1 = curr1.parent;
            curr2 = curr2.parent;
        }
        while (curr1 != null){
            len1++;
            curr1 = curr1.parent;
        }
        while(curr2 != null){
            len2++;
            curr2 = curr2.parent;
        }
        curr1 = n1;
        curr2 = n2;
        if (len1 > len2){
            int diff = len1-len2;
            while(diff > 0){
                curr1 = curr1.parent;
                diff--;
            }
        }else if(len1 < len2){
            int diff = len2 - len1;
            while(diff > 0){
                curr2 = curr2.parent;
                diff -- ;
            }
        }
        while(curr1 != null && curr2 != null && curr1 != curr2){
            curr1 = curr1.parent;
            curr2= curr2.parent;
        }
        return curr1;
    }
}
