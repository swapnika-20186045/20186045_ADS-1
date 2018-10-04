/**
 * Class for node.
 */
class Node {
    /**
     * declaration for data.
     */
    String data;
    /**
     * declaration for next.
     */
    Node next;
    /**
     * Constructs the object.
     */
    Node() {
        //empty constructor.
    }
    /**
     * Constructs the object.
     *
     * @param      data  The data
     */
    Node (String data) {
        this.data = data;
    }
}
/**
 * List of linkeds.
 */
class LinkedList {
    /**
     * declaration of head.
     */
    private Node head;
    /**
     * declaration of size.
     */
    private int size;
    /**
     * Constructs the object.
     */
    LinkedList() {
        head = null;
        size = 0;
    }
    /**
     * insert at position.
     * order of time complexity is N.
     *
     * @param      position        The position
     * @param      data       The data
     *
     * @throws     Exception  { exception_description }
     */
    public void insertAt(int position, String data) throws Exception{
        Node newNode = new Node(data);
        if (position < 0 || position > size) {
            throw new Exception("Can't insert at this position.");
        }
        head = insertAt(position, head, newNode, 0);
    }
    /**
     * insert at position.
     * order of time complexity is N.
     *
     * @param      position    The position
     * @param      first  The first
     * @param      object    The object
     * @param      count  The count
     *
     * @return     { description_of_the_return_value }
     */
    Node insertAt(int position, Node first, Node object, int count) {
        if (position == count) {
            object.next = first;
            size++;
            return object;
        }
        first.next = insertAt(position, first.next, object, ++count);
        return first;
    }
    /**
     * reverse the linkedlist.
     * order of time complexity is N.
     *
     * @throws     Exception  { exception_description }
     */
    public void reverse() throws Exception{
        if (size == 0) {
            throw new Exception("No elements to reverse.");
        }
        reverse(null, head);
    }
    /**
     * reverse the linkedlist.
     * order of time complexity is N.
     *
     * @param      previous  The previous
     * @param      current   The current
     */
    public void reverse(Node previous, Node current) {
        if (current != null) {
            reverse(current, current.next);
            current.next = previous;
        } else {
            head = previous;
        }
    }
    /**
     * Returns a string representation of the object.
     * order of time complexity is N.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size != 0) {
            String str = "";
            Node temp = head;
            while (temp != null) {
                str += temp.data + ", ";
                temp = temp.next;
            }
            return str.substring(0, str.length() - 2);
        }
        return "[]";
    }
}
