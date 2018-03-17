package swordoffer.chapter3;

/**
 * Created by Dream on 2018/3/8.
 */
public class Interview12 {
    public static void main(String[] args){
        Interview12 i12 = new Interview12();
        i12.Print1ToMaxOfNDigits(2);
    }
    public void Print1ToMaxOfNDigits(int n){
        if(n <= 0)
            return;
        int[] num = new int[n];
        while (!Increasement(num)){
            PrintNumber(num);
        }
    }
    private boolean Increasement(int[] num){
        boolean isOverflow = false;
        int nTakeOver = 0;
        int len = num.length;
        for(int i = len - 1;i >= 0;i --){
            int nSum = num[i] + nTakeOver; //先加进位
            if(i == len - 1)
                nSum ++;
            if (nSum >= 10){
                if (i == 0)
                    isOverflow = true;
                else{
                    nSum -= 10;
                    nTakeOver = 1;
                    num[i] = nSum;
                }
            }else{  //不进位，则+1后直接退出
                num[i] = nSum;
                break;
            }
        }
        return isOverflow;
    }
    private void PrintNumber(int[] num){
        boolean isBeginning0 = true;
        for (int i = 0;i < num.length;i ++){
            if(isBeginning0 && num[i] != 0)
                isBeginning0 = false;
            if(!isBeginning0)
                System.out.print(num[i]);
        }
        System.out.println();
    }
}
