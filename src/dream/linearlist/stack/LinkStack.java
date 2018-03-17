package dream.linearlist.stack;

/**
 * 栈：底层利用链表实现
 * 入栈时我们从表头添加节点（添加节点需要知道节点的前驱），我们不知道表尾节点的前驱节点
 */
class Node{
    Object data;
    Node next;
    public Node(Object data,Node next){
        this.data = data;
        this.next = next;
    }
    public Node(Object data){
        this(data,null);
    }
    public Node(){
        this(null,null);
    }
}
public class LinkStack {
    //记录栈的大小
     private int size;
     //指向栈顶节点
     private Node top;

     public boolean isEmpty(){
         return size == 0;
     }
     public void push(Object o){
         Node newNode = new Node(o);
         newNode.next = top;
         top = newNode;
         size++;
     }
     //出栈要判断栈是否为空
     public Object pop(){
         if(isEmpty()){
             System.out.println("栈为空，不能出栈");
             return null;
         }
         Node temp = top;
         top = top.next;
         temp.next = null;
         size--;
         return temp.data;
     }
     public Object peek(){
         if(isEmpty()){
             System.out.println("栈为空，不能获取栈顶元素");
             return null;
         }
         return this.top.data;
     }
     public void display(){
         Node p = top;
         while(p != null){
             System.out.print(p.data+" ");
             p = p.next;
         }
         System.out.println();
     }

}
