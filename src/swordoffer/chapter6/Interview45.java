package swordoffer.chapter6;

/**
 * 约瑟夫换用数组实现
 */
public class Interview45 {
    public int LastRemain(int n,int m){
        if(n <= 0 || m <= 0)
            return -1;
        int[] arr = new int[n];
        int step = 0,count = n,i = -1;
        while(count > 0){
            i++;
            if(i >= n)
                i = 0;
            if(arr[i] == -1)
                continue;
            step++;
            if (step == m){
                step = 0;      //步数归0
                arr[i] = -1;   //删除的记为-1
                count --;     //总数-1
            }
        }
        return i;
    }
}
