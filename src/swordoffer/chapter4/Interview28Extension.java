package swordoffer.chapter4;

import java.util.ArrayList;

public class Interview28Extension {
    public static void main(String[] args){
        char[] str = {'a','b'};
        Interview28Extension ii = new Interview28Extension();
        ArrayList<Character> result = new ArrayList<>();
        for (int i = 1;i <= str.length;i++)
            ii.Combination(str,0,i,result);  //从数组中第一个字符开始，依次取num个，num >=1 && num <= 数组长度
    }
    /**
     * @param str    待排列组合的数组
     * @param begin  待取的下一个字符的在数组的起始位置索引
     * @param num    表示还需要取的字符的个数
     * @param result 保存每一种组合的字符
     */
    public void Combination(char[] str,int begin, int num, ArrayList<Character> result){
        if (str == null || str.length == 0)
            //注意：begin > str.length - 1这个条件不能放在这里一起判断
            // 因为有时候当num为0的时候，begin也满足begin>str.len-1，但是这时候我们已经在result中的字符是一种组合，应该保证先输出再返回
            return;
        if (num == 0){   //如果num为0,说明已经凑够了num个字符，直接输出并返回
            System.out.println(result);
            return;
        }
        if (begin > str.length-1)
            return;
        result.add(str[begin]);    //当前的字符被选中
        Combination(str,begin+1,num-1,result);   //则从索引位置为begin+1的位置开始选择剩下的num-1个字符
        result.remove(result.size()-1);    //当前的字符未被选中
        Combination(str,begin+1,num,result);   //则从索引位置为begin+1的位置继续选择num个字符
    }
}
