package swordoffer.chapter6;

import java.util.Arrays;

/**
 * Created by Dream on 2018/3/14.
 */
public class Interview42_1 {
    public static void main(String[] args){
        String str = "I am a student.";
        ReverseSentence(str);
    }
    public static void ReverseSentence(String str){
        char[] ch = new char[str.length()];
        int t = 0;
        for(int i=str.length()-1;i>=0;i--){
            ch[t++] = str.charAt(i);
        }
        t = 0;
        int begin = 0;
        while(t < ch.length){
            if(ch[t] == ' ' || t == ch.length-1){
                Reverse(ch,begin,t-1);
                begin = t+1;
            }
            t++;
        }
        System.out.println(String.valueOf(ch));
    }
    public static void Reverse(char[] ch,int begin,int end){
        while(begin < end){
            char tem = ch[begin];
            ch[begin] = ch[end];
            ch[end] = tem;
            begin++;
            end--;
        }
    }
}
