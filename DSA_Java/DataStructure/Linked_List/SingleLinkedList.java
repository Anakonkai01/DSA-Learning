

class ListNode{
    int data;
    ListNode next;
}

public class SingleLinkedList {
    private ListNode head;
    private ListNode tail;
    public SingleLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void push(int data){
        ListNode newNode = new ListNode();
        newNode.data = data;
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    }

    public void append(int data){
        ListNode newNode = new ListNode();
        newNode.data = data;
        if(tail == null){
            head = newNode;
        }
        else{
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void printList(){
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }

    // reverseSingle
    public void reverseList(){
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while(current != null){
            next = current.next;
            current.next = prev; // dao nguoc chieu con tro
            prev = current; // di chuyen con tro prev len
            current = next; // di chuyen con tro curr len tiep de thuc hien viec dao chieu
        }
        head = prev; // luc nay
    }

    // test
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.append(4);
        list.append(5);
        list.printList();

        list.reverseList();
        System.out.println();
        list.printList();
    }
}


