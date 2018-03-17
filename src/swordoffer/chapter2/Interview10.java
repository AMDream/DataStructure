package swordoffer.chapter2;

/**
 * Created by Dream on 2018/3/8.
 */
public class Interview10 {
    int numberOf1(int n){
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if((n & flag) == flag)
                count++;
            flag = flag << 1;
        }
        return count;
    }
    public static void main(String[] args){
        Interview10 i10 = new Interview10();
        int n = 10;
        int result = i10.numberOf1(n);
        System.out.println(result);
        double d1,d2;
        d1 = 3.1415;
        d2 = 3.14151;
        System.out.println(d1 == d2);
    }
}
