package swordoffer.chapter5;

import java.util.HashMap;

public class Interview35About1 {
    public static void main(String[] args){
        String s1 = "We are students";
        String s2 = "aeiou";
        String result = Interview35About1.DeleteInAnotherString(s1,s2);
        System.out.println(result);
    }

    /**
     * 删除字符串s1中在s2出现的字符
     * @param s1
     * @param s2
     * @return
     */
    public static String DeleteInAnotherString(String s1,String s2){
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0;i<s2.length();i++){
            char c = s2.charAt(i);
            if(map.containsKey(c)){
                int value = map.get(c);
                map.put(c,value+1);
            }else
                map.put(c,1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s1.length();i++){
            char c = s1.charAt(i);
            if (!map.containsKey(c))
                sb.append(c);
        }
        return sb.toString();
    }
}
