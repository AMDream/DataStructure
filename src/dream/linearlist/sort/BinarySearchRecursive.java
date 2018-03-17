package dream.linearlist.sort;

/**
 * Created by Dream on 2018/3/13.
 */
public class BinarySearchRecursive {
    public static void main(String[] args){
        int[] num = {1,3,5,7,9,12,14,16,17};
        int index = BinarySearchRecursive.BinarySearch(num,0,num.length-1,4);
        System.out.println(index);
    }

    /**
     * 二分查找的递归算法
     * @param num
     * @param begin
     * @param end
     * @param key
     * @return
     */
    public static int BinarySearch(int[] num,int begin,int end,int key){
        int index = -1;
        if (begin > end)
            return index;
        int middle = (begin+end)/2;
        if (key > num[middle])
            index = BinarySearch(num,begin+1,end,key);
        else if(key < num[middle])
            index = BinarySearch(num,begin,end-1,key);
        else
            index = middle;
        return index;
    }
}
