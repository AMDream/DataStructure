package dream.linearlist.stack;

/**
 * Created by Dream on 2018/2/28.
 */
public class ArrStackMain {
    public static void main(String[] args){
        ArrStack as = new ArrStack(10);
        System.out.println("栈as是否为空："+as.isEmpty());
        as.push(2);
        as.push(3);
        as.push(5);
        as.push(7);
        System.out.println("弹出的元素是："+as.pop());
        System.out.println("弹出的元素是："+as.pop());
        System.out.println("弹出的元素是："+as.pop());
        System.out.println("弹出的元素是："+as.pop());
        System.out.println("栈as是否为空："+as.isEmpty());
    }
}
