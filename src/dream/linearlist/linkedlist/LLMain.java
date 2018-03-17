package dream.linearlist.linkedlist;

public class LLMain {
    public static void main(String[] args){
        MyLinkedList ll = new MyLinkedList();
        ll.insert(5);
        ll.insert(6);
        ll.insert(6);
        ll.headInsert(2);
        ll.insert(3,8);
        ll.insert(10);
        ll.headInsert(0);
        ll.remove(4);
        ll.display();
        System.out.println("链表第四个位置的值是："+ll.get(4));
        System.out.println("10的位置索引是："+ll.indexOf(10));
        System.out.println("2的位置索引是："+ll.indexOf(2));
        System.out.println("翻转列表");
        ll.reverseNode(ll.getHead());
        ll.display();
        System.out.print("单向列表的中间节点：");
        ll.searchMid();
        System.out.print("单向列表中的倒数第3个节点是：");
        ll.findLastElem(3,ll.getHead());
        System.out.print("单向链表递增顺序排序后：");
        ll.orderList();
        ll.display();
        System.out.println("是否为空："+ll.isEmpty());
        ll.deleteDuplicateNode(ll.getHead());
        System.out.println("删除单向链表中的重复元素：");
        ll.display();
        System.out.print("利用递归从尾带头依次输出单向链表中的元素：");
        ll.printReverseList(ll.getHead());
        System.out.println();
    }
}
