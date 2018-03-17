package dream.linearlist;
/**
 * 线性表的抽象数据类型描述
 */
public interface IList {
    boolean isEmpty();
    void clear();
    int length();

    //默认在末尾添加元素x
    void insert(Object x);
    //在第i个位置之前插入元素x
    void insert(int i,Object x);
    //移除第i个位置的元素并返回
    void remove(int i);

    //获取元素x的索引位置
    int indexOf(Object x);
    //获取第i个位置的元素
    Object get(int i);

    void display();
}
