package swordoffer.chapter6;

import java.util.Arrays;

/**
 * Created by Dream on 2018/3/14.
 */
public class Interview41 {
    public static void main(String[] args){
        int[] arr = {1,2,4,7,11,15};
        System.out.println(Arrays.toString(FindSumInArray(arr,15)));
    }
    public static int[] FindSumInArray(int[] arr,int sum){
        int begin = 0;
        int end = arr.length-1;
        int[] result = new int[2];
        while(begin < end){
            int nSum = arr[begin]+arr[end];
            if(nSum > sum){
                end--;
            }else if(nSum < sum)
                begin++;
            else{
                result[0] = arr[begin];
                result[1] = arr[end];
                return result;
            }
        }
        return result;
    }
}
