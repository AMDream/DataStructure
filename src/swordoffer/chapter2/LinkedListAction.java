package swordoffer.chapter2;

import java.util.Arrays;

/**
 * Created by Dream on 2018/3/7.
 */
class Node{
    int value;
    Node next;
    public Node(int value,Node next){
        this.value = value;
        this.next = next;
    }
    public Node(int value){
        this(value,null);
    }
}
public class LinkedListAction {
    public void AddToTail(Node head,int value){
        if (head == null)
            head = new Node(value);
        Node pNode = head;
        while(pNode != null && pNode.next != null){
            pNode = pNode.next;
        }
        Node tail = new Node(value);
        pNode.next = tail;
    }
    public void deleteNode(Node head,int value){
        if (head == null)
            return;
        if (head.value == value)
            head = head.next;
        Node prev = head,curr = head.next;
        while(curr != null){
            if(curr.value == value){
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
    }
    public static void main(String[] args){
        int[] a = new int[]{1,2,3,4};
        int[] b = Arrays.copyOfRange(a,0,0);
        System.out.println(Arrays.toString(b));  //[]
        System.out.println(b.length);  //0
    }
}
