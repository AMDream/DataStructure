package swordoffer.chapter2;

/**
 * 缺点：在类加载的时候就生成了实例对象，如果用户不需要，则是一种资源的浪费
 */
public class Singleton1 {
    private static Singleton1 instance = new Singleton1();
    private Singleton1(){}
    public Singleton1 getInstance(){
        return instance;
    }
}
