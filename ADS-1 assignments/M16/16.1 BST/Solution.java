/**
 * Binary search tree.
 * @author Swapnika Vakacharla.
 */
import java.util.Scanner;
/**
 * Class for book.
 */
class Book implements Comparable<Book> {
    /**
     * declaration of book name.
     */
    private String name;
    /**
     * declaration of author name.
     */
    private String author;
    /**
     * declaration of price.
     */
    private String price;
    /**
     * Constructs the object.
     *
     * @param      namee    The namee
     * @param      authorr  The authorr
     * @param      pricee   The pricee
     */
    Book(final String namee, final String authorr, final String pricee) {
        this.name = namee;
        this.author = authorr;
        this.price = pricee;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    String getName() {
        return name;
    }
    /**
     * Gets the author.
     *
     * @return     The author.
     */
    String getAuthor() {
        return author;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    String getPrice() {
        return price;
    }
    /**
     * compares the names.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Book that) {
        return this.name.compareTo(that.name);
    }
}
/**
 * Class for binary search tree.
 */
class BinarySearchTree {
    /**
     * declaration of root.
     */
    private Node root;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * declaration of key.
         */
        private Book key;
        /**
         * declaration of value.
         */
        private String val;
        /**
         * declaration of left node.
         */
        private Node left;
        /**
         * declaration of right node.
         */
        private Node right;
        /**
         * Constructs the object.
         *
         * @param      keyy   The key
         * @param      vall   The value
         */
        Node(final Book keyy, final String vall) {
            this.key = keyy;
            this.val = vall;
        }
    }
    /**
     * Constructs the object.
     */
    BinarySearchTree() {
        root = null;
    }

    /**
     * Inserts the specified key-value pair into the symbol table,
     * overwriting the old value with the new value if the symbol table
     * already contains the specified key. Deletes the specified key
     * (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(final Book key, final String val) {
        if (key == null) {
            throw new IllegalArgumentException(
                "calls put() with a null key");
        }
        root = put(root, key, val);
    }
    /**
     * Inserts the specified key-value pair into the symbol table,
     * overwriting the old value with the new value if the symbol table
     * already contains the specified key and root.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     * @param      val   The value
     *
     * @return     { description_of_the_return_value }
     */
    private Node put(final Node x, final Book key, final String val) {
        if (x == null) {
            return new Node(key, val);
        }
        int cmp = key.getName().compareTo(x.key.getName());
        if (cmp < 0) {
            x.left  = put(x.left,  key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else if (cmp == 0) {
            x.val = val;
        }
        return x;
    }
    /**
     * Returns the value associated with the given key.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public String get(final Book key) {
        Node x = root;
        while (x != null) {
            int cmp = key.getName().compareTo(x.key.getName());
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else if (cmp == 0) {
                return x.val;
            }
        }
        return null;
    }
}
/**
 * class for Solution.
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
        BinarySearchTree bst = new BinarySearchTree();
        while (scan.hasNext()) {
            String[] input = scan.nextLine().split(",");
            switch (input[0]) {
            case "put":
                Book key = new Book(input[1], input[2], input[2 + 1]);
                bst.put(key, input[2 + 2]);
                break;
            case "get":
                key = new Book(input[1], input[2], input[2 + 1]);
                System.out.println(bst.get(key));
                break;
            default:
                break;
            }
        }
    }
}
