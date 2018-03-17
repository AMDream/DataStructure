package jvm.chapter2;

/**
 * java.lang.StackOverflowError
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength ++;
        stackLeak();
    }
    public static void main(String[] args)throws Throwable{
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try{
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("Stack Length:"+oom.stackLength);
            throw e;
        }
    }
}
