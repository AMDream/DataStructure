package dream.linearlist.example;

/**
 *多项式的加法运算实现
 * Polynomial是存放多项式的每项的节点：指数和系数及指向下一项的节点
 */
class Polynomial{
    int expo;  //指数
    int coef;  //系数
    Polynomial next;
    public Polynomial(int expo,int coef,Polynomial next){
        this.expo = expo;
        this.coef = coef;
        this.next = next;
    }
    public Polynomial(int expo,int coef){
        this(expo,coef,null);
    }
    public Polynomial(){
        this(0,0,null);
    }
}

/**
 * 多项式类
 */
public class PolyExpress {
    private Polynomial head;
    private int size;
    public PolyExpress(){
        head = null;
        size = 0;
    }
    public Polynomial getHead() {
        return head;
    }
    public void setHead(Polynomial head) {
        this.head = head;
    }

    /**
     * 增加节点的时候是按照系数的递减顺序排列的
     * @param expo
     * @param coef
     */
    public void insert(int expo, int coef){
        Polynomial node = new Polynomial(expo,coef);
        //如果是空链表，直接让头节点指向新增的节点
        if (head == null){
            head = node;
            size++;
            return;
        }
        Polynomial prev = null;
        Polynomial curr = head;
        //遍历，直到找到待插入节点应该插入的位置
        while(curr != null && curr.expo > expo){
            //prev记录插入位置的前驱节点
            prev = curr;
            curr = curr.next;
        }
        node.next = curr;
        if(prev != null){
            prev.next = node;
        }else{ //表明插入的是第一个位置
            head = node;
        }
        size++;
    }
    /**
     * 两个多项式相加
     * 思路：p1和p2分别指向两个多项式链表，依次比较指向的节点的系数，其中系数大的一项作为相加后的结果的一项，此时指向该系数的节点后移；
     * 如果两个节点的指数相同，则系数相加，如果为0，则p1、p2均后移；否则new一个新的节点，并让该节点加入相加后的结果
     * @param p1
     * @param p2
     * @return
     */
    public static Polynomial PolyAdd(Polynomial p1,Polynomial p2){
        Polynomial p3 = new Polynomial();
        Polynomial head = p3;
        while(p1 != null && p2 != null){
            if(p1.expo > p2.expo){
                p3.next = p1;
                p3 = p3.next;
                p1 = p1.next;
            }else if(p1.expo < p2.expo){
                p3.next = p2;
                p3 = p3.next;
                p2 = p2.next;
            }else{
                int result = p1.coef + p2.coef;
                if(result != 0){
                    Polynomial node = new Polynomial(p1.expo,result);
                    p3.next = node;
                    p3 = p3.next;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        if(p1 != null){
            p3.next = p1;
        }
        if(p2 != null){
            p3.next = p2;
        }
        head = head.next;
        return head;
    }
    public void display(){
        Polynomial node = head;
        while(node != null && node.next != null){
            System.out.print(node.coef+"X^"+node.expo+"+");
            node = node.next;
        }
        System.out.println(node.coef+"X^"+node.expo);
    }
    public static void main(String[] args){
        PolyExpress pe1 = new PolyExpress();
        pe1.insert(5,2);
        pe1.insert(6,6);
        pe1.insert(4,2);
        pe1.insert(2,9);
        pe1.display();
        PolyExpress pe2 = new PolyExpress();
        pe2.insert(2,2);
        pe2.insert(5,6);
        pe2.insert(4,-2);
        pe2.insert(3,9);
        pe2.display();
        Polynomial p3 = PolyExpress.PolyAdd(pe1.getHead(),pe2.getHead());
        Polynomial node = p3;
        while(node != null && node.next != null){
            System.out.print(node.coef+"X^"+node.expo+"+");
            node = node.next;
        }
        System.out.println(node.coef+"X^"+node.expo);
    }
}
