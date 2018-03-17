package dream.linearlist.linkedlist;

import dream.linearlist.IList;

/**
 * 带头结点的单向列表
 */
public class MyLinkedList implements IList {
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    private Node head; //头节点
    public MyLinkedList(){
        head = null;  //头节点为空
    }
    @Override
    public boolean isEmpty() {
        return head == null;
    }
    @Override
    public void clear() {
        head = null;
    }
    @Override
    public int length() {
        Node p = this.head.getNext();
        int len = 0;
        while(p != null){
            len++;
            p = p.getNext();
        }
        return len;
    }
    //尾插法
    @Override
    public void insert(Object x) {
        Node newNode = new Node(x);
        if(isEmpty()){
            head = newNode;
            return;
        }
        Node n = head;
        while(n.getNext() != null){
            n = n.getNext();
        }
        n.setNext(newNode);
    }
    //头插法
    public void headInsert(Object x){
        Node newNode = new Node(x);
        if(isEmpty()) {
            head = newNode;
            return;
        }
        newNode.setNext(head);
        head = newNode;
    }

    @Override
    public void insert(int i, Object x) {
        Node p = head;
        //首先找到第i个位置的前驱，即第i-1个位置
        int j = 1;
        while(p != null && j < i-1){
            p = p.getNext();
            j++;
        }
        if(j != i-1 || p == null){
            System.out.println("插入位置不合法...");
        }
        Node nn = new Node(x);
        nn.setNext(p.getNext());
        p.setNext(nn);
    }

    @Override
    public void remove(int i) {
        Node p = head;
        //找到第i-1个位置
        int j = 1;
        while(p != null && j < i-1){
            p = p.getNext();
            j++;
        }
        if(j != i-1 || p == null){
            System.out.println("移除位置不合法...");
        }
        p.setNext(p.getNext().getNext());
    }
    @Override
    public int indexOf(Object x) {
        //p指向头节点，j是计数器
        Node p = head;
        int j = 1;
        while(p != null && !x.equals(p.getData())){
            p = p.getNext();
            j++;
        }
        //如果p指向null，则表示未找到，返回-1
        if(p == null)
            return -1;
        else
            return j;
    }

    @Override
    public Object get(int i) {
        Node p = head;
        int j = 1;
        while(j<i && p!=null){
            p = p.getNext();
            j++;
        }
        if(p == null || i < 1){
            return null;
        }
        return p.getData();
    }

    @Override
    public void display() {
        Node p = head;
        while(p != null){
            System.out.print(p.getData()+" ");
            p = p.getNext();
        }
        System.out.println();
    }

    /**
     * 翻转链表：需要三个变量用于记录遍历时的当前节点pNode，当前节点的前驱pPrev，当前节点的后继pNext
     * @param head 旧链表的头节点
     * @return  新列表的头节点
     */
    public Node reverseNode(Node head){
        Node pReverseHead = head;
        Node pNode = head;   //从头节点开始遍历
        Node pPrev = null;   //当前节点的前驱
        while(pNode != null){
            Node pNext = pNode.getNext();  //当前节点的后继
            if(pNext == null){
                pReverseHead = pNode;
            }
            pNode.setNext(pPrev);  //使得当前节点的后继指向原来的前驱节点
            //以下实现前驱节点和当前节点向后移
            pPrev = pNode;
            pNode = pNext;
        }
        this.head = pReverseHead;
        return this.head;
    }

    /**
     * 查找单向链表的中间节点思想：
     * 采用快慢指针，快指针每次走两步，慢指针每次走一步，当快指针走完时，慢指针刚好走一半
     * @return   链表的中间节点
     */
    public Node searchMid(){
        Node fNode = this.head;
        Node sNode = this.head;
        while(fNode != null && fNode.getNext() != null && fNode.getNext().getNext() != null){
            fNode = fNode.getNext().getNext();
            sNode = sNode.getNext();
        }
        System.out.println(sNode.getData());
        return sNode;
    }

    /**
     *查找倒数第k个元素
     * 思想：需要两个引用p1,p2，p1先移动k步，然后p1,p2同时移动，直到p1移动到链表末尾，p2指向的则为倒数第k个元素
     * @param k
     * @param head
     * @return
     */
    public Node findLastElem(int k,Node head){
        if(k < 1 || k >this.length()){
            System.out.println("查找位置不对...");
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        for(int i=0;i<k;i++)  //前移k步
            p1 = p1.getNext();
        while(p1 != null){
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        System.out.println(p2.getData());
        return p2;
    }
    /**
     *单向链表递增排序
     * 思想：遍历链表，并将当前的节点与其后的所有节点值的大小进行比较
     * @return
     */
    public Node orderList(){
        Node nextNode = null;
        Node curNode = head;
        Object temp;
        while(curNode.getNext() != null){  //外层遍历
            nextNode = curNode.getNext();
            while(nextNode != null){  //内层遍历当前节点之后的节点，与当前节点值进行大小比较，如果比当前节点值小则进行互换
                int cur =(Integer) curNode.getData();
                int next =(Integer) nextNode.getData();
                if(cur > next){
                    temp = curNode.getData();
                    curNode.setData(nextNode.getData());
                    nextNode.setData(temp);
                }
                nextNode = nextNode.getNext();
            }
            curNode = curNode.getNext();
        }
        return head;
    }

    /**
     * 删除单向链表中重复的节点
     * 思想：遍历整个链表，将当前的节点与其后的所有节点进行比较，如果相同则删除。
     * 需要两个引用，p用于外层循环中指向当前节点的，ppp用于内层循环中
     * @param head
     */
    public void deleteDuplicateNode(Node head){
        Node p = head;
        while(p != null){
            Node ppp = p;
            while(ppp.getNext() != null){  //判断当前节点的下一个节点是否为空
                if(p.getData().equals(ppp.getNext().getData())){  //不为空则判断值是否相同。此时节点ppp先不移动
                    ppp.setNext(ppp.getNext().getNext());
                }else{
                    ppp = ppp.getNext();
                }
            }
            p = p.getNext();
        }
    }
    /**
     * 利用递归从尾到头依次输出单向链表的元素
     * @param p
     */
    public void printReverseList(Node p){
        if(p != null){
            printReverseList(p.getNext());   //直到p为null，则表示链表到了尾端
            System.out.print(p.getData()+" ");
        }
    }

    /**
     * 判断链表是否有环
     * 思想：两个引用，一个快引用，一个慢引用，如果两个引用经过若干次循环之后指向同一个节点，则证明有环
     * （类似于：两个运动员赛跑，一个跑得快，一个跑得慢，两人跑了一段时间，速度快的运动员必然会从
     * 速度慢的运动员身后再次追上并超过，原因很简单，因为跑道是环形的。）
     * @param head
     * @return
     */
    public boolean isLoop(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(fast == slow) {
                System.out.println("该链表有环");
                return true;
            }
        }
        return !(fast == null || fast.getNext() == null);
    }

    /**
     *找出链表的入环口
     * 将慢指针（或快指针）移到链表起点，两者同时移动，每次移动一步，那么两者相遇的地方就是环的起点
     * 解释：假设起点到环的起点距离为m，已经确定有环，环的周长为n，（第一次）相遇点距离环的起点的距离是k。
     * 那么当两者相遇时，慢指针移动的总距离为i，i = m + a * n + k，因为快指针移动速度为慢指针的两倍，
     * 那么快指针的移动距离为2i，2i = m + b * n + k。其中，a和b分别为慢指针和快指针在第一次相遇时转过的圈数。
     * 我们让两者相减（快减慢），那么有i = (b - a) * n。即i是圈长度的倍数。利用这个结论我们就可以理解
     * Floyd解法为什么能确定环的起点。将一个指针移到链表起点，另一个指针不变，即距离链表起点为i处，两者同时移动，
     * 每次移动一步。当第一个指针前进了m，即到达环起点时，另一个指针距离链表起点为i + m。考虑到i为圈长度的倍数，
     * 可以理解为指针从链表起点出发，走到环起点，然后绕环转了几圈，所以第二个指针也必然在环的起点。即两者相遇点就是环的起点。
     * @param head
     */
    public Node findLoopEnter(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(slow == fast)
                break;
        }
        if(fast == null || fast.getNext() == null) //该链表无环
            return null;
        //表明有环,slow指向head，与fast再次相遇的节点即为入环口
        slow = head;
        while(slow != fast){
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return slow;
    }
    /**
     * 求环的长度
     * 当快慢指针相遇时，继续移动直到第二次相遇，此时快指针移动的距离正好比慢指针多一圈
     * @return
     */
    public int LoopLength(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(slow == fast)
                break;
        }
        if(fast == null || fast.getNext() == null)
            return -1;  //无环
        int len = 0;
        while(fast != null && fast.getNext() != null){
            len++;
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(fast == slow)
                break;
        }
        return len;
    }
}
