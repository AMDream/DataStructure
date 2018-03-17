package dream.linearlist.stack;

/**
 * Created by Dream on 2018/2/28.
 */
public class LinkStackMain {
    public static void main(String[] args){
        LinkStack ls = new LinkStack();
        System.out.println("栈ls是否为空："+ls.isEmpty());
        ls.push(2);
        ls.push(3);
        ls.push(5);
        ls.push(7);
        System.out.println("弹出的元素是："+ls.pop());
        System.out.println("弹出的元素是："+ls.pop());
        System.out.println("弹出的元素是："+ls.pop());
        System.out.println("弹出的元素是："+ls.pop());
        System.out.println("栈as是否为空："+ls.isEmpty());
    }
}
