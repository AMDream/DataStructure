package swordoffer.chapter2;

import java.util.Arrays;

/**
 * Created by Dream on 2018/3/7.
 */
public class Test4Extention {
    public static int[] sortedArray(int[] a1,int[]a2){
        int p1 = 0;
        for (int i =0;i<a1.length;i++){
            if (a1[i] == 0) {
                p1 = i-1;
                break;
            }
        }
        int p2 = a2.length-1;
        int total = p1+p2+1;
        while(p2 >=0){
            if(a1[p1]>a2[p2]){
                a1[total] = a1[p1];
                p1--;
                total--;
            }else if(a1[p1] < a2[p2]){
                a1[total] = a2[p2];
                p2--;
                total--;
            }else {
                a1[total--] = a1[p1];
                a1[total--] = a1[p1];
                p1--;
                p2--;
            }
        }
        return a1;
    }
    public static void main(String[] args){
        int[] a1 = new int[10];
        a1[0] = 1;
        a1[1] = 3;
        a1[2] = 5;
        a1[3] = 7;
        a1[4] = 9;
        int[] a2 = new int[]{2,3,6};
        a1 = Test4Extention.sortedArray(a1,a2);
        System.out.println(Arrays.toString(a1));
    }
}
