package dream.linearlist.sequencelist;
import dream.linearlist.IList;
/**
 * 利用数组实现线性表
 * 注意：其中传入的参数i均表示位置，所以是从1开始，第i个位置的元素数组中的下标则为i-1
 */
public class SequenceList implements IList {
    private Object[] listElem;
    private int curlen;  //线性表当前长度

    public SequenceList(int maxSize){
        listElem = new Object[maxSize];
        curlen = 0;
    }
    @Override
    public boolean isEmpty() {
        return curlen == 0;
    }

    @Override
    public void clear() {
        curlen = 0;
    }

    @Override
    public int length() {
        return curlen;
    }

    @Override
    public void insert(Object x) {
        if(curlen == listElem.length){
            System.out.println("线性表已满，无法插入元素...");
        }
        listElem[curlen++] = x;
    }

    @Override
    public void insert(int i, Object x) {
        if(i < 1 || i > curlen){
            System.out.println("插入位置不合法，无法插入元素...");
        }
        if(curlen == listElem.length){
            System.out.println("线性表已满，无法再插入元素...");
        }
        int j;
        for(j = curlen;j > i - 1;j --){
            listElem[j] = listElem[j - 1];
        }
        listElem[j] = x;
        this.curlen ++;
    }
    @Override
    public void remove(int i) {
        if(i < 1 || i > curlen){
            System.out.println("删除位置不合法，无法删除元素...");
        }
        if(isEmpty()){
            System.out.println("线性表为空，无法删除元素...");
        }
        for(int j = i-1;j < curlen;j++){
            listElem[j] = listElem[j+1];
        }
        this.curlen --;
    }
    @Override
    public int indexOf(Object x) {
        for(int i=0;i<curlen;i++){
            if(x.equals(listElem[i]))
                return i+1;
        }
        return -1;
    }
    @Override
    public Object get(int i) {
        return listElem[i-1];
    }
    @Override
    public void display() {
        if(isEmpty()){
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for(int i=0;i<curlen-1;i++){
            System.out.print(listElem[i]+",");
        }
        System.out.println(listElem[curlen-1]+"]");
    }
}
