package swordoffer.chapter3;

/**
 * Created by Dream on 2018/3/8.
 */
public class Interview12AnotherSolution {
    public static void main(String[] args){
        Interview12AnotherSolution i12s = new Interview12AnotherSolution();
        i12s.Print1T0MaxOfDigits(2);
    }
    public void Print1T0MaxOfDigits(int n){
        if (n <= 0)
            return;
        int[] num = new int[n];
        for (int i=0;i<10;i++){
            num[0] = i;
            PrintRecursive(num,n,0);
        }
    }
    private void PrintRecursive(int[] num,int len,int index){
        if (index == len - 1){
            PrintNumber(num);
            return;
        }
        for (int i=0;i<10;i++){
            num[index + 1] = i;
            PrintRecursive(num,len,index+1);
        }
    }
    private void PrintNumber(int[] num){
        boolean isBeginning0 = true;
        int len = num.length;
        for (int i=0;i<len;i++){
            if (isBeginning0 && num[i] != 0)
                isBeginning0 = false;
            if (!isBeginning0)
                System.out.print(num[i]);
        }
        System.out.println();
    }
}
