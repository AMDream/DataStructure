package swordoffer.chapter3;

import java.util.Arrays;

/**
 * Created by Dream on 2018/3/8.
 */
public class Interview14 {
    public static void main(String[] args){
        Interview14 i14 = new Interview14();
        int[] array = new int[]{1,3,5,7,9,2,4,6,8,10};
        i14.reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
    public void reOrderArray(int [] array) {
        int start = 0,end = array.length - 1;
        while(start < end){
            while(start < end && array[start]%2 == 1)  //找到前面第一个偶数
                start ++;
            while(start < end && array[end]%2 == 0) //找到后面的第一个奇数
                end --;
            if(start < end){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }
    }
}
