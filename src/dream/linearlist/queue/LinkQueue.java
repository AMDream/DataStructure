package dream.linearlist.queue;

/**
 * 队列：使用链表实现
 */
class Node{
    Object data;
    Node next;
    public Node(Node next,Object data){
        this.next = next;
        this.data = data;
    }
    public Node(Object data){
        this(null,data);
    }
    public Node(){
        this(null,null);
    }
}
public class LinkQueue {
    private Node front;
    private Node rear;
    public LinkQueue(){
        front = rear = null;
    }
    public boolean isEmpty(){
        return front == null;
    }
    public void addQ(Object o){
        Node newNode = new Node(o);
        //如果是空队列，头和尾均指向新节点
        if(front == null){
            front = rear = newNode;
            return;
        }
        //否则新节点增加至尾指针后，同时尾指针后移，指向新增的节点
        rear.next = newNode;
        rear = newNode;
    }
    public Object deleteQ(){
        //如果队列为空
        if(front == null){
            System.out.println("队列为空，不能再出列...");
            return null;
        }
        //如果队列只有一个元素
        Node curr = front;
        if(front == rear && rear != null){
            front = rear = null;
        }
        front = front.next;
        return curr.data;
    }
    public void display(){
        Node tem = front;
        while(tem != rear){
            System.out.print(tem.data+" ");
            tem = tem.next;
        }
        System.out.println(rear.data);
    }
    public static void main(String[] args){
        LinkQueue lq = new LinkQueue();
        lq.addQ(2);
        lq.addQ(3);
        lq.addQ(4);
        lq.addQ(5);
        lq.deleteQ();
        lq.display();
        System.out.println(lq.isEmpty());
    }
}
