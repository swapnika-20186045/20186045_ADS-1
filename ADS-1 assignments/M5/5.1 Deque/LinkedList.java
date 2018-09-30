class LinkedList {
    private Node head;
    private Node tail;
    public int size;
    
    private class Node {
        private int data;
        private Node next;
    }
     LinkedList() {
        head = null;
        tail = null;
    }
     public void insertfront(final int data){
        if (head == null) {
            Node oldHead = head;
            head = new Node();
            head.data = data;
            head.next = null;
            tail = head;
        } else {
            Node oldHead = head;
            head = new Node();
            head.data = data;
            head.next = oldHead;
        }
        size++;
    }
    public void insertend(final int data){
        if (tail == null) {
            Node oldTail = tail;
            tail = new Node();
            tail.data = data;
            tail.next = null;
            head = tail;
        }
        else {
            Node oldTail = tail;
           tail = new Node();
           tail.data = data;
           tail.next = null;
           oldTail.next = tail;
        }
        size++;
    }
    public void deletefront(){
        if (head != null) {
            head = head.next;
            size--;
        }
    }
     public void deleteend(){
        if (tail != null) {
            Node temp = null;
            Node temp1 = tail;
            Node head1 = head;
            while (head1 != tail){
                temp = head1;
                head1 = head1.next;
            } 
            tail = temp;
            tail.next = null;
            size--;
        }
    }
    public boolean isEmpty() {
        return head == null;
    }
    public int size() {
        return size;
    }
     public String toString() {
        if (size != 0) {
            String str = "[";
            Node temp = head;
            while (temp != null) {
                str += temp.data + ", ";
                temp = temp.next;
            }
            return str.substring(0, str.length() - 2) + "]";
        }
        return "[]";
    }
}