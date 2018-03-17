package jvm.chapter2;

/**
 * Created by Dream on 2018/3/5.
 */
public class StringTest {
    public static void main(String[] args){
        String str1 = "abc";
        String str2 = new String("abc");
        System.out.println(str1 == str2);
        System.out.println("******************************");
        str2 = str2.intern();
        System.out.println(str1 == str2);
    }
}
