package SinglyLinkedList;

public class SinglyLinkedList {
    private ListNode head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // them phan tu vao dau danh sach
    public void push(int data){
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    // them phan tu vao cuoi danh sach
    public void append(int data){
        ListNode newNode= new ListNode(data);
        if(head == null){
            head = newNode;
            return ;
        }
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // in danh sach
    public void printList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(); // Thêm dòng này để xuống dòng sau khi in xong danh sách
    }

    public ListNode copyLinkedList(ListNode head){
        if(head == null){
            return head;
        }

        ListNode newTail = null;
        ListNode newHead = null;
        ListNode temp = head;
        while(temp != null){
            ListNode newNode = new ListNode(temp.data);
            if(newTail == null){
                newTail = newNode;
                newHead = newNode;
            }
            else{
                newTail.next = newNode;
                newTail = newTail.next;
            }
            temp = temp.next;
        }
        return newHead;
    }


    // tim kick thuoc cua danh sach
    public int size(){
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }


    public static void printList(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    // Delete the first element in the list
    public void deleteFirstElement() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    // Delete the last element in the list
    public void deleteLastElement() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        ListNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }


    // xoa phan tu theo gia tri
    public void deleteNodethatHaveData(int data){
        if(head == null){
            return;
        }

        if(head.data == data){
            head = head.next;
            return;
        }

        ListNode current = head;
        ListNode prev = null;

        while(current != null && current.data != data){
            prev = current;
            current = current.next;
        }

        if(current == null){
            return;
        }

        prev.next = current.next;
    }

    public void reverseList(){
        ListNode current = head;
        ListNode prev = null;
        ListNode next;

        while(current.next != null){
            next = current.next;
            current.next = prev; // dao chieu
            prev = current; // di chuyen con tro prev len tiep theo
            current = next;
        }
    }

    public SinglyLinkedList mergeLists(SinglyLinkedList list1, SinglyLinkedList list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        SinglyLinkedList mergedList = new SinglyLinkedList();

    }


    // merge list 2 to list 1
    public void addList(SinglyLinkedList list){
        ListNode temp = list.head;
        if(temp == null){
            return;
        }

        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
        }

        tail.next = list.head;
    }
    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.push(1);
        list1.push(0);
        list1.append(2);
        list1.append(3);
        System.out.println("Danh sách 1:");
        list1.printList();

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.append(4);
        list2.append(5);
        list2.append(6);

        System.out.println("Danh sách 2:");
        list2.printList();

        System.out.println("after merge");
        list1.addList(list2);
        list1.printList();
    }
}
