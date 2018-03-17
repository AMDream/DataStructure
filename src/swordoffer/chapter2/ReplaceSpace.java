package swordoffer.chapter2;

/**
 * 空格替换为%20，自然是不能使用repalceAll()方法，否则一句话搞定...
 */
public class ReplaceSpace {
    public static String replaceSpace(String str){
        if (str == null)
            return null;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i< str.length();i++){
            if(str.charAt(i) == ' '){
                sb.append("%");
                sb.append("2");
                sb.append("0");
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 如果限制只能在原字符数组上进行操作，则从后往前移动字符，时间复杂度O(n)
     * @param input
     * @return
     */
    public static String replaceBank(char[] input){
        int count = 0;
        for(int i=0;i<input.length;i++){
            if (input[i] == ' ')
                count++;
        }
        //首先计算替换为%20后的字符串长度
        char[] output = new char[input.length+count*2];
        int p1 = input.length-1;
        int p2 = output.length-1;
        while(p1 >=0 && p2 >= 0){
            if(input[p1] == ' '){
                output[p2--] = '0';
                output[p2--] = '2';
                output[p2--] = '%';
                p1--;
            }else {
                output[p2] = input[p1];
                p2--;
                p1--;
            }
        }
        return String.valueOf(output);
    }
    public static void main(String[] args){
        String str = "We are h";
        String result = ReplaceSpace.replaceBank(str.toCharArray());
        System.out.println(result);
    }
}
