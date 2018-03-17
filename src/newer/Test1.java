package newer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dream on 2018/3/6.
 */
public class Test1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] s = str.split(" ");
        int[] num = new int[s.length-1];
        for(int i = 0;i<s.length-1;i++){
            num[i] = Integer.parseInt(s[i]);
        }
        int k = Integer.parseInt(s[s.length-1]);
        int begin = 0;
        int end = num.length-1;
        int index = partition(num,begin,end);
        System.out.println(index);
        System.out.println("Before"+Arrays.toString(num));
        while(index != k){
            if(index < k){
                begin = index+1;
                index = partition(num,begin,end);
            }
            else{
                end = index-1;
                index = partition(num,begin,end);
            }
        }
        System.out.println("After"+Arrays.toString(num));
        for(int i=0;i<k;i++)
            System.out.print(num[i]+" ");
        System.out.println();
    }
    private static int partition(int[] num,int begin,int end){
        int base = num[end];
        while(begin < end){
            while(begin<end && num[begin] <= base)
                begin++;
            if(begin < end){
                int temp = num[begin];
                num[begin] = num[end];
                num[end] = temp;
            }
            while(begin < end && num[end] >= base)
                end--;
            if(begin < end){
                int temp = num[end];
                num[end] = num[begin];
                num[begin] = temp;
            }
        }
        return begin;
    }
}
