package swordoffer.chapter2;

/**
 *
 */
public class SortAlgorithm {
    public int partition(int[] arr,int start,int end){
        //以最后的元素作为基准
        int base = arr[end];
        while(start < end){
            //左边开始遍历，如果比基准值小，就继续往后走
            while(start < end && arr[start] <= base)
                start++;
            //上面的while循环结束就意味着arr[start]比基准值大，则需要两个交换位置
            if (start < end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = arr[start];
                end --; //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值右边)，因此右边也要同时向前移动一位
            }
            //从右边开始遍历，如果比基准值大，就继续往前走
            while (start < end && arr[end] >=base)
                end --;
            //上面while循环的结束就意味着arr[end]比基准值小，则需要交换位置
            if(start < end){
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
                start ++;  //交换后，此时被调换的值回到了正确的位置（基准值左边），因此左边要向后移动一位
            }
        }
        //返回start和end都一样，因为两个都指向基准值的位置
        return start;
    }
    public void sort(int[] arr,int start,int end){
        if (start > end || start == end) //表示没有元素或者有一个元素，则无需再排序，直接返回
            return;
        else {
            //每一次partition函数的调用，则将序列根据基准值分为两个序列，左边序列均小于基准值，右边序列均大于基准值
            int part = this.partition(arr,start,end);
            sort(arr,start,part-1);
            sort(arr,part+1,end);
        }
    }

    /**
     * 剑指offer年龄排序问题
     * 时间效率O(n)
     * @param ages
     * @param length
     */
    public void SortAges(int[] ages,int length){
        int[] timesOfAge = new int[100];
        for (int i = 0;i<length;i++){
            timesOfAge[ages[i]]++;
        }
        int index = 0;
        for (int i = 0;i <= 99;i ++){  //年龄
            for (int j = 0;j < timesOfAge[i];j ++){
                ages[index] = i;
                index ++;
            }
        }
    }
}
