package dream.linearlist.queue;

/**
 * 队列：底层用数组实现
 * 规定队列使用数组的n-1个空间
 */
public class ArrQueue {
    private int front,rear;
    private Object[] queue;
    private int maxSize;
    public ArrQueue(int maxSize){
        this.maxSize = maxSize;
        queue = new Object[maxSize];
    }
    public boolean isEmpty(){
        return front == rear;
    }
    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }
    public void addQ(Object o){
        if((rear + 1)% maxSize == front){
            System.out.println("队列已满，不能再入列...");
            return;
        }
        rear = (rear + 1) % maxSize;
        queue[rear] = o;
    }
    public Object deleteQ(){
        if(front == rear){
            System.out.println("队列为空，不能再出列...");
            return null;
        }
        front = (front + 1) % maxSize;
        return queue[front];
    }
    public void display(){
        for(int i = front + 1;i <= rear || i < (rear + 1) % maxSize;i ++){
            System.out.print(queue[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        ArrQueue aq = new ArrQueue(6);
        aq.addQ(2);
        aq.addQ(3);
        aq.addQ(4);
        aq.addQ(5);
        aq.deleteQ();
        aq.display();
        System.out.println(aq.isEmpty());
    }
}
