package swordoffer.chapter2;

/**
 * 使用同步代码块解决了上述的线程安全问题
 */
public class Singleton3 {
    private Singleton3 instance = null;
    private Singleton3(){}
    public Singleton3 getInstance(){
        synchronized (this){
            if (instance == null)
                instance = new Singleton3();
        }
        return instance;
    }
}
