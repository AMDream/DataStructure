package dream.linearlist.tree;

import java.util.Arrays;

public class MaxHeap {
    public static void main(String []args){
        int []arr = {1,2,3,4,5,6,7,8,9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] num){
        for(int i = (num.length-1)/2;i>=0;i--){
            //从第一个非叶子结点开始调整
            adjustHeap(num,i,num.length);
        }
    }
    /**
     * 调整大顶堆，建立在大顶堆建立的基础上.从父结点向下交换遍历
     * @param num
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] num,int i,int length){
        int temp = num[i];  //取出当前元素i
        for (int k = 2*i+1;k<length;k=2*k+1){
            if (k+1 < length && num[k] < num[k+1])
                k++;
            if (num[k] > temp) {  //左右结点中的最大值大于父结点的值
                num[i] = num[k];
                i = k;  //i记录被换值的结点
            }else
                break;
        }
        num[i] = temp;
    }
}
