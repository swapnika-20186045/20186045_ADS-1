 class Queue {
    LinkedList l;
    int size;
     Queue() {
        l = new LinkedList();
    }
     void addfront(int number) {
        l.insertfront(number);
    }
     void addend(int number) {
        l.insertend(number);
    }
     void removefront() {
        l.deletefront();
    }
     void removeend() {
        l.deleteend();
    }
     int size() {
        return l.size();
    }
     String print() {
        return l.toString();
    }
     boolean isEmpty() {
        return l.isEmpty();
    }
}
