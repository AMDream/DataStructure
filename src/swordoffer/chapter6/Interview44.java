package swordoffer.chapter6;

import java.util.Arrays;

/**
 * Created by Dream on 2018/3/14.
 */
public class Interview44 {
    public static void main(String[] args){
        int[] num = {2,3,4,1,5};
        System.out.println(isContinuous(num));
    }
    public static boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length <= 5)
            return false;
        Arrays.sort(numbers);
        int count0 = 0;
        int countNo0 = 0;
        for(int i = 0;i < numbers.length-1;i++){
            if(numbers[i] == 0){
                count0++;
            }else{
                if(numbers[i+1] - numbers[i] == 0){
                    return false;
                }else
                    countNo0++;
            }
        }
        if(count0 + countNo0 == 4)
            return true;
        return false;
    }
}
