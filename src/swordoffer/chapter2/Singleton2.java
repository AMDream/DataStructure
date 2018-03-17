package swordoffer.chapter2;

/**
 * 由于第一种方式的缺陷，我们就想那就在用户需要的时候再生成对象的实例
 * 但是这种实现方式会有线程安全问题，可能生成的并不是单例对象
 */
public class Singleton2 {
    private Singleton2 instance = null;
    private Singleton2(){}
    public Singleton2 getInstance(){
        if (instance == null)
            instance = new Singleton2();
        return instance;
    }
}
