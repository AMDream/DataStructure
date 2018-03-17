package swordoffer.chapter4;

import java.util.ArrayList;
import java.util.Arrays;

public class Interview28About1 {
    public static void main(String[] args){
        Interview28About1 i = new Interview28About1();
        ArrayList<String> list = new ArrayList<>();
        int[] num = {1,2,3,4,5,6,7,8};
        i.isEightPoint(num,list);
    }
    public void isEightPoint(int[] num,ArrayList<String> list){
        if (num == null)
            return;
        Permutation(num,0,list);
    }
    private void Permutation(int[] num,int begin,ArrayList<String> list){
        int end = num.length - 1;
        if (begin == end) {
            int a1 = num[0],a2 = num[1],a3=num[2],a4=num[3],a5 = num[4],a6 = num[5],a7 = num[6],a8 = num[7];
            if (list.contains(Arrays.toString(num))) {
                if ((a1 + a2 + a3 + a4 == a5 + a6 + a7 + a8) && (a1 + a3 + a5 + a7 == a2 + a4 + a6 + a8) && (a1 + a2 + a5 + a6 == a3 + a4 + a7 + a8))
                    list.add(Arrays.toString(num));
                return;
            }
        }
        for(int i = begin;i<= end;i++){
            int temp = num[begin];
            num[begin] = num[i];
            num[i] = temp;
            Permutation(num,begin+1,list);
            temp = num[begin];
            num[begin] = num[i];
            num[i] = temp;
        }
    }
}
