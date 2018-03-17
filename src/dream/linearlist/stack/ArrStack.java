package dream.linearlist.stack;

/**
 * 栈：底层用数组实现
 */
public class ArrStack {
    private int top;
    private Object[] elem;
    private int maxSize;

    public ArrStack(int size){
        maxSize = size;
        top = -1;
        elem = new Object[maxSize];
    }
    public boolean isFull(){
        return top == maxSize-1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public void push(Object o){
        if(this.isFull()){
            System.out.println("栈满");
            return;
        }
        elem[++top] = o;
    }
    public Object pop(){
        if(this.isEmpty()){
            System.out.println("栈空");
            return null;
        }
        return elem[top--];
    }
    public Object peek(){
        if(this.isEmpty()){
            System.out.println("栈空");
            return null;
        }
        return elem[top];
    }
}
