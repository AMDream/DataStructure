package jvm.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 应该报错java.lang.OutOfMemoryError:PermGen space
 * 但是报错：
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 at java.lang.Integer.toString(Integer.java:401)
 at java.lang.String.valueOf(String.java:3099)
 at jvm.chapter2.RuntimeConstantPoolOOM.main(RuntimeConstantPoolOOM.java:15)
 Java HotSpot(TM) Client VM warning: ignoring option PermSize=10M;-XX:MaxPermSize=10M; support was removed in 8.0
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args){
        //使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list= new ArrayList<>();
        int i = 0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
