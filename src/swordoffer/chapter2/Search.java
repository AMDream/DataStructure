package swordoffer.chapter2;

/**
 * Created by Dream on 2018/3/7.
 */
public class Search {
    /**
     * 顺序查找：最笨也是最容易想到的查找算法
     * 思想：从表中的第一个元素或者最后一个元素，逐个将表中的记录与关键字进行比较，
     * 如果相等，则查找成功；如果表中所有记录与关键字都不同，则查找失败
     * 时间复杂度O(n)
     * @param des
     * @param key
     * @return
     */
    public boolean orderSearch(int[] des,int key) {
        for (int i = 0; i < des.length; i++){
            if (key == des[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 二分查找：前提是待查找的序列有序
     * 思路：每次都是取序列的中间值与关键字进行比较，每一次比较都可以将待查找的序列的范围缩小，从而判定是否查找成功
     * 时间复杂度O(log2N)
     * @param des
     * @param key
     * @return
     */
    public boolean binarySearch(int[] des,int key){
        int low = 0;
        int high = des.length - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if (key > des[mid]){
                low = mid+1;
            }else if(key < des[mid]){
                high = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }

    /**
     * 哈希查找，也称为散列查找
     * 利用开放地址法：
     * 如果两个数据元素的哈希值相同，则在哈希表中为后插入的数据元素另外选择一个表项。
     * 当程序查找哈希表时，如果没有在第一个对应的哈希表项中找到符合查找要求的数据元素，
     * 程序就会继续往后查找，直到找到一个符合查找要求的数据元素，或者遇到一个空的表项。　　
     * @param des
     * @param key
     * @return
     */
    public boolean hashSearch(int[] des,int key,int hashLen){
        int hashAddr = key % hashLen;
        while(des[hashAddr] != 0 && des[hashAddr] != key)
            hashAddr = (hashAddr+1)%hashLen;
        if(des[hashAddr] == 0)
            return false;
        return true;
    }

    /**
     * 二叉排序树查找：每个非叶子节点最多只有两个结点，左孩子结点和右孩子结点，而且其左孩子结点的值一定小于其值，右孩子结点的值一定大于其值
     * 由于树就是一种递归的数据结构，所以完全可以利用递归去实现
     * 时间复杂度：O(log2n)  最坏情况O(n)-----比如一颗二叉排序树只有右孩子结点，本质上就是一个单向链表
     * @param root
     * @param key
     * @return
     */
    public boolean twoBinarySearchTree(TreeNode root,int key){
        if(root == null)
            return false;
        if (root.value == key)
            return true;
        else if(root.value > key)
            return twoBinarySearchTree(root.leftChild,key);
        else
            return twoBinarySearchTree(root.rightChild,key);
    }

    /**
     * 二叉排序树查找算法的非递归实现
     * 其实这种很像二分查找，甚至比二分查找还简单
     * 判断当前结点与关键字的大小，如果小于，则继续遍历该结点的左子树；如果大于，则遍历该结点的右子树；否则相等，查找成功
     * @param root
     * @param key
     * @return
     */
    public boolean twoBinarySearchTree2(TreeNode root,int key){
        TreeNode curr = root;
        while(curr != null){
            if(curr.value < key){
                curr = curr.rightChild;
            }else if(key < curr.value){
                curr = curr.leftChild;
            }else
                return true;
        }
        return false;
    }
}
class TreeNode{
    int value;
    TreeNode leftChild;
    TreeNode rightChild;
    public TreeNode(int value){
        this.value = value;
    }
}
