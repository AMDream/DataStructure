package swordoffer.chapter4;

import java.util.ArrayList;
import java.util.Arrays;

public class Interview28About2 {
    public static void main(String[] args){
        Interview28About2 i = new Interview28About2();
        ArrayList<String> list = new ArrayList<>();
        int[] queen = {0,1,2,3,4,5,6,7};
        i.EightQueen(queen,list);
        System.out.println(list.size());
    }
    public void EightQueen(int[] queen,ArrayList<String> list){
        Permutation(queen,0,list);
    }
    private void Permutation(int[] queen,int begin,ArrayList<String> list){
        if (begin == queen.length - 1){
            for (int i=0;i < queen.length;i++){
                for (int j =i + 1;j < queen.length;j++){
                    if ((i - j == queen[i] - queen[j]) ||(j - i == queen[i] - queen[j]))
                        return;
                }
            }
            list.add(Arrays.toString(queen));
            return;
        }
        for (int i = begin;i < queen.length;i++){
            int temp = queen[begin];
            queen[begin] = queen[i];
            queen[i] = temp;
            Permutation(queen,begin+1,list);
            temp = queen[begin];
            queen[begin] = queen[i];
            queen[i] = temp;
        }
    }
}
