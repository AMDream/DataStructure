package dream.linearlist.sequencelist;

/**
 * Created by Dream on 2018/2/28.
 */
public class SqMain {
    public static void main(String[] args){
        SequenceList sl = new SequenceList(8);
        sl.insert(2);
        sl.insert(3);
        sl.insert(4);
        sl.insert(2,5);
        sl.remove(2);
        sl.display();
    }
}
