package swordoffer.chapter7;

import java.util.List;

/**
 * 普通的树，而且没有指向父结点的引用
 * 1.首先获得根节点到目标结点的路径
 * 2.然后判断两个路径的最后公共结点
 */
class TreeNode3{
    int data;   //表头结点中保存了结点的值
    ChildNode firstChild;
}
class ChildNode{
    ChildNode next;
    int child;   //孩子的结点索引位置
}
class Tree{
    TreeNode3[] tree;
    public Tree(int size){
        tree = new TreeNode3[size];
    }
}
public class LastCommonParent_3 {

}
