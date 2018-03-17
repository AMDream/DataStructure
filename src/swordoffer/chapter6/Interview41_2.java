package swordoffer.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Interview41_2 {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> ls = FindContinuousSequence(9);
        System.out.println(ls);
    }
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int small = 1,big = 2;
        ArrayList<ArrayList<Integer>> ls = new ArrayList<ArrayList<Integer>>();
        if(sum <= 2)
            return ls;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> temp;
        list.add(small);
        list.add(big);
        int nSum = small+big;
        while(small < (sum+1)/2){
            if(nSum > sum){
                nSum -= small;
                list.remove((Object)small);
                small--;
            }else if(nSum < sum){
                big++;
                nSum += big;
                list.add(big);
            }else{
                ls.add(list);
                small = list.get(0);
                nSum -= small;
                temp = new ArrayList<>(Arrays.asList(new Integer[list.size()]));
                Collections.copy(temp,list);
                list = temp;
                list.remove((Object)small);
                small++;
            }
        }
        return ls;
    }
}
