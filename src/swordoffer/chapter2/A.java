package swordoffer.chapter2;

/**
 * Created by Dream on 2018/3/6.
 */
public class A {
    private int value;
    public A(A other){
        value = other.value;
    }
    public A(int value){
        this.value = value;
    }
    public void print(){
        System.out.println(value);
    }
    public static void main(String[] args){
        A a = new A(3);
        A b = new A(a);
        b.print();
    }
}
