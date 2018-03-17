package dream.linearlist.stack;

/**
 * 输入中缀表达式，得到后缀表达式
 * 思路：
 * (1）初始化一个运算符栈
 （2）从算术表达式输入的字符串中，从左到右的读取一个字符
 （3）若当前的 字符是操作数，则直接送往后缀表达式
 （4）若当前的字符是左括号，则将其压入运算符栈
 （5）若当前的字符是操作符，则进行如下 操作：
    ①当运算符栈为空时，直接将其压入栈。
    ②当此运算符的优先级高于栈顶的运算符时，则将此运算符压入栈，否则，弹出栈顶运算符送往后缀式，并将当前运算符压栈，重复步骤（5）
 （6）若当前字符是右括号，反复将栈顶符号弹出，并送往后缀表达式中，知道栈顶元素为左括号为止，然后将左括号出栈并丢弃
 （7）若读取还未结束，则重复步骤（2）
 （8）若读取结束，则将栈中剩余的所有的运算符弹出并送往后缀表达式
 */
public class StackApplication {
    /**
     * 如果是计算符，则返回true
     */
    private boolean isOperator(char c){
        if(c == '+' || c == '-' || c== '*' || c == '/' || c == '%' || c == '^'){
            return true;
        }
        return false;
    }

    /**
     * 如果是右括号，返回true
     */
    private boolean isOpenRight(char c){
        return ')' == c;
    }

    /**
     * 如果是左括号，返回true
     */
    private boolean isOpenLeft(char c){
        return '(' == c;
    }

    /**
     * 返回运算符的优先级，括号的优先级最低
     */
    private int priority(char c){
        switch (c){
            case '^':return 3;
            case '*':
            case '/':
            case '%':
                return 2;
            case '+':
            case '-':
                return 1;
        }
        return 0;
    }

    /**
     * @param express  输入的中缀表达式
     * @return  后缀表达式
     */
    public String cover2PostSuffix(String express){
        LinkStack ls = new LinkStack();
        String postFix = "";
        for(int i=0;express != null && i<express.length();i++){
            char c = express.charAt(i);
            if(' ' != c){  //字符不能为空
                if(this.isOpenLeft(c)){  //左括号入栈
                    ls.push(c);
                }else if(this.isOpenRight(c)){  //右括号则把左括号之前的全部弹出
                    char o = (char)ls.pop();
                    while(!isOpenLeft(o)){
                        postFix += o ;
                        o = (char)ls.pop();
                    }
                }else if(isOperator(c)){
                    //如果是操作符
                    //1.栈为空，则入栈 2.不为空，则需要栈顶的运算符与当前运算符比较优先级，一直弹出直到当前运算符优先级大于栈顶优先级
                    if(!ls.isEmpty()){
                        Object o = ls.pop();
                        while(o != null && (priority((char)o) > priority(c))){
                            postFix += (char)o;
                            o = ls.pop();
                        }
                        if(o != null) // 将最后一次取出的优先级低的运算符入栈
                            ls.push(o);
                    }
                    ls.push(c);
                }else{   //操作数，直接添加到后缀表达式中
                    postFix += c;
                }
            }
        }
        while(!ls.isEmpty()){
            postFix += ls.pop();
        }
        return postFix;
    }

    /**
     * 根据传入的后缀表达式，计算其值
     */
    public double numberCalculate(String postFix){
        LinkStack ls = new LinkStack();
        for(int i=0;postFix != null && i<postFix.length();i++){
            char c = postFix.charAt(i);
            if(' '!= c){
                if(isOperator(c)){  //操作符则取出操作数计算
                    double d2 = Double.valueOf(ls.pop().toString());
                    double d1 = Double.valueOf(ls.pop().toString());
                    double d3 = 0;
                    switch (c){
                        case '+':d3 = d1 + d2;break;
                        case '-':d3 = d1 - d2;break;
                        case '*':d3 = d1 * d2;break;
                        case '/':d3 = d1/d2;break;
                        case '%':d3 = d1%d2;break;
                        case '^':d3 = Math.pow(d1,d2);break;
                        default:break;
                    }
                    //计算结果压栈
                    ls.push(d3);
                }else{  //数字则入栈
                    ls.push(c);
                }
            }
        }
        return (double)ls.pop();
    }
    public static void main(String[] args){
        StackApplication sa = new StackApplication();
        String result = sa.cover2PostSuffix("3*(2+6)/6");
        System.out.println(result);
        double value = sa.numberCalculate(result);
        System.out.println("计算结果："+value);
    }
}
