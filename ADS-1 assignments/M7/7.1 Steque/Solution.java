/**
 * Steque.
 * @author Swapnika Vakacharla.
 */
import java.util.Scanner;
/**
 * Class for steque.
 */
class Steque {
    /**
     * declaration of head.
     */
    private Node head;
    /**
     * declaration of tail.
     */
    private Node tail;
    /**
     * declaration of size.
     */
    private int size;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * declaration of data.
         */
        private int data;
        /**
         * declaration of next.
         */
        private Node next;
        /**
         * initializing size.
         */
        private int size = 0;
    }

    /**
     * Constructs the object.
     * Order of time complexity for Steque() is 1.
     */
    Steque() {
        head = null;
        tail = null;
    }

    /**
     * enqueue method.
     * Order of time complexity for enqueue() is constant.
     * @param      data  The data
     */
    public void enqueue(final int data) {
        Node temp = new Node();
        if (tail == null || head == null) {
            temp.data = data;
            temp.next = null;
            head = temp;
            tail = temp;
        } else {
            Node oldtail = tail;
            temp.data = data;
            temp.next = null;
            oldtail.next = temp;
            tail = temp;
        }
        size++;
    }

    /**
     * pushs the element.
     * Order of time complexity for push() is constant.
     * @param      data  The data
     */
    public void push(final int data) {
        // Node old = head;
        // head = new Node(data, old);
        // if(old == null) {
        //     tail = head;
        // }
        Node newnode = new Node();
        if (head == null) {
            newnode.data = data;
            newnode.next = null;
            head = newnode;
            tail = newnode;
        } else {
            Node oldHead = head;
            newnode.data = data;
            newnode.next = oldHead;
            head = newnode;
        }
        size++;
    }

    /**
     * pops the element.
     * Order of time complexity for pop() is constant.
     * @return     { description_of_the_return_value }
     */
    public int pop() {
        // if (head.next == null && tail.next == null) {
        //     head = tail = null;
        //     size--;
        // } else if (head != null) {
        //     head = head.next;
        //     size--;
        // }
        if (head != null) {
            int value = head.data;
            head = head.next;
            size--;
            return value;
        }
        return 0;
    }

    /**
     * returns size.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }

    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return head == null || tail == null;
    }

    /**
     * Returns a string representation of the object.
     * Order of time complexity for toString() is n.
     * n is size of the list.
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
        return "";
    }
}

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //empty constructor.
    }
    /**
     * Client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            Steque sq = new Steque();
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                case "push":
                    sq.push(Integer.parseInt(tokens[1]));
                    System.out.println(sq.toString());
                    break;

                case "pop":
                    sq.pop();
                    if (sq.isEmpty()) {
                        System.out.println("Steque is empty.");
                    } else {
                        System.out.println(sq.toString());
                    }
                    break;

                case "enqueue":
                    sq.enqueue(Integer.parseInt(tokens[1]));
                    System.out.println(sq.toString());
                    break;

                default:
                    sq = new Steque();
                    System.out.println();
                    break;
                }

            }
        }
    }
}
