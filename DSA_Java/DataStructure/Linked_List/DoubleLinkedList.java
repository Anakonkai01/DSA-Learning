import java.util.List;

class New_ListNode{
    int data;
    New_ListNode next;
    New_ListNode prev;
}

public class DoubleLinkedList {
    private New_ListNode head;
    private New_ListNode tail;

    public DoubleLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void push(int data){
        New_ListNode newNode = new New_ListNode();
        newNode.data = data;

        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void append(int data){
        New_ListNode newNode = new New_ListNode();
        newNode.data = data;

        if(tail == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void printList(){
        New_ListNode temp1 = head;
        New_ListNode temp2 = tail;
        while(temp1!= null){
            System.out.println(temp1.data + " ");
            temp1 = temp1.next;
        }

        System.out.println();

        while(temp2 != null){
            System.out.println(temp2.data + " ");
            temp2 = temp2.prev;
        }
    }

    public static void PrintList(New_ListNode head){
        New_ListNode temp1 = head;
        while(temp1 != null){
            System.out.println(temp1.data + " ");
            temp1 = temp1.next;
        }
    }
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.push(1);
        list.push(0);
        list.append(2);
        list.append(3);

        //list.printList();

        New_ListNode newHead = new New_ListNode();
        New_ListNode newTail = new New_ListNode();
        New_ListNode temp = list.head;

        while(temp != null){
            New_ListNode newNode = new New_ListNode();
            newNode.data = temp.data;

            newHead.next = newNode;
            newNode.prev = newTail;
            newTail = newNode;
            temp = temp.next;
        }

        PrintList(newHead);
    }
}