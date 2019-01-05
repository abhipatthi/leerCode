class ReverseLinkedList {

    static Node head;
    class Node{
        int val;
        Node next;
        Node(int x) { val = x; }
    }


    public Node reverseList(Node head) {
        if(head==null||head.next==null)
        return head;
 
        Node prev, curr, nxt;
        prev = null;
        curr = head;
        nxt = curr.next;
        
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = nxt;
            if(nxt != null){
                nxt = nxt.next;
            }
        }
        return prev;
    }

    /* Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = this.head;
        this.head = newNode;
    }

    
    /* Print the list */
    public void printList(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.val+"->");
            curr = curr.next;
        }
        System.out.println("");
    }
    

    public static void main(String[] args){

        ReverseLinkedList list = new ReverseLinkedList();
        list.addAtHead(5);
        list.addAtHead(4);
        list.addAtHead(3);
        list.addAtHead(2);
        list.addAtHead(1);
        list.printList(head);
        
        list.printList(list.reverseList(head));
    }
}
