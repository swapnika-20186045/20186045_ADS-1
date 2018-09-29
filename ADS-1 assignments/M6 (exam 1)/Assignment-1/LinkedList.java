class LinkedList {
    Node head = null;
    Node tail = null;
    int size = 0;

    class Node {
        String item;
        Node next;
        Node(String item) {
            this.item = item;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public void push(String str) {
        Node newnode = new Node(str);
        if (isEmpty()) {
            head = newnode;
            tail = head;
            tail.next = null;
            size++;
            return;
        }
        Node old = tail;
        tail = newnode;
        old.next = tail;
        tail.next = null;
        size++;
    }
    
    public String pop() {
        if (isEmpty()) {
            return null;
        }
        String item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
    }
}