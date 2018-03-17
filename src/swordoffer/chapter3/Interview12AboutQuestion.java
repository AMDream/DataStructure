package swordoffer.chapter3;

import java.util.Arrays;

/**
 * Created by Dream on 2018/3/8.
 */
public class Interview12AboutQuestion {
    public static void main(String[] args){
        int[] a1 = new int[]{9,9,9};
        int[] a2 = new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        Interview12AboutQuestion i12 = new Interview12AboutQuestion();
        int[] result = i12.TwoBigDigitalAdd(a1,a2);
        i12.PrintNumber(result);
    }
    public void PrintNumber(int[] num){
        boolean isBeginning0 = true;
        for (int i=0;i<num.length;i++){
            if (isBeginning0 && num[i] != 0)
                isBeginning0 = false;
            if (!isBeginning0)
                System.out.print(num[i]);
        }
        System.out.println();
    }
    public int[] TwoBigDigitalAdd(int[] a1,int[] a2){
        int maxSize = Math.max(a1.length,a2.length)+1;   //两个数相加，位数最多为最大位数的位数+1
        int[] num = new int[maxSize];
        int nTakeOver = 0;    //是否进位
        int m = a1.length-1,n = a2.length-1;
        for (int i=maxSize-1;i>=0;i--){
            int nSum = nTakeOver;
            if(m >= 0 && n>= 0){
                nSum = nSum + a1[m] +a2[n];
                m--;
                n--;
            }else if(m >= 0){
                nSum += a1[m] ;
                m--;
            }else if (n >= 0){
                nSum += a2[n];
                n--;
            }
            if (nSum >= 10){
                nSum -= 10;
                nTakeOver = 1;
                num[i] = nSum;
            }else{
                num[i] = nSum;
            }
        }
        return num;
    }
}
