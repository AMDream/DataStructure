package swordoffer.chapter5;

/**
 * Created by Dream on 2018/3/14.
 */
public class Interview35About3 {
    public static void main(String[] args){
        String s1 = "live";
        String s2 = "lively";
        System.out.println(Interview35About3.isAnagram(s1,s2));
    }
    public static boolean isAnagram(String s1,String s2){
        int[] array = new int[256];
        for(int i = 0;i<s1.length();i++){
            array[s1.charAt(i)]++;
        }
        for(int i=0;i<s2.length();i++){
            array[s2.charAt(i)]--;
        }
        for (int i=0;i<array.length;i++){
            if (array[i] != 0)
                return false;
        }
        return true;
    }
}
