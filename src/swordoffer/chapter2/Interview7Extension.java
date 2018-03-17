package swordoffer.chapter2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈
 * 入栈操作直接将元素入一个队列
 * 出队的时候，由于是先进先出，而栈弹出的元素是栈顶元素，在队列中就是队列的最后一个元素，所以需要将队列的n-1个元素出队列到另一个队列中
 * 最后出队列的第n个元素则是弹栈的元素。
 * 其中每次入栈的元素都入队列1，所以每次弹栈时，都是从队列1开始出队列直到最后一个元素
 * 如果队列1为空，则对队列2实现同样的操作
 */
public class Interview7Extension {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public void push(int x){
        q1.offer(x);
    }
    public int poll(){
        int out = -1;
        if(q1.isEmpty() && q2.isEmpty())
            return out;
        else if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                out = q1.poll();
                if(!q1.isEmpty())
                    q2.offer(out);
            }
        }else if(!q2.isEmpty()){
            while (!q2.isEmpty()){
                out = q2.poll();
                if(!q2.isEmpty())
                    q1.offer(out);
            }
        }
        System.out.println(out);
        return out;
    }
    public static void main(String[] args){
        Interview7Extension i7 = new Interview7Extension();
        i7.push(1);
        i7.push(2);
        i7.push(3);
        i7.poll();
        i7.push(4);
        i7.push(5);
        i7.poll();
        i7.poll();
        i7.poll();
        i7.poll();
    }
}
