


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class ListNode{
    int data;
    ListNode next;
    public ListNode(){
        this.next = null;
    }
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
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
        System.out.println();
    }

    public static void printList(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr+" ");
            curr = curr.next;
        }
        System.out.println();
    }
    
    public static void printList(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
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
    public static void reoderList(ListNode headNode){
        if(headNode == null || headNode.next == null){
            return ;
        }
        // slow and fast pointer
        ListNode slow = headNode;
        ListNode fast = headNode;

        // Nếu fast là null, độ dài là chẵn
        // Nếu fast không null, độ dài là lẻ
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp1 = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode next = null;
        while(temp1 != null){
            next = temp1.next;
            temp1.next = prev;
            prev = temp1;
            temp1 = next;
        }
        
        
        ListNode secondPtr = prev;
        ListNode firstPtr = headNode;
        while(secondPtr != null){
            ListNode firstNext = firstPtr.next;
            ListNode secondNext = secondPtr.next;
            firstPtr.next = secondPtr;
            secondPtr.next = firstNext;
            firstPtr = firstNext;
            secondPtr = secondNext;
        }
        // uong ly nuoc dua 
    }


    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode right = head;
        ListNode left = dummy;

        while(n > 0){
            right = right.next;
            n--;
        }

        while(right != null){
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return dummy.next;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        int carry = 0;

        ListNode temp = dummy;
        while(l1 != null || l2 != null || carry != 0){
            int x = (l1 != null) ? l1.data : 0;
            int y = (l2 != null) ? l2.data : 0;
            int sum = carry + x + y;
            carry = sum/10;
            ListNode newNode = new ListNode(sum%10);
            temp.next = newNode;
            temp = temp.next;

            l1 = (l1 != null)? l1.next : l1;
            l2 = (l2 != null)? l2.next : l2;
        }

        return dummy.next;
    }


    public static boolean hasCycle(ListNode head){
        // dung slow fast pointer
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            if(fast == slow) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }


    public static int findDuplicate(int [] nums){
        // int fast = nums[0];
        // int slow 
        // chua hieu lam ve thuat toan nay
        return -1;
    }

    public static Node copyRandomList(Node head){
        Node dummy = new Node(0);
        Node tempDummy = dummy;
        Node temp = head;
        while(temp != null){
            Node newNode = new Node(temp.val);
            // Node newNodeRandom = new Node()
            tempDummy.next = newNode;
            tempDummy = tempDummy.next;
            temp = temp.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Tạo một danh sách liên kết mẫu
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        printList(node1);
        Node returnNode = copyRandomList(node1);
        printList(returnNode);
        
    }

}

