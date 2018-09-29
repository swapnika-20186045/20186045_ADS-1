class Stack {
    Node first = null;
    int size = 0;
    
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void push(int n) {
        Node newnode = new Node(n);
        newnode.next = first;
        first = newnode;
        size++;
    }
    public int pop() {
        int item = first.data;
        first = first.next;
        size--;
        return item;
    }
    public void printList() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}