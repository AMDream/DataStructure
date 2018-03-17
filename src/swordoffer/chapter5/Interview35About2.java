package swordoffer.chapter5;

/**
 * Created by Dream on 2018/3/14.
 */
public class Interview35About2 {
    public static void main(String[] args){
        String str = "google";
        String result = Interview35About2.DeleteDuplicateCharacter(str);
        System.out.println(result);
    }

    /**
     * 删除字符串中所有重复出现的字符
     * @param str
     * @return
     */
    public static String DeleteDuplicateCharacter(String str){
        if (str == null || str.length() == 0)
            return "";
        boolean[] exist = new boolean[256];
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if (exist[c] == false){  //表示该字符第一次出现
                sb.append(c);
                exist[c] = true;   //置为true，表示已经出现过
            }
        }
        return sb.toString();
    }
}
